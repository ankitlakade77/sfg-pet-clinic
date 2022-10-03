package guru.springframework.sfgpetclinic.bootstrap;

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

		ownerService.save(owner1);
		
		Owner owner2=new Owner();
		owner2.setFirstName("Ranjan");
		owner2.setLastName("Kale");
		
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
