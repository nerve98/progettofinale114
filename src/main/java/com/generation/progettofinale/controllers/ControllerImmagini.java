package com.generation.progettofinale.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceImmagini;
import com.generation.progettofinale.models.Immagini;
import com.generation.progettofinale.models.Utente;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerImmagini {


@Autowired
private ServiceImmagini serviceImmagini;

@GetMapping("/immagini")
public String immagini(Model model) {
    List<Immagini> ris = serviceImmagini.findAll();
    model.addAttribute("immagini", ris);
    return "immagini.html";
    }
    

    @PostMapping("/inserisci-immagine")
    public String inserisciImmagine(@RequestParam
    Map<String,String> paramsImm,
    HttpSession session, Model model){
        boolean isAdmin = false;
        Object utente = session.getAttribute("utente");
        if(utente != null && utente instanceof Utente){
            Utente u = (Utente) utente;
            if(u.isAdmin()){
                isAdmin = true;
            }
        }
        model.addAttribute("isAdmin", isAdmin);
        serviceImmagini.insert(paramsImm);
        return "redirect:/immagini";
    }
    @PostMapping("/modifica-immagine")
    public String modificaImmagine(@RequestParam 
    Map<String,String> paramsImm){
        serviceImmagini.update(paramsImm);
        return "redirect:/immagini";
    }

    @GetMapping("/elimina-immagine")
    public String eliminaImmagine(@RequestParam
    (name="idImmagine", defaultValue="0") 
    Long idImmagine, Model model){
        if(idImmagine == 0){
            model.addAttribute("error",
                              "errore nell'eliminazione dell'immagine");
        }else{
            serviceImmagini.delete(idImmagine);
        }
        return "redirect:/immagini";
    }

    @GetMapping("/immagini-byId")
    public String immaginiById(@RequestParam(
        name="idImmagine", defaultValue="0") 
        Long idImmagine, Model model){
        if(idImmagine == 0){
            model.addAttribute("error",
                              "errore nella ricerca dell'immagine");
            return "paginaErrore.html";
        }
        Immagini immagine = serviceImmagini.findById(idImmagine);
        model.addAttribute("immagine", immagine);
        return "dettaglioImmagine.html";
    }

}
