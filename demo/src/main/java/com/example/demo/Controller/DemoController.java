package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Personne;
import com.example.demo.Repository.PersonneRepository;
import com.example.demo.Services.PersonneService;
import com.example.demo.Agenda;
import com.example.demo.Repository.AgendaRepository;
import com.example.demo.Services.AgendaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DemoController {

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
			@RequestParam String Email,
			@RequestParam String Password,
			@RequestParam String firstName,
			@RequestParam String lastName) {
		personneService.ajoutPersonne(
				Email, Password, firstName, lastName);
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

	/*
	 * @PostMapping("/addAgenda")
	 * public String ajouterAgenda(
	 * 
	 * @RequestParam String nom
	 * ) {
	 * agendaService.ajouterAgenda(nom);
	 * return "redirect:/loginsuccess";
	 * }
	 */
}