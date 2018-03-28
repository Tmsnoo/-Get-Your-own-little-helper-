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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import pl.coderslab.Entity.Ukrainian;
import pl.coderslab.repositories.CategoriesRepository;
import pl.coderslab.repositories.UkrainaRepository;

	@Controller
	@RequestMapping("/ukrainian")
	public class UkrainianController {

		@Autowired
		UkrainaRepository ukrainaRepo;
		@Autowired
		CategoriesRepository categoryRepo;

		@GetMapping("/add")
		public String register(Model m) {
			m.addAttribute("ukraina", new Ukrainian());
			return "ukrainaForm";
		}

		@PostMapping("/add")
		public String registerPost(@Valid @ModelAttribute Ukrainian ukraina, BindingResult br) {
			this.ukrainaRepo.save(ukraina);
			return "redirect:/ukrainian/profile";
		}

//		@GetMapping("/profile")
//		public String login(Model m, @ModelAttribute Ukrainian ukraina,Binding) {
//			m.addAttribute("ukraina",  );
//			return "login";
//		}

//		@PostMapping("/login")
//		public String loginPost(@Valid @ModelAttribute UserDTO userDTO, BindingResult br, Model model) {
//			User u = this.userRepo.findOneByEmail(userDTO.getEmail());
//			if (u != null && u.isPasswordCorrect(userDTO.getPassword())) {
//				model.addAttribute("loggedUser", u);
//				return "redirect:/";
//			}
//			return "redirect:/user/login";
//		}
//		@GetMapping("/logout")
//		public String logOut(SessionStatus status) {
//			status.setComplete();
//			return "redirect:/";
//		}
		

	}