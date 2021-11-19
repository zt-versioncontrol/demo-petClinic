package demo.springframework.demopetclinic.services;

import demo.springframework.demopetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
