package guru.springframework.sfgpetclinic.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;

@Controller
public class OwnerController {
		
	private OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService){
		this.ownerService=ownerService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}

	@RequestMapping("/owners/index")
	public String listOwners(Model model) {

		model.addAttribute("owners",ownerService.findAll());
		return "owners/index";
	}
	
	@GetMapping("/owners/find")
	public String findOwners(Model model) {
		model.addAttribute("owner", new Owner());
		return "/owners/findowners";
	}
	
	@GetMapping("/owners")
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		
		if( owner.getLastName() == null) {
			owner.setLastName("");
		}
		
		Collection<Owner> results = this.ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");
		if(results.isEmpty()) {
			result.rejectValue("lastName", "not found", "not found");
			return "/owners/findowners";
		} else if(results.size() == 1) {
			owner = results.iterator().next();
			return "redirect:/owners/"+owner.getId();
		} else {
			model.addAttribute("selections",results);
			return "/owners/ownersList";
		}
	}
	
    @RequestMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
    
    @GetMapping("/owners/new")
    public String initCreateForm(Model model) {
    	model.addAttribute("owner", new Owner());
    	return "owners/createOrUpdateOwnerForm";
    }
    
    @PostMapping("/owners/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
    	if( result.hasErrors()) {
    		return "/owners/createOrUpdateOwnerForm";
    	} else {
    		Owner savedOwner=ownerService.save(owner);
    		return "redirect:/owners/"+savedOwner.getId();
    	}
    }
    
    @GetMapping("/owners/{ownerId}/edit")
    public String initEditForm(@PathVariable Long ownerId, Model model) {
    	model.addAttribute("owner", ownerService.findById(ownerId));
    	return "owners/createOrUpdateOwnerForm";
    }
    
    @PostMapping("/owners/{ownerId}/edit")
    public String processEditForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId) {
    	if( result.hasErrors()) {
    		return "/owners/createOrUpdateOwnerForm";
    	} else {
    		owner.setId(ownerId);
    		Owner savedOwner=ownerService.save(owner);
    		return "redirect:/owners/"+savedOwner.getId();
    	}
    }
}
