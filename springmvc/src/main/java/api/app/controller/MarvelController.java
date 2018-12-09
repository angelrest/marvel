package api.app.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import api.app.payload.ApiResponse;

import api.app.repository.ComicsRepository;

import api.app.request.ComicsRequest;

import api.app.response.ComicsResponse;
import api.app.response.PagedResponse;
import api.app.security.CurrentUser;
import api.app.security.UserPrincipal;

import api.app.service.ComicsService;
import api.app.util.Constants;

@RestController
@RequestMapping("/api/marvel")
public class MarvelController {
	
	@Autowired
	private ComicsService comicsService;
	
	@Autowired
    private  ComicsRepository comicsRepository;
	
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public PagedResponse<ComicsResponse> getComics(@CurrentUser UserPrincipal currentUser,
                                                @RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size,
                                                @RequestParam(value = "characters") Long characters,
                                                @RequestParam(value = "comics") Long comics) {
        return comicsService.getCharactersByUsers(currentUser, page, size,comics, characters);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createComics(@Valid @RequestBody ComicsRequest comicsRequest) {
        int page=0;
        int size=Integer.parseInt(Constants.DEFAULT_PAGE_SIZE);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{page}/{size}/{characters}/{comics}")
                .buildAndExpand(page,size,comicsRequest.getCharactersid(),comicsRequest.getComicsid()).toUri();
        
        if(comicsRepository.existsByCharactersidAndComicsidAndUserid(comicsRequest.getCharactersid(),comicsRequest.getComicsid(),comicsRequest.getUserid())) {
            return new ResponseEntity(new ApiResponse(false, "character already exists"),
                    HttpStatus.BAD_REQUEST);
        }
        
        comicsService.createComics(comicsRequest);

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Comics favourite:"));
    }


}
