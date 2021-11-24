package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Owner;
import demo.springframework.demopetclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
