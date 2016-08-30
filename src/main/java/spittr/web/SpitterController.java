package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {
	
	private SpitterRepository spitterRepository;
	
	@Autowired
	  public SpitterController(SpitterRepository spitterRepository) {
	    this.spitterRepository = spitterRepository;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String showRegistrationFrom() {
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String processRegisteration(Spitter spitter) {
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		System.out.println(spitter);
		model.addAttribute(spitter);
		return "profile";
	}
	
	
}
