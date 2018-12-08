package api.app.service;

import api.app.exception.BadRequestException;
import api.app.model.Characters;
import api.app.repository.CharactersRepository;
import api.app.request.CharactersRequest;
import api.app.response.CharactersResponse;
import api.app.response.PagedResponse;
import api.app.security.UserPrincipal;
import api.app.util.Constants;
import api.app.util.ModelMapper;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CharactersService {
	
	@Autowired
	private CharactersRepository characterRepository;


	public PagedResponse<CharactersResponse> getCharactersByUsers(UserPrincipal currentUser, int page, int size, Long characters) {
		validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		
		Page<Characters> character= (Page<Characters>) characterRepository.findByUserUsernameAndCharactersid(currentUser.getUsername(), characters,pageable);
		
		if(character.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), character.getNumber(),
            		character.getSize(), character.getTotalElements(), character.getTotalPages(), character.isLast());
        }
		
		List<CharactersResponse> charactersResponses = character.map(item -> {
	            return ModelMapper.mapCharactersToCharactersResponse(item);
	        }).getContent();

	        return new PagedResponse<>(charactersResponses, character.getNumber(),
	        		character.getSize(), character.getTotalElements(), character.getTotalPages(), character.isLast());
	}

	private void validatePageNumberAndSize(int page, int size) {
		if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > Constants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Size max: " + Constants.MAX_PAGE_SIZE);
        }		
	}

	public Characters createCharacters(CharactersRequest characterRequest) {
		Characters character = new Characters();
        character.getUser().setId(characterRequest.getUserid());
        character.setCharactersid(characterRequest.getCharactersid());
        return characterRepository.save(character);
    }

	public static Characters createas() {
		// TODO Auto-generated method stub
		return null;
	}


}
