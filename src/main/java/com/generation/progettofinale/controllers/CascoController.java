package com.generation.progettofinale.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import com.generation.progettofinale.Services.ServiceCasco;
import com.generation.progettofinale.Services.ServiceImmagini;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Immagini;


import jakarta.servlet.http.HttpSession;

@Controller
public class CascoController {
    @Autowired
    private ServiceCasco serviceCasco;

    @Autowired
    private ServiceImmagini serviceImmagini;

    @GetMapping("/caschi")
    public String caschi(Model model, 
        @RequestParam(name = "casco") Optional<String> paramCasco, 
        @RequestParam(name = "visiera") Optional<Boolean> paramVisieraOscurata,
        @RequestParam(name = "prezzoMax") Optional<Integer> paramPrezzoMax,HttpSession session) {
        String casco = paramCasco.orElse(null);
        Integer prezzoMax = paramPrezzoMax.orElse(null);
        Boolean visieraOscurata = paramVisieraOscurata.orElse(null);
        List<Casco> caschi;
        List<Immagini> immagini;
        if((casco==null || casco.isEmpty()) && (prezzoMax==null) && (visieraOscurata==null)){
            caschi = serviceCasco.findAll();
            immagini = serviceImmagini.findImmaginiCaschi(caschi);
        }
        else{
            caschi = serviceCasco.search(casco, prezzoMax, visieraOscurata);
            immagini = serviceImmagini.findImmaginiCaschi(caschi);
        }
        model.addAttribute("caschi", caschi);
        model.addAttribute("immagini", immagini);
        model.addAttribute("isAdmin", session.getAttribute("admin"));
        model.addAttribute("loggato", session.getAttribute("loggato"));
        List<Entity> carrello=(List<Entity>) session.getAttribute("carrello");
        if(carrello!=null && carrello.size()>0){
            model.addAttribute("numCarrello", carrello.size());
        }
        return "caschiv3.html";
    }

    

    @GetMapping("/casco-byId")
    public String consoleById(@RequestParam(name = "idCasco", defaultValue = "0") Long idCasco, HttpSession session, Model model){
        Casco casco = serviceCasco.findById(idCasco);
        if(casco==null){
            model.addAttribute("error", "Errore nella ricerca della casco associato al parametro idCasco con id = "+idCasco);
            return "paginaErrore.html";
        }
        else{
            model.addAttribute("casco", casco);
            return "dettaglioCasco.html";
        }
    }


}
