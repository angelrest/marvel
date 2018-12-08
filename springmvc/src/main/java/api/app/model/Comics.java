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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "charactersid", nullable = false)
	private Characters characters;
	
	@Column(nullable=false)
	private Long comicsid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Characters getCharacters() {
		return characters;
	}

	public void setCharacters(Characters characters) {
		this.characters = characters;
	}

	public Long getComicsid() {
		return comicsid;
	}

	public void setComicsid(Long comicsid) {
		this.comicsid = comicsid;
	}

	public Comics(Characters characters, Long comicsid) {
		super();
		this.characters = characters;
		this.comicsid = comicsid;
	}
	
	
	

}
