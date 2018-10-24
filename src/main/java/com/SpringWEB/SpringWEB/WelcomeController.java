package com.SpringWEB.SpringWEB;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@Autowired
	private UserService userService;

	@RequestMapping("/welcome")
	public ModelAndView mymethod() {
		return new ModelAndView("index", "msg", "Hello First Spring");
	}

	@PostMapping("/adduser")
	public String formPost(UserRecord user, Model model) {
		model.addAttribute("user", user);
		userService.addUser(user);
		return "redirect:/welcome";
	}
	
	@RequestMapping("/getuser")
	public String getuser(Model model) {
		UserRecord user = userService.getUser(6);
		model.addAttribute("credit", user);
		System.out.println(user.getName());
		return "singleuser";
	}
	
	@RequestMapping("/getAll")
	public String getAll() {
		List<UserRecord> user = userService.getAllUsers();
		int i = user.size();
		System.out.println(i);
		for(UserRecord s:user){  
			 System.out.println(s.getName());  
			}  
		return "";
	}
	
}