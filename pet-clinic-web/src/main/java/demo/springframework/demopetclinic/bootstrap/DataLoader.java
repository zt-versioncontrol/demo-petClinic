package demo.springframework.demopetclinic.bootstrap;

import demo.springframework.demopetclinic.model.*;
import demo.springframework.demopetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;


    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService, VisitService visitService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Loading Specialties...");
        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        specialtyService.save(surgery);
        System.out.println("Finished Loading Specialties");

        System.out.println("Loading Vets...");
        Vet vet1 = new Vet();
        vet1.setFirstName("vet1 firstName");
        vet1.setLastName("vet1 lastName");
        vet1.getSpecialties().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet2 firstName");
        vet2.setLastName("vet2 lastName");
        vetService.save(vet2);
        vet2.getSpecialties().add(surgery);
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

        System.out.println("Loading Visits...");
        Visit visit1 = new Visit();
        visit1.setPet(cat1);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("sick cat");
        visitService.save(visit1);
        System.out.println("Finished Loading Visits");
    }
}
