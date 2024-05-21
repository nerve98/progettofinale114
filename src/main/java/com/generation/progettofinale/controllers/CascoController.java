package com.generation.progettofinale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import com.generation.progettofinale.Services.ServiceCasco;
import com.generation.progettofinale.Services.ServiceImmagini;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.models.Immagini;


import jakarta.servlet.http.HttpSession;

@Controller
public class CascoController {
    @Autowired
    private ServiceCasco serviceCasco;

    @Autowired
    private ServiceImmagini serviceImmagini;

    @GetMapping("/caschi")
    public String caschi(Model model) {
        List<Casco> caschi = serviceCasco.findAll();
        List<Immagini> immagini = serviceImmagini.findImmaginiCaschi(caschi);
        model.addAttribute("caschi", caschi);
        model.addAttribute("immagini", immagini);
        System.out.println(immagini);
        return "caschi.html";
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
