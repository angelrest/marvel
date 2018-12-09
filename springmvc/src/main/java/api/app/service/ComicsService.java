package api.app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import api.app.exception.BadRequestException;

import api.app.model.Comics;

import api.app.repository.ComicsRepository;

import api.app.request.ComicsRequest;

import api.app.response.ComicsResponse;
import api.app.response.PagedResponse;
import api.app.security.UserPrincipal;
import api.app.util.Constants;
import api.app.util.ModelMapper;

public class ComicsService {
	
	@Autowired
	private ComicsRepository comicsRepository;


	public PagedResponse<ComicsResponse> getCharactersByUsers(UserPrincipal currentUser, int page, int size, Long comics, Long characters) {
		validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		
		Page<Comics> comic= comicsRepository.findByCharactersidAndComicsidAndUserid(characters,comics,currentUser.getId(),pageable);
		
		if(comic.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), comic.getNumber(),
            		comic.getSize(), comic.getTotalElements(), comic.getTotalPages(), comic.isLast());
        }
		
		List<ComicsResponse> comicResponse = comic.map(item -> {
	            return ModelMapper.mapComicsToComicsResponse(item);
	        }).getContent();

	        return new PagedResponse<>(comicResponse, comic.getNumber(),
	        		comic.getSize(), comic.getTotalElements(), comic.getTotalPages(), comic.isLast());
	}

	private void validatePageNumberAndSize(int page, int size) {
		if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > Constants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Size max: " + Constants.MAX_PAGE_SIZE);
        }		
	}

	public Comics createComics(ComicsRequest comicsRequest) {
		Comics comics = new Comics();
		comics.setUserid(comicsRequest.getUserid());
		comics.setCharactersid(comicsRequest.getCharactersid());
		comics.setComicsid(comicsRequest.getComicsid());
		comics.setUriimage(comicsRequest.getUriimage());
		comics.setDescription(comicsRequest.getDescription());
        return comicsRepository.save(comics);
    }

}
