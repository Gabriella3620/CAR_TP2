package com.tpagenda.tpagenda.Controller;

import com.tpagenda.tpagenda.Services.implementation.AgendaServiceImpl;
import com.tpagenda.tpagenda.dto.EventDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("agenda")
public class AgendaController {

    @Autowired
    private AgendaServiceImpl agendaService;

    @GetMapping("add-event")
    public String getCreateForm(@RequestParam String name, Model model) {

        model.addAttribute("agendaName", name);
        return "addEvent";
    }

    @PostMapping(value = "event")
    public String createEvent(@ModelAttribute EventDTO event, HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login";
        }
        agendaService.createEvent(email, event);
        model.addAttribute("name", model.getAttribute("agendaName"));
        return "addEvent";
    }

    @GetMapping("event/remove/{id}")
    public String deleteEvent(@PathVariable Long id, @RequestParam String name, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login";
        }
        agendaService.deleteEvent(email, name, id);
        return "redirect:/agenda/home";
    }

    @GetMapping("event")

    public String getAllEvents(Model model, @RequestParam String name, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login";
        }
        List<EventDTO> eventDTOS = agendaService.getAllEvents(email, name);
        model.addAttribute("events", eventDTOS);
        String agendaName = eventDTOS.isEmpty() ? "" : eventDTOS.get(0).getAgendaName();
        model.addAttribute("name", agendaName);

        return "showEvents";
    }

}
