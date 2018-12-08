package api.app.util;

import api.app.model.Characters;
import api.app.response.CharactersResponse;

public class ModelMapper {

    public static CharactersResponse mapCharactersToCharactersResponse(Characters characters) {
    	CharactersResponse charactersResponse = new CharactersResponse();
    	charactersResponse.setId(characters.getId());
    	charactersResponse.setUser(characters.getUser());
    	charactersResponse.setCharactersid(characters.getCharactersid());
    	
        
        return charactersResponse;
    }

}

