package com.generation.progettofinale.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceUtente;
import com.generation.progettofinale.models.Utente;

import jakarta.servlet.http.HttpSession;

@Controller
public class UtenteController {
    @Autowired
    private ServiceUtente serviceUtente;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/formRegistrazione")
    public String formRegistrazione(Model model){
        Utente utente = applicationContext.getBean("utente",Utente.class);
        model.addAttribute("utente", utente);
        return "registrazioneUtente.html";
    }

    
    @PostMapping("/register")
    public String registerUser(
            Model model,
            @RequestParam("confermaPassword") String confermaPassword,
            @ModelAttribute Utente utente,
            HttpSession session,
            @RequestParam Map<String, String> allParams)
    {
        Utente utenteDB;
        utenteDB=serviceUtente.findByUsername(utente.getUsername());
        if(utenteDB!=null){
            model.addAttribute("error", "Username già presente");
            return "registrazioneUtente.html";
        }
        utenteDB=serviceUtente.findByUsername(utente.getEmail());
        if(utenteDB!=null){
            model.addAttribute("error", "Email già presente");
            return "registrazioneUtente.html";
        }
        
        if(!utente.getPassword().equals(confermaPassword)){
            model.addAttribute("error", "Le password non coincidono");
            return "registrazioneUtente.html";
        }
        allParams.put("isAdmin", "false");

       
        serviceUtente.insert(allParams);
        
        session.setAttribute("utente", utente);
        return "confermaRegistrazione.html";
    }
}
