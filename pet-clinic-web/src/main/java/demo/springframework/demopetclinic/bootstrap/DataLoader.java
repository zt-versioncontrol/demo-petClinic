package demo.springframework.demopetclinic.bootstrap;

import demo.springframework.demopetclinic.model.Owner;
import demo.springframework.demopetclinic.model.Pet;
import demo.springframework.demopetclinic.model.PetType;
import demo.springframework.demopetclinic.model.Vet;
import demo.springframework.demopetclinic.services.OwnerService;
import demo.springframework.demopetclinic.services.PetService;
import demo.springframework.demopetclinic.services.PetTypeService;
import demo.springframework.demopetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, PetService petService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Vets...");
        Vet vet1 = new Vet();
        vet1.setFirstName("vet1 firstName");
        vet1.setLastName("vet1 lastName");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet2 firstName");
        vet2.setLastName("vet2 lastName");
        vetService.save(vet2);
        System.out.println("Finished Loading Vets");


        System.out.println("Loading PetTypes...");
        PetType dogType = new PetType();
        dogType.setName("dog");
        PetType savedDogType = petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("cat");
        PetType savedCatType = petTypeService.save(catType);
        System.out.println("Finished Loading PetTypes");


        System.out.println("Loading Owners and Pets...");
        Owner owner1 = new Owner();
        owner1.setFirstName("owner1 firstName");
        owner1.setLastName("owner1 lastName");
        owner1.setAddress("addres1");
        owner1.setCity("city1");
        owner1.setTelephone("1111");

        Pet dog1 = new Pet();
        dog1.setPetType(dogType);
        dog1.setName("dog1");
        dog1.setBirthDate(LocalDate.now());
        dog1.setOwner(owner1);

        owner1.getPets().add(dog1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("owner2 firstName");
        owner2.setLastName("owner2 lastName");
        owner2.setAddress("address2");
        owner2.setCity("city2");
        owner2.setTelephone("2222");

        Pet cat1 = new Pet();
        cat1.setPetType(catType);
        cat1.setName("cat1");
        cat1.setBirthDate(LocalDate.now());
        cat1.setOwner(owner2);

        owner2.getPets().add(cat1);
        ownerService.save(owner2);
        System.out.println("Finished Loading Owners and Pets");
    }
}
