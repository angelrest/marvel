package api.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.app.model.Characters;
import api.app.request.CharactersRequest;
import api.app.response.CharactersResponse;
import api.app.response.PagedResponse;
import api.app.security.CurrentUser;
import api.app.security.UserPrincipal;
import api.app.service.CharactersService;
import api.app.util.Constants;

@RestController
@RequestMapping("/api/marvel")
public class MarvelController {
	
	@Autowired
	private CharactersService charactersService;
	
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public PagedResponse<CharactersResponse> getCharacters(@CurrentUser UserPrincipal currentUser,
                                                @RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size,
                                                @RequestParam(value = "characters") Long characters) {
        return charactersService.getCharactersByUsers(currentUser, page, size, characters);
    }
    
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createCharacter(@Valid @RequestBody CharactersRequest charactersRequest) {
        //Characters characters = CharactersService.;
		return null;

       /* URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{pollId}")
                .buildAndExpand(poll.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Poll Created Successfully"));
   */ }


}
