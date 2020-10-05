package sailsandheroes.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import sailsandheroes.demo.Model.Ship;

@Repository
public interface ShipRepositoryI extends CrudRepository<Ship, Integer> {
}