package guru.springframework.sfgpetclinic.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.VisitService;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}/")
public class VisitController {

	private OwnerService ownerService;
	private final VisitService visitService;
	private PetService petService;

	public VisitController(VisitService visitService, PetService petService,OwnerService ownerService) {
		this.visitService = visitService;
		this.petService = petService;
		this.ownerService=ownerService;
	}

	@InitBinder
	public void initOwnerBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
	
	@ModelAttribute("pet")
	public Pet populatePet(@PathVariable("petId") Long petId) {
		return this.petService.findById(petId);
	}
	
	// Spring MVC calls method populatePet(...) before initCreateForm is called
	@GetMapping("/visits/new")
	public String initCreateForm(Pet pet, Model model) {
		Visit visit=new Visit();
		pet.getVisits().add(visit);
		visit.setPet(pet);
		model.addAttribute("visit", visit);
		model.addAttribute("pet", pet);
		return "pets/createOrUpdateVisitForm";
	}
	
	@PostMapping("/visits/new")
	public String processUpdateForm(Pet pet, @Valid Visit visit, BindingResult result, Model model) {
		if(result.hasErrors()) {
			visit.setPet(pet);
			model.addAttribute("visit", visit);
			return "pets/createOrUpdateVisitForm";
		} else {
			visit.setPet(pet);
			//petService.save(pet);
			visitService.save(visit);
			return "redirect:/owners/{ownerId}";
		}
	}
}
