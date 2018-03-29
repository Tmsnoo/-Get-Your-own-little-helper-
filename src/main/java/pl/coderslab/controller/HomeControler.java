package pl.coderslab.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.Entity.User;

@Controller
public class HomeControler {
	@GetMapping("")
	public String test(HttpSession session) {
//		User user = (User) session.getAttribute("loggedUser");
//		if(user.getUkrainain()!=null) {
//			return "homeNoButton";
//		}
		return "home";
	}
}
