package api.app.util;


import api.app.model.Comics;

import api.app.response.ComicsResponse;

public class ModelMapper {

    public static ComicsResponse mapComicsToComicsResponse(Comics comic) {
    	ComicsResponse comicResponse = new ComicsResponse();
    	comicResponse.setId(comic.getId());
    	comicResponse.setUserid(comic.getUserid());
    	comicResponse.setCharactersid(comic.getCharactersid());
    	comicResponse.setComicsid(comic.getComicsid());
    	comicResponse.setDescription(comic.getDescription());
    	comicResponse.setUriimage(comic.getUriimage());
    	comicResponse.setTitleCharacter(comic.getTitleCharacter());
    	comicResponse.setTitleComics(comic.getTitleComics());
    	return comicResponse;
    }

}

