package com.generation.progettofinale.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceMoto;
import com.generation.progettofinale.models.Moto;

import jakarta.servlet.http.HttpSession;
import com.generation.progettofinale.models.Utente;

@Controller
public class AdminControllerMoto {
    
    @Autowired
    private ServiceMoto serviceMoto;
    @GetMapping("/admin-moto")
    public String moto(Model model, HttpSession session) {
        List<Moto> ris = serviceMoto.findAll();
        model.addAttribute("moto", ris);
        return "adminMoto.html";
    }

    @GetMapping("/elimina-moto")
    public String eliminaMoto(@RequestParam(name = "idMoto", defaultValue = "0") Long idMoto, Model model, HttpSession session){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = (String) session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;

        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            loggato = (String) loggatoObj;
            utente = (Utente) utenteObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    if(idMoto==0){
                        model.addAttribute("error", "Errore nell'eliminazione della moto");
                        return "paginaErrore.html";
                    }
                    serviceMoto.delete(idMoto);
                    return "redirect:/admin-moto";
                }
            }
            return "redirect:/login";
         }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }


    }


    @PostMapping("/modifica-moto")
    public String modificaMoto(@RequestParam Map<String,String> parametri, HttpSession session, Model model){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = (String) session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;

        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            loggato = (String) loggatoObj;
            utente = (Utente) utenteObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    serviceMoto.update(parametri);
                    return "redirect:/admin-moto";
                }
                else{
                    return "redirect:/login";
                }
            }
            else{
                return "redirect:/login";
            }
            
         }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }   
    }

    @PostMapping("/inserisci-moto")  
    public String inserisciMoto(@RequestParam Map<String,String> parametri, HttpSession session, Model model){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = (String) session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;
        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            loggato = (String) loggatoObj;
            utente = (Utente) utenteObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    serviceMoto.insert(parametri);
                    return "redirect:/admin-moto";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }        
    }

    
    @GetMapping ("/moto-ById")
    public String motoById(@RequestParam(name = "idMoto", defaultValue = "0") Long idMoto, Model model){
        Moto moto = serviceMoto.findById(idMoto);
        if (moto == null){
            model.addAttribute("error", "Moto non trovata");
            return "paginaErrore.html"; 
        }else {
            model.addAttribute("moto", moto);
            return "dettaglioMoto.html";
        }
    }
}
