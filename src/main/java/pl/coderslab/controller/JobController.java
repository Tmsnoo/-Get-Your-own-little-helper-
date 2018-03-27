package pl.coderslab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.Entity.Job;
import pl.coderslab.Entity.User;
import pl.coderslab.repositories.JobRepositories;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping("/job")
public class JobController {

	@Autowired
	Validator valid;
	@Autowired
	UserRepository userRepo;
	@Autowired
	JobRepositories jobRepo;
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("job", new Job());
		return "jobForm";
	}
	
	@PostMapping("/add")
	public String added(HttpSession session, @Valid @ModelAttribute Job job ,BindingResult br, Model model) {
		model.addAttribute(job);
		if(br.hasErrors()) {
			return "jobForm";
		}
		User user = (User) session.getAttribute("loggedUser");
		job.setUser(user);
		System.out.println("PRZESZŁOOOOOOO"+job.getTitle() +"--"+job.getDescription() + "---"+ job.getCreated());
		this.jobRepo.save(job);
		return "jobList";
		
	}
	@ModelAttribute("jobList")
	public List<Job> jobList(){
		return this.jobRepo.findAll();
		
		
	}
	
	
}
