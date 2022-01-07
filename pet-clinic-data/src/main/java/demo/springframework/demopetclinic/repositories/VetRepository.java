package demo.springframework.demopetclinic.repositories;

import demo.springframework.demopetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
