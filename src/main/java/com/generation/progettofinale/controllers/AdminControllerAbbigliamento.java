package com.generation.progettofinale.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceAbbigliamento;
import com.generation.progettofinale.models.Utente;

import jakarta.servlet.http.HttpSession;


@Controller
public class AdminControllerAbbigliamento {
    @Autowired
    private ServiceAbbigliamento serviceAbbigliamento;

    @GetMapping("/admin-abbigliamento")
    public String abbigliamento(Model model) {
        model.addAttribute("vestiti", serviceAbbigliamento.findAll());
        return "adminAbbigliamento.html";
    }

    @PostMapping("/inserisci-abbigliamento")
    public String inserisciConsole(@RequestParam 
    Map<String,String> paramsAbb, 
    HttpSession session, 
    Model model){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;
        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            utente = (Utente) utenteObj;
            loggato = (String) loggatoObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    serviceAbbigliamento.insert(paramsAbb);
                    return "redirect:/admin-abbigliamento";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }
    }




    @PostMapping("/modifica-abbigliamento")
    public String modificaAbbigliamento(@RequestParam 
    Map<String,String> paramsAbb,
    HttpSession session, 
    Model model){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;
        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            utente = (Utente) utenteObj;
            loggato = (String) loggatoObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    serviceAbbigliamento.update(paramsAbb);
                    return "redirect:/admin-abbigliamento";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }
    }




    @GetMapping("/elimina-abbigliamento")
    public String eliminaAbbigliamento(@RequestParam
    (name="idAbbigliamento", defaultValue="0") 
    Long idAbbigliamento,
    HttpSession session,
    Model model){
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;
        if(loggatoObj instanceof String && utenteObj instanceof Utente){
            utente = (Utente) utenteObj;
            loggato = (String) loggatoObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    if(idAbbigliamento == 0){
                        model.addAttribute("error","errore nella eliminazione dell'abbigliamento");
                        return "paginaErrore.html";
                    }
                    serviceAbbigliamento.delete(idAbbigliamento);
                    return "redirect:/admin-abbigliamento";
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