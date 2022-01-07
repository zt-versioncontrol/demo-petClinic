package demo.springframework.demopetclinic.repositories;

import demo.springframework.demopetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
