package com.generation.progettofinale.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.generation.progettofinale.Services.ServiceUtente;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Utente;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
// Remove the conflicting import statement
// import org.springframework.ui.Model;

@Controller
@SessionAttributes("myList")
public class AppController {

    @Autowired
    private ServiceUtente serviceUtente;

    @GetMapping("/acquisti")
    public String acquisti() {
        return "paginaAcquisto.html";
    }

    @GetMapping("/pagamento")
    public String admin() {
        return "cartaDiCredito.html";
    }

    @GetMapping("/home")
    public String home(Model model,
            HttpSession session) {
        model.addAttribute("isAdmin", session.getAttribute("admin"));
        model.addAttribute("loggato", session.getAttribute("loggato"));
        List<Entity> carrello = (List<Entity>) session.getAttribute("carrello");
        if (carrello != null && carrello.size() > 0) {
            model.addAttribute("numCarrello", carrello.size());
        }
        return "index.html";
    }

    @GetMapping("/prova")
    public String prova() {
        return "prove.html";
    }

    @GetMapping("/login")
    public String login() {
        return "formLogin.html";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("loggato", null);
        ;
        session.setAttribute("utente", null);
        session.setAttribute("admin", null);
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password, Model model,
            HttpSession session) {
        Utente utenteLoggato = serviceUtente.findByUsernameAndPassword(username, password);
        if (utenteLoggato == null) {
            model.addAttribute("error", "username o password errati");
            return "formLogin.html";
        } else {
            session.setAttribute("loggato", "ok");
            session.setAttribute("utente", utenteLoggato);
            Boolean admin = utenteLoggato.isAdmin();

            // return "redirect:/";

            if (admin) {
                session.setAttribute("admin", admin);
                return "redirect:/home";
            } else if (!admin) {
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/paymethod")
    public String carrello() {
        return "cartaDiCredito.html";
    }

    @GetMapping("/acquistoeffettuato")
    public String acquisto(HttpSession session) {
        session.setAttribute("carrello", new ArrayList<Entity>());
        return "redirect:/acquisti";
    }

    @ModelAttribute("myList")
    public List<String> createMyList() {
        return new ArrayList<>();
    }

    @GetMapping("/errore")
    public String error() {
        return "paginaErrore.html";
    }

}