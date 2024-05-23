package com.generation.progettofinale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceUtente;
import com.generation.progettofinale.models.Utente;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
// Remove the conflicting import statement
// import org.springframework.ui.Model;


@Controller
public class AppController {

@Autowired
private ServiceUtente serviceUtente;


@GetMapping("/home")
public String home(Model model,
HttpSession session) {
    model.addAttribute("isAdmin", session.getAttribute("admin"));
    model.addAttribute("loggato", session.getAttribute("loggato"));
    return "index.html";
}


@GetMapping("/prova")
public String prova(){
    return "prove.html";
}



@GetMapping("/login")
public String login() {
    return "formLogin.html";
}

@GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("loggato", null);;
        session.setAttribute("utente", null);
        session.setAttribute("admin", null);
        return "redirect:/home";
    }


@PostMapping("/login")
public String login(@RequestParam("username") String username,
@RequestParam("password") String password, Model model,
HttpSession session){
    Utente utenteLoggato = serviceUtente.findByUsernameAndPassword(username , password);
    if (utenteLoggato == null){
        model.addAttribute("error","username o password errati");
        return "formLogin.html";
    } else {                   
        session.setAttribute("loggato", "ok");
        session.setAttribute("utente", utenteLoggato);
        Boolean admin = utenteLoggato.isAdmin();

        //return "redirect:/";

        if(admin) {
            session.setAttribute("admin", admin);
            return "redirect:/home";
        }else if(!admin){               
            return "redirect:/home";
        }else{
            session.setAttribute("loggato", null);
            return "formLogin.html";
            }
        }
    }
}