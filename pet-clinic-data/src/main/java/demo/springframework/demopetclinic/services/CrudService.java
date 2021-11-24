package demo.springframework.demopetclinic.services;

import demo.springframework.demopetclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T extends BaseEntity> {

    T findById(Long id);

    Set<T> findAll();

    T save(T object);

    void delete(T object);

    void deleteById(Long id);
}
