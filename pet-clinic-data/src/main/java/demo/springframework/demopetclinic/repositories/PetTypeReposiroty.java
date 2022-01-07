package demo.springframework.demopetclinic.repositories;

import demo.springframework.demopetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeReposiroty extends CrudRepository<PetType, Long> {
}
