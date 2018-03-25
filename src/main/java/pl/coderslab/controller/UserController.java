package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.Entity.User;
import pl.coderslab.model.UserDTO;
import pl.coderslab.repositories.UserRepository;


@Controller
//@RequestMapping("/user")
@SessionAttributes({"loggedUser"})
class UserController {
	
	@Autowired
	UserRepository userRepo;

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user,BindingResult br) {
		this.userRepo.save(user);
		return "redirect:/login";
	}
	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("user", new UserDTO());
		return "login";
	}
	@PostMapping("/login")
	public String loginPost(@Valid @ModelAttribute UserDTO user,BindingResult br,Model model) {
		User u = this.userRepo.findOneByEmail(user.getEmail());
		if(u != null && u.isPasswordCorrect(user.getPassword())) {
			model.addAttribute("loggedUser", u);
			return "redirect:/";
		}
		return "redirect:/login";
	}
	
	
}
