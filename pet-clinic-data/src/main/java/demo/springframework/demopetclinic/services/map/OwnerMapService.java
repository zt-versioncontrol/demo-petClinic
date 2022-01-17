package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Owner;
import demo.springframework.demopetclinic.model.Pet;
import demo.springframework.demopetclinic.services.OwnerService;
import demo.springframework.demopetclinic.services.PetService;
import demo.springframework.demopetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner owner){
        if (owner != null){
            if(owner.getPets() != null){

                //persist unsaved PetTypes and Pets
                Consumer<Pet> petConsumer = (pet)->{
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            petTypeService.save(pet.getPetType());
                        }
                    }else {
                        throw new RuntimeException("PetType is required");
                    }

                    if(pet.getId() == null){
                        petService.save(pet);
                    }
                };

                owner.getPets().forEach(petConsumer);
            }
        }

        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
