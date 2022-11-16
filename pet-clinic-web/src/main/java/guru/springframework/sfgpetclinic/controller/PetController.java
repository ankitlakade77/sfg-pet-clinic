package guru.springframework.sfgpetclinic.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.PetTypeService;

@Controller
@RequestMapping
public class PetController {
	
	private OwnerService ownerService;
	private PetService petService;
	private PetTypeService petTypeService;
	
	public PetController(OwnerService ownerService,PetService petService,PetTypeService petTypeService){
		this.ownerService=ownerService;
		this.petService=petService;
		this.petTypeService=petTypeService;
	}

	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes(){
		return this.petTypeService.findAll();
	}
	
	@ModelAttribute("owner")
	public Owner populatePetTypes( @PathVariable("ownerId") Long ownerId){
		return this.ownerService.findById(ownerId);
	}
	
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
}
