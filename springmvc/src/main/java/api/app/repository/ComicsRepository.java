package api.app.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.app.model.Comics;
@Repository
public interface ComicsRepository extends JpaRepository<Comics, Long> {
	
	
	
Boolean existsByCharactersidAndComicsidAndUserid(Long character, Long comics, Long userid);

Page<Comics> findByCharactersidAndUserid(Long characters, Long id, Pageable pageable);

Page<Comics> findByUserid(Long id, Pageable pageable);
	

}
