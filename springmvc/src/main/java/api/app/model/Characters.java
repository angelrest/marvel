package api.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import api.app.model.audit.UserDateAudit;

@Entity
@Table(name = "characters")
public class Characters extends UserDateAudit {

	private static final long serialVersionUID = 1L;
	
	public Characters() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
	private User user;
	
	@Column(nullable=false)
	private Long charactersid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		if (user==null) {
			user=new User();
		}
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

	public Characters(User user, Long charactersid) {
		super();
		this.user = user;
		this.charactersid = charactersid;
	}
	
	

}
