package api.app.response;

import api.app.model.User;

public class CharactersResponse {
	
	private Long id;
	private User user;
	private Long charactersid;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getCharactersid() {
		return charactersid;
	}
	public void setCharactersid(Long charactersid) {
		this.charactersid = charactersid;
	}
	
	

}
