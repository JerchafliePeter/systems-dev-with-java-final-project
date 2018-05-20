/**
 * 
 */
package csci4380.finalp.cats.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.dogs.mongodb.model.Dog;


public interface CatRepository extends JpaRepository<Cat, Integer> {
	
	public List<Cat> findByNameOrOwnerName(String name, String ownerName);
	
	//public void deleteByPetId(Integer petId);
	
	
	@Query("select c from CAT c where lower(c.name) = lower(:catName)")
	public Cat findByNameIgnoreCaseQuery(@Param("catName") String catName);

	public Cat findByPetId(@Param("petId") Integer petId);
	
	public Optional<List<Cat>> findByTypeAllIgnoreCase(@Param("type") String catType);

}

