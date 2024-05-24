package com.generation.progettofinale.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceMoto;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Moto;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerMoto {
    
    @Autowired
    private ServiceMoto serviceMoto;

    @GetMapping("/sportive")
    public String sportive(Model model,HttpSession session){
        List<Moto> ris = serviceMoto.readByTipoMoto("sportiva");
        model.addAttribute("motori", ris);
        model.addAttribute("isAdmin", session.getAttribute("admin"));
        model.addAttribute("loggato", session.getAttribute("loggato"));
        return "paginaSportive.html";
    }

    @GetMapping("/addtoCart")
    public String addtoCart(HttpSession session, @RequestParam(name="idmotoAdd") String id ){

        Entity motoEntity = serviceMoto.findById(Long.parseLong(id));
        System.out.println(motoEntity);

        List<Entity> motoadd= (List<Entity>) session.getAttribute("listaSpesa");
        
        motoadd.add(motoEntity);

        session.setAttribute("listaSpesa", motoadd ); 
        return "redirect:/sportive";
    }
}