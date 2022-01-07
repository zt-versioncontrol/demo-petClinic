package demo.springframework.demopetclinic.repositories;

import demo.springframework.demopetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
