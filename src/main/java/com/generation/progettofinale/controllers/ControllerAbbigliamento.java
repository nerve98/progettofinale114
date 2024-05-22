package com.generation.progettofinale.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.generation.progettofinale.Services.ServiceAbbigliamento;
import com.generation.progettofinale.models.Abbigliamento;
import com.generation.progettofinale.models.Utente;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerAbbigliamento {

    @Autowired
    private ServiceAbbigliamento serviceAbbigliamento;





    @GetMapping("/abbigliamento")
    public String abbigliamento(Model model){
        List<Abbigliamento> ris = serviceAbbigliamento.findAll();
        model.addAttribute("vestiti", ris);
        return "abbigliamento.html";
    }


    @GetMapping("/abbigliamento-byId")
    public String abbigliamentoById(@RequestParam
    (name="idAbbigliamento", defaultValue="0") 
    Long idAbbigliamento, HttpSession session,
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
                    Abbigliamento abbigliamento = serviceAbbigliamento.findById(idAbbigliamento); // Convert Integer to Long
                   if( abbigliamento == null){
                          model.addAttribute("error","errore nella visualizzazione dell'abbigliamento");
                          return "paginaErrore.html";
                    }
                      model.addAttribute("abbigliamento", abbigliamento);
                      return "dettaglioabbigliamento.html";
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
    








