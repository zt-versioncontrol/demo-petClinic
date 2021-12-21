package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.BaseEntity;
import demo.springframework.demopetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity>{

    protected Map<Long, T> map = new HashMap<>();


    public T findById(Long id){
        return map.get(id);
    }


    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }


    public T save(T object){
        if(object != null) {
            Long nextId = getNextId();
            object.setId(nextId);
            map.put(nextId, object);
        }

        return object;
    }


    public void deleteById(Long id){
        map.remove(id);
    }


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
