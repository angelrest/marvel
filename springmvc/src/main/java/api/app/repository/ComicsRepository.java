package api.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import api.app.model.Comics;

public interface ComicsRepository extends JpaRepository<Comics, Long> {
	
List<Comics> findByCharactersCharacters_idAndcomics_id(Long character, Long comics);
	
	Boolean existsByCharactersCharacters_idAndcomics_id(Long character, Long comics);
	

}
