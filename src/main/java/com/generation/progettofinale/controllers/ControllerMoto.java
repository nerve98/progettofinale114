package com.generation.progettofinale.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceImmagini;
import com.generation.progettofinale.Services.ServiceMoto;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Immagini;
import com.generation.progettofinale.models.Moto;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerMoto {
    
    @Autowired
    private ServiceMoto serviceMoto;

    @Autowired
    private ServiceImmagini serviceImmagini;

    @GetMapping("/sportive")
    public String sportive(Model model,HttpSession session){
        List<Moto> ris = serviceMoto.readByTipoMoto("sportiva");
        model.addAttribute("motori", ris);
        model.addAttribute("isAdmin", session.getAttribute("admin"));
        model.addAttribute("loggato", session.getAttribute("loggato"));
        List<Entity> carrello=(List<Entity>) session.getAttribute("carrello");
        List<Immagini> imm = serviceImmagini.findAll();
        model.addAttribute("immagini", ris);
        if(carrello!=null && carrello.size()>0){
        model.addAttribute("numCarrello", carrello.size());
    }
        return "paginaSportive.html";
    }

    @GetMapping("/addtoCart")
    public String addtoCart(HttpSession session, @RequestParam(name="idmotoAdd") String id ){

        List<Entity> motoadd= new ArrayList<Entity>();
        motoadd = (List<Entity>) session.getAttribute("listaSpesa");

        motoadd.add(serviceMoto.findById(Long.parseLong(id)));

        session.setAttribute("listaSpesa", motoadd ); 
        return "redirect:/sportive";
    }
    
}