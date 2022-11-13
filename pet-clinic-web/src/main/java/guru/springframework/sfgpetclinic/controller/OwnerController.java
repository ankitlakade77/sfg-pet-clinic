package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.sfgpetclinic.service.OwnerService;

@Controller
public class OwnerController {
	
	private OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService){
		this.ownerService=ownerService;
	}

	@RequestMapping({"/owners/index","/owners"})
	public String listOwners(Model model) {

		model.addAttribute("owners",ownerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping({"/owners/find","/oups"})
	public String findOwners() {
		return "notimplemented";
	}
	
    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
}
