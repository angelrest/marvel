package api.app.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import api.app.exception.ResourceNotFoundException;
import api.app.model.User;
import api.app.payload.UserIdentityAvailability;
import api.app.payload.UserProfile;
import api.app.payload.UserSummary;
import api.app.repository.CharactersRepository;
import api.app.repository.ComicsRepository;
import api.app.repository.UserRepository;
import api.app.security.CurrentUser;
import api.app.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CharactersRepository charactersRepository;

    @Autowired
    private ComicsRepository comicsRepository;
    
    @SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }
    

    @GetMapping("/user/checkCharacterAvailability")
    public UserIdentityAvailability checkCharacterAvailability(@RequestParam(value = "characters") Long characters,
    		@RequestParam(value = "id") Long id) {
        Boolean isAvailable = !charactersRepository.existsByCharactersidAndUserId(characters, id);
        return new UserIdentityAvailability(isAvailable);
    }
    
    /*consultar si existe un personaje en a lista de favoritos*/
    @GetMapping("/user/checkComicsAvailability")
    public UserIdentityAvailability checkComicsAvailability(@RequestParam(value = "characters") Long characters,
    		@RequestParam(value = "comics") Long comics,@RequestParam(value = "username") String username) {
        Boolean isAvailable = !comicsRepository.existsByCharactersCharactersidAndComicsidAndCharactersUserUsername(characters, comics, username);
        return new UserIdentityAvailability(isAvailable);
    }
    
    
   @PreAuthorize("hasRole('USER')")
    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", username));
        
        UserProfile userProfiles = new UserProfile(user.getId(), user.getUsername(), user.getName(),user.getEmail());
        return userProfiles;
    }
    
   


}

