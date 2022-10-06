package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import guru.springframework.sfgpetclinic.service.map.*;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	public DataLoader(OwnerService ownerService,VetService vetService,PetTypeService petTypeService){
		this.ownerService=ownerService;
		this.vetService=vetService;
		this.petTypeService=petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType Dog= new PetType();
		Dog.setName("Dog");
		PetType savedDogPetType=petTypeService.save(Dog);
		
		PetType Cat= new PetType();
		Cat.setName("Cat");
		PetType savedCatPetType=petTypeService.save(Dog);
		
		System.out.println("Loaded Pet Types...");
		
		Owner owner1=new Owner();
		owner1.setFirstName("Bruria");
		owner1.setLastName("Tau");
		owner1.setAddress("1 Ravinia Dr NE");
		owner1.setCity("Atlanta");
		owner1.setTelephone("+1 678-690-3359");
		
		Pet bruiaPet=new Pet();	
		bruiaPet.setName("bruno");
		bruiaPet.setOwner(owner1);
		bruiaPet.setBirthDate(LocalDate.now());
		bruiaPet.setPetType(Dog);
		owner1.getPets().add(bruiaPet);
		
		ownerService.save(owner1);
		
		Owner owner2=new Owner();
		owner2.setFirstName("Ranjan");
		owner2.setLastName("Kale");
		owner2.setAddress("3625 132nd Avenue Southeast Bellevue");
		owner2.setCity("Washington ");
		owner2.setTelephone("+1 678-690-4459");
		
		Pet ranjanPet=new Pet();	
		ranjanPet.setName("caleb");
		ranjanPet.setOwner(owner2);
		ranjanPet.setBirthDate(LocalDate.now());
		ranjanPet.setPetType(Cat);
		owner2.getPets().add(ranjanPet);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners...");
		
		Vet vet1=new Vet();
		vet1.setFirstName("Coby");
		vet1.setLastName("Rhodes");
		
		vetService.save(vet1);
		
		Vet vet2=new Vet();
		vet2.setFirstName("Kaleb");
		vet2.setLastName("Jeff");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets....");
		
	}
	
}
