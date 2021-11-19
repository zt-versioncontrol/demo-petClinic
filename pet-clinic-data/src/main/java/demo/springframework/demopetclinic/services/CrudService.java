package demo.springframework.demopetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);

    Set<T> findAll();

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
