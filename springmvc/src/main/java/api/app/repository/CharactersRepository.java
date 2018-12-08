package api.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import api.app.model.Characters;

public interface CharactersRepository extends JpaRepository<Characters, Long> {
	
	List<Characters> findByUserUsernameAndCharacters_id(String username, Long charactersid);
	
	Boolean existsBycharacters_idAndUserUsername(Long id,String username);
	

}
