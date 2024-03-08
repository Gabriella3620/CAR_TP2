package com.example.demo.bib.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bib.Personne;
import com.example.demo.bib.Repository.PersonneRepository;
import com.example.demo.bib.Services.PersonneService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PersonneController {

	@Autowired
	private PersonneService personneService;
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("personne", new Personne());
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		Personne personne = personneRepository.findByEmailAndPassword(email, password);
		if (personne != null) {
			return "redirect:/loginsuccess";
		} else {
			return "redirect:/loginError";
		}
	}

	@PostMapping("/register")
	public String register(
			@RequestParam String regEmail,
			@RequestParam String regPassword,
			@RequestParam String firstName,
			@RequestParam String lastName) {
		personneService.ajoutPersonne(
				regEmail, regPassword, firstName, lastName);
		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/login";

	}
}