package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractJpaService<ENTITY extends BaseEntity> {
    private final CrudRepository<ENTITY, Long> repository;

    protected AbstractJpaService(CrudRepository repository) {
        this.repository = repository;
    }

    public ENTITY findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Set<ENTITY> findAll() {
        Set<ENTITY> entities = new HashSet<>();
        repository.findAll().forEach(entities::add);
        return entities;
    }

    public ENTITY save(ENTITY entity) {
        return repository.save(entity);
    }

    public void delete(ENTITY entity) {
        repository.delete(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
