package demo.springframework.demopetclinic.repositories;

import demo.springframework.demopetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
