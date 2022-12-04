package guru.springframework.sfgpetclinic.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.VetService;

@Controller
public class VetController {
	
	private VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService=vetService;
	}

	@RequestMapping({"/vets","/vets.html"})
	public String listVets(Model model) {
		model.addAttribute("vets",vetService.findAll());
		return "vets/index";
	}
	
	@GetMapping("/api/vets")
	public @ResponseBody Set<Vet> getVetJson(){
		
		return vetService.findAll();
	}
}
