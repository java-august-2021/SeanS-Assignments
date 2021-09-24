package com.sean.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sean.exam.models.Idea;
import com.sean.exam.models.User;
import com.sean.exam.services.IdeaService;
import com.sean.exam.services.UserService;
import com.sean.exam.validators.UserValidator;

@Controller
public class HomeController {
	
	@Autowired 
	private UserService uService;
	
	@Autowired
	private UserValidator Validator;
	
	@Autowired
	private IdeaService iService;

	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "home.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		Validator.validate(user, result);
		if(result.hasErrors()) {
			return "home.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/ideas";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/ideas";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/ideas")
	public String dashboard(Model viewModel, HttpSession session) {
		Long id = (Long)session.getAttribute("user_id");
		User thisUser = this.uService.findOneUser(id);
		viewModel.addAttribute("thisUser", thisUser);
		viewModel.addAttribute("allIdeas", this.iService.getAllIdeas());
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String addIdea(@ModelAttribute("idea") Idea idea, HttpSession session, Model viewModel) {
	viewModel.addAttribute("user_id", session.getAttribute("user_id"));
		return "new.jsp";
	}
	
	@PostMapping("/ideas/new")
	public String processIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("user_id", session.getAttribute("user_id"));
			return "new.jsp";
		}
		System.out.println(idea.getUser());
		this.iService.createIdea(idea);
		return "redirect:/ideas";
	}
	
	@GetMapping("/details/{id}")
	public String showIdea(Model model, @PathVariable("id") Long id) {
		Idea thisIdea = this.iService.getOneIdea(id);
		System.out.println(thisIdea.getId());
		model.addAttribute("thisIdea", thisIdea);
		return "details.jsp";
	}

	
	@GetMapping("/edit/{id}")
	public String editIdea(Model model, @PathVariable("id") Long id) {
		model.addAttribute("idea", this.iService.getOneIdea(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String editIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, @PathVariable("id") Long id) {
		System.out.println("hello 1");
		if(result.hasErrors()) {
			System.out.println("hello 2");
			
			model.addAttribute("idea", this.iService.getOneIdea(id));
			return "edit.jsp";
		}
		System.out.println("hello 3");
		this.iService.updateIdea(idea);
		return "redirect:/details/{id}";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteIdea(@PathVariable("id") Long id) {
		iService.deleteIdea(id);
		return "redirect:/ideas";
	}

}