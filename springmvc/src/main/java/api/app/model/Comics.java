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
@Table(name = "comics")
public class Comics extends UserDateAudit {
	
	private static final long serialVersionUID = 1L;
	
	public Comics() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false)
	private Long  charactersid;
	
	@Column(nullable=false)
	private Long userid;
	
	@Column(nullable=false)
	private Long comicsid;
	
	private String uriimage;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Comics(Long charactersid, Long userid, Long comicsid, String uriimage, String description) {
		super();
		this.charactersid = charactersid;
		this.userid = userid;
		this.comicsid = comicsid;
		this.uriimage = uriimage;
		this.description = description;
	}
	
	
	
		
	

}
