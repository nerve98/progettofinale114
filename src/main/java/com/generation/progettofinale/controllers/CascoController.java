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
    public String caschi(Model model) {
        List<Casco> ris = serviceCasco.findAll();
        model.addAttribute("caschi", ris);
        return "caschi.html";
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
                    return "redirect:/caschi";
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
                    return "redirect:/caschi";
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
    public String eliminaAlimentare(@RequestParam(name = "idCasco", defaultValue = "0") Long idCasco, HttpSession session, Model model){

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
                    return "redirect:/caschi";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }

        
    }

    @GetMapping("/casco-byId")
    public String consoleById(@RequestParam(name = "idCasco", defaultValue = "0") Long idCasco, HttpSession session, Model model){
        Casco casco = serviceCasco.findById(idCasco);
        if(casco==null){
            model.addAttribute("error", "Errore nella ricerca della console associato al parametro idConsole con id = "+idCasco);
            return "paginaErrore.html";
        }
        else{
            model.addAttribute("casco", casco);
            return "dettaglioCasco.html";
        }
    }


}
