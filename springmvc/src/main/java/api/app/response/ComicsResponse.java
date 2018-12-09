package api.app.response;



public class ComicsResponse {
	
	private Long id;
	private Long  charactersid;
	private Long userid;
	private Long comicsid;
	private String uriimage;
	private String description;
	
	private String titleCharacter;		
	
	private String titleComics;
	
	
	
	public Long getCharactersid() {
		return charactersid;
	}
	public void setCharactersid(Long charactersid) {
		this.charactersid = charactersid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getComicsid() {
		return comicsid;
	}
	public void setComicsid(Long comicsid) {
		this.comicsid = comicsid;
	}
	public String getUriimage() {
		return uriimage;
	}
	public void setUriimage(String uriimage) {
		this.uriimage = uriimage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitleCharacter() {
		return titleCharacter;
	}
	public void setTitleCharacter(String titleCharacter) {
		this.titleCharacter = titleCharacter;
	}
	public String getTitleComics() {
		return titleComics;
	}
	public void setTitleComics(String titleComics) {
		this.titleComics = titleComics;
	}
	
	

}
