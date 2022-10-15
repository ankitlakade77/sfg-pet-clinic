package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import guru.springframework.sfgpetclinic.service.map.*;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService=visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if(count ==0) {
			loadData();
		}
	}

	void loadData() {

		PetType Dog = new PetType();
		Dog.setName("Dog");

		PetType Cat = new PetType();
		Cat.setName("Cat");

		System.out.println("Loaded Pet Types...");

		Owner owner1 = new Owner();
		owner1.setFirstName("Bruria");
		owner1.setLastName("Tau");
		owner1.setAddress("1 Ravinia Dr NE");
		owner1.setCity("Atlanta");
		owner1.setTelephone("+1 678-690-3359");

		Pet bruiaPet = new Pet();
		bruiaPet.setName("bruno");
		bruiaPet.setOwner(owner1);
		bruiaPet.setBirthDate(LocalDate.now());
		bruiaPet.setPetType(Dog);
		owner1.getPets().add(bruiaPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Ranjan");
		owner2.setLastName("Kale");
		owner2.setAddress("3625 132nd Avenue Southeast Bellevue");
		owner2.setCity("Washington ");
		owner2.setTelephone("+1 678-690-4459");

		Pet ranjanPet = new Pet();
		ranjanPet.setName("caleb");
		ranjanPet.setOwner(owner2);
		ranjanPet.setBirthDate(LocalDate.now());
		ranjanPet.setPetType(Cat);
		owner2.getPets().add(ranjanPet);

		ownerService.save(owner2);
		
		Visit catVisit= new Visit();
		catVisit.setDate(LocalDate.now());
		catVisit.setPet(ranjanPet);
		catVisit.setDescription("Sneezy kitty");
		
		visitService.save(catVisit);

		System.out.println("Loaded Owners...");

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");

		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");

		Speciality savedRadiology = specialityService.save(radiology);
		Speciality savedSurgery = specialityService.save(surgery);
		Speciality savedDentistry = specialityService.save(dentistry);

		Vet vet1 = new Vet();
		vet1.setFirstName("Coby");
		vet1.setLastName("Rhodes");
		vet1.getSpecialities().add(savedDentistry);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Kaleb");
		vet2.setLastName("Jeff");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");

	}

}
