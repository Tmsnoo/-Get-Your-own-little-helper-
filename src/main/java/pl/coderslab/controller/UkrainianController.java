package pl.coderslab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.Entity.Job;
import pl.coderslab.Entity.Ukrainian;
import pl.coderslab.Entity.User;
import pl.coderslab.model.Voivodeship;
import pl.coderslab.repositories.JobRepositories;
import pl.coderslab.repositories.UkrainaRepository;
import pl.coderslab.repositories.UserRepository;

	@Controller
	@RequestMapping("/ukrainian")
	public class UkrainianController {

		@Autowired
		UkrainaRepository ukrainaRepo;
		@Autowired
		UserRepository userRepo;
		@Autowired
		JobRepositories jobRepo;

		@GetMapping("/add")
		public String register(Model m,HttpSession sess) {
			User user = (User) sess.getAttribute("loggedUser");
			if(user.isEnabled()) {
				Ukrainian ukrainian =  ukrainaRepo.findOne(user.getId());
				m.addAttribute("ukraina", ukrainian);
				return "ukrainianForm";
			}
			m.addAttribute("ukraina", new Ukrainian());
			return "ukrainianForm";
		}

		@PostMapping("/add")
		public String registerPost(@Valid @ModelAttribute Ukrainian ukraina, BindingResult br, HttpSession session) {
			if(br.hasErrors()) {
				return "ukrainianForm";
			}
			User user = (User) session.getAttribute("loggedUser");
			if(user.isEnabled()) {
				this.ukrainaRepo.save(this.ukrainaRepo.findOne(user.getId()));
				return "redirect:/user/mainProfile";
			}
			user.setEnabled(true);
			ukraina.setUser(user);
			
			this.ukrainaRepo.save(ukraina);
			this.userRepo.save(user);
			return "redirect:/user/mainProfile";
		}

		@RequestMapping("/profile")
		public String login(Model model, HttpSession session) {
			return "redirect:/ukrainian/add";
		}
		
		
		
		@ModelAttribute ("voivodeshipList")
		public String[]voivodeship() {
			Voivodeship voivode = new Voivodeship();
			return voivode.getVoivodeship();
		}
		@ModelAttribute ("jobList")
		public List<Job> jobList(){
			return jobRepo.findAll();
		}

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