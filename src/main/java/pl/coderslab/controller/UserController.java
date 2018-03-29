package pl.coderslab.controller;

import javax.validation.Valid;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pl.coderslab.Entity.Category;
import pl.coderslab.Entity.User;
import pl.coderslab.model.CategoryList;
import pl.coderslab.model.UserDTO;
import pl.coderslab.repositories.CategoriesRepository;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping("/user")
@SessionAttributes({ "loggedUser" })
class UserController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	CategoriesRepository categoryRepo;

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user, BindingResult br) {
		if (br.hasErrors()) {
			return "register";
		}
		this.userRepo.save(user);
		return "redirect:/user/login";
	}

	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("user", new UserDTO());
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(@Valid @ModelAttribute UserDTO userDTO, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "login";
		}
		User u = this.userRepo.findOneByEmail(userDTO.getEmail());
		if (u != null && u.isPasswordCorrect(userDTO.getPassword())) {
			model.addAttribute("loggedUser", u);
			return "redirect:/user/mainProfile";
		}
		return "redirect:/user/login";
	}
	@RequestMapping("/mainProfile")
	public String mainProfile() {
		return "mainPage";
	}
	@GetMapping("/logout")
	public String logOut(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

	@RequestMapping("/categories")
	@ResponseBody
	public String saveCatgories() {
		CategoryList listCategory = new CategoryList();
		for (String lc : listCategory.categories) {
			Category cate = new Category();
			cate.setName(lc);
			this.categoryRepo.save(cate);
		}
		return "Categories set";
	}

}
