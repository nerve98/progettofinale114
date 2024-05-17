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
        model.addAttribute("abbigliamento", ris);
        return "abbigliamento.html";
    }
    @PostMapping("/inserisci-abbigliamento")
    public String inserisciConsole(@RequestParam Map<String,String> paramsAbb, HttpSession session, Model model){
        boolean isAdmin = false;
        Object utente = session.getAttribute("utente");
        if(utente != null && utente instanceof Utente){
            Utente u = (Utente) utente;
            if(u.isAdmin()){
                isAdmin = true;
            }
        }
        model.addAttribute("isAdmin", isAdmin);
        serviceAbbigliamento.insert(paramsAbb);
        return "redirect:/abbigliamento";

    } 
    @PostMapping("/modifica-abbigliamento")
    public String modificaAbbigliamento(@RequestParam Map<String,String> paramsAbb){
        serviceAbbigliamento.update(paramsAbb);
        return "redirect:/abbigliamento";
    }

    @GetMapping("/elimina-abbigliamento")
    public String eliminaAbbigliamento(@RequestParam(name="idAbbigliamento", defaultValue="0") Long idAbbigliamento, Model model){
        if(idAbbigliamento == 0){
            model.addAttribute("error","errore nell'eliminazione dell'abbigliamento");
            return "paginaErrore.html";
        }
        serviceAbbigliamento.delete(idAbbigliamento); // Convert Integer to Long
        return "redirect:/abbigliamento";
    }
    @GetMapping("/abbigliamento-byId")
    public String abbigliamentoById(@RequestParam(
        name="idAbbigliamento", defaultValue="0") 
        Long idAbbigliamento, Model model){
        if(idAbbigliamento == null){
            model.addAttribute("error","errore nella visualizzazione dell'abbigliamento");
            return "paginaErrore.html";
        }
        Abbigliamento abbigliamento = serviceAbbigliamento.findById(idAbbigliamento); // Convert Integer to Long
        model.addAttribute("abbigliamento", abbigliamento);
        return "IdAbbigliamento.html";
    }

}






