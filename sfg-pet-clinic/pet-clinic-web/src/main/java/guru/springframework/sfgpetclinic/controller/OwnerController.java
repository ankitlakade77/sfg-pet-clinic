package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
