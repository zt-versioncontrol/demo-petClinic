package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.PetType;
import demo.springframework.demopetclinic.repositories.PetTypeReposiroty;
import demo.springframework.demopetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {
    private final PetTypeReposiroty petTypeReposiroty;

    public PetTypeJpaService(PetTypeReposiroty petTypeReposiroty) {
        this.petTypeReposiroty = petTypeReposiroty;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeReposiroty.findById(id).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeReposiroty.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeReposiroty.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeReposiroty.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeReposiroty.deleteById(id);
    }
}
