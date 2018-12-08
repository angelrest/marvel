package api.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.app.model.Comics;
@Repository
public interface ComicsRepository extends JpaRepository<Comics, Long> {
	
List<Comics> findByCharactersCharactersidAndComicsidAndCharactersUserUsername(Long character, Long comics, String username);
	
Boolean existsByCharactersCharactersidAndComicsidAndCharactersUserUsername(Long character, Long comics, String username);
	

}
