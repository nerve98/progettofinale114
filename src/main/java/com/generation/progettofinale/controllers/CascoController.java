package com.generation.progettofinale.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceCasco;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.models.Utente;

import jakarta.servlet.http.HttpSession;

@Controller
public class CascoController {
    @Autowired
    private ServiceCasco serviceCasco;

    @GetMapping("/caschi")
    public String caschi(Model model, HttpSession session) {
        List<Casco> ris = serviceCasco.findAll();
        model.addAttribute("caschi", ris);
        Object utente = session.getAttribute("utente");
        model.addAttribute("isAdmin",((Utente) utente).isAdmin());
        return "caschi.html";
    }

    @PostMapping("/inserisci-casco")
    public String inserisciCasco(@RequestParam Map<String,String> parametri, HttpSession session, Model model){
        boolean isAdmin = false;
        Object utente = session.getAttribute("utente");
        if(utente != null && utente instanceof Utente){
            Utente u = (Utente)utente;
            model.addAttribute("isAdmin", isAdmin);
        }
        serviceCasco.insert(parametri);
        return "redirect:/caschi";
    }

    @PostMapping("/modifica-casco")
    public String modificaCasco(@RequestParam Map<String,String> parametri){
        serviceCasco.update(parametri);
        return "redirect:/caschi";
    }

    @GetMapping("/elimina-casco")
    public String eliminaAlimentare(@RequestParam(name = "idCasco", defaultValue = "0") Long idCasco, Model model){
        if(idCasco==0){
            model.addAttribute("error", "Errore nell'eliminazione del casco");
            return "paginaErrore.html";
        }
        serviceCasco.delete(idCasco);
        return "redirect:/caschi";
    }

    @GetMapping("/casco-byId")
    public String consoleById(@RequestParam(name = "idCasco", defaultValue = "0") Long idCasco, Model model){
        Casco casco = serviceCasco.findById(idCasco);
        if(casco==null){
            model.addAttribute("error", "Errore nella ricerca della console associato al parametro idConsole con id = "+idCasco);
            return "paginaErrore.html";
        }
        else{
            model.addAttribute("console", casco);
            return "dettaglioCasco.html";
        }

    }


}
