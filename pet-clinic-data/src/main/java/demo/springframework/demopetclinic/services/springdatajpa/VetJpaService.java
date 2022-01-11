package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.Vet;
import demo.springframework.demopetclinic.repositories.VetRepository;
import demo.springframework.demopetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetJpaService(demo.springframework.demopetclinic.repositories.VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet object) {

    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
