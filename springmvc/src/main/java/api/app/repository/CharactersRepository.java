package api.app.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.app.model.Characters;
@Repository
public interface CharactersRepository extends JpaRepository<Characters, Long> {
	
	@Query("SELECT o.id,o.user.id,o.user.username,o.charactersid FROM Characters o where o.user.username = :username and o.charactersid=:charactersid")
	Page<Characters> findByUserUsernameAndCharactersid(@Param("username") String username, 
			@Param("charactersid") Long charactersid, Pageable pageable);
	
	boolean existsByCharactersidAndUserUsername(Long id,String username);

	boolean existsByCharactersidAndUserId(Long charactersid, Long userid);
	

}
