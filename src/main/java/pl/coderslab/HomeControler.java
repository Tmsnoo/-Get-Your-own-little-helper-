package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControler {
	@GetMapping("")
	@ResponseBody
	public String test() {
		return "test";
	}
}
