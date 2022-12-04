package guru.springframework.sfgpetclinic.controller.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Collection;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.service.PetTypeService;

@Component
public class PetTypeFormatter implements Formatter<PetType>{
	
	private PetTypeService pets;
	
	public PetTypeFormatter(PetTypeService pets) {
		this.pets = pets;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException{
		Collection<PetType> findPetTypes = this.pets.findAll();
		
		for(PetType type:findPetTypes) {
			if(type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: "+text,0);
	}
}
