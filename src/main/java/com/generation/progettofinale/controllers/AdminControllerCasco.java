package com.generation.progettofinale.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceCasco;
import com.generation.progettofinale.models.Utente;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminControllerCasco {

    @Autowired
    private ServiceCasco serviceCasco;
    
    @GetMapping("/admin-caschi")
    public String adminCaschi(Model model) {
        model.addAttribute("caschi", serviceCasco.findAll());
        return "adminCasco.html";
    }

    @PostMapping("/inserisci-casco")
    public String inserisciCasco(@RequestParam Map<String,String> parametri, HttpSession session, Model model){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = (String) session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;

        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            loggato = (String) loggatoObj;
            utente = (Utente) utenteObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    serviceCasco.insert(parametri);
                    return "redirect:/admin-caschi";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }        
    }

    @PostMapping("/modifica-casco")
    public String modificaCasco(@RequestParam Map<String,String> parametri, HttpSession session, Model model){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = (String) session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;
        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            loggato = (String) loggatoObj;
            utente = (Utente) utenteObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    serviceCasco.update(parametri);
                    return "redirect:/admin-caschi";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }   

        
    }

    @GetMapping("/elimina-casco")
    public String eliminaCasco(@RequestParam(name = "idCasco", defaultValue = "0") Long idCasco, HttpSession session, Model model){

        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = (String) session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;

        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            loggato = (String) loggatoObj;
            utente = (Utente) utenteObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    if(idCasco==0){
                        model.addAttribute("error", "Errore nell'eliminazione del casco");
                        return "paginaErrore.html";
                    }
                    serviceCasco.delete(idCasco);
                    return "redirect:/admin-caschi";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }

        
    }
}
