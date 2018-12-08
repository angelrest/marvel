package api.app.request;


import javax.validation.constraints.NotNull;

public class CharactersRequest {
	@NotNull
    private Long userid;
	@NotNull
	private Long charactersid;
	
	@NotNull
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getCharactersid() {
		return charactersid;
	}
	public void setCharactersid(Long charactersid) {
		this.charactersid = charactersid;
	}
	
	

}
