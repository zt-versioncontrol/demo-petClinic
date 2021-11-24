package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.BaseEntity;
import demo.springframework.demopetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity> implements CrudService<T> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public T findById(Long id){
        return map.get(id);
    }

    @Override
    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    @Override
    public T save(T object){
        if(object != null) {
            Long nextId = getNextId();
            object.setId(nextId);
            map.put(nextId, object);
        }

        return object;
    }

    @Override
    public void deleteById(Long id){
        map.remove(id);
    }

    @Override
    public void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private long getNextId(){
        long nextId;
        try{
            nextId =Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
