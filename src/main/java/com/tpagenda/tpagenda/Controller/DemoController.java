package com.tpagenda.tpagenda.Controller;
import com.tpagenda.tpagenda.Personne;
import com.tpagenda.tpagenda.Agenda;
import com.tpagenda.tpagenda.Repository.PersonneRepository;
import com.tpagenda.tpagenda.Services.AgendaService;

import com.tpagenda.tpagenda.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DemoController {
    @Autowired
    private PersonneService personneServices;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private AgendaService agendaService;


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("personne", new Personne());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session) {
        Personne personne = personneRepository.findByEmailAndPassword(email, password);
        if (personne != null) {
            session.setAttribute("email", email);
            return "redirect:/loginOK";
        } else {
            return "redirect:/loginError";
        }
    }

   

    @PostMapping("/register")
    public String register(@RequestParam String regEmail,
            @RequestParam String regPassword,
            @RequestParam String firstName,
            @RequestParam String lastName) {
        personneServices.addPerson(regEmail, regPassword, firstName, lastName);
        return "redirect:/login";
    }

    @GetMapping("loginOK")
    public String loginOK(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        Iterable<Agenda> agendas = agendaService.getAgendaByEmail(email);
        model.addAttribute("agendas", agendas);
        model.addAttribute("newAgenda", new Agenda());
        return "loginOK";
    }
    @GetMapping("/loginError")
    public String loginError() {
        return "loginError";
    }

    @PostMapping("/loginError")
    public String loginError(@RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session) {
        Personne personne = personneRepository.findByEmailAndPassword(email, password);
        if (personne != null) {
            session.setAttribute("email", email);
            return "redirect:/loginOK";
        } else {
            return "redirect:/loginError";
        }
    }
    @PostMapping("/addAgenda")
    public String addAgenda(@RequestParam String nom, HttpSession session) {
        String email = (String) session.getAttribute("email");
        agendaService.addAgenda(email, nom);
        return "redirect:/loginOK";
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
