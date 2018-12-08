package api.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.app.model.Characters;
@Repository
public interface CharactersRepository extends JpaRepository<Characters, Long> {
	
	List<Characters> findByUserUsernameAndCharactersid(String username, Long charactersid);
	
	Boolean existsByCharactersidAndUserUsername(Long id,String username);
	

}
