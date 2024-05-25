package com.generation.progettofinale.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.progettofinale.Services.ServiceAbbigliamento;
import com.generation.progettofinale.Services.ServiceCasco;
import com.generation.progettofinale.Services.ServiceMoto;
import com.generation.progettofinale.models.Entity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerCarrello {

    @Autowired
    private ServiceAbbigliamento serviceAbbigliamento;

    @Autowired
    private ServiceMoto serviceMoto;

    @Autowired
    private ServiceCasco serviceCasco;

    @GetMapping("/addCarrello")
    public String abbigliamentoById(@RequestParam (name="idProdotto") Long idProdotto, 
    @RequestParam (name="tipoProdotto") String tipoProdotto,
    HttpSession session,
    Model model,
    HttpServletRequest request){
        List<Entity> carrello = (List<Entity>) session.getAttribute("carrello");
        if(carrello==null){
            carrello = new ArrayList<Entity>();
        }
        Entity entity=null;
        switch (tipoProdotto) {
            case "moto":
                entity=serviceMoto.findById(idProdotto);
                break;
            case "casco":
                entity=serviceCasco.findById(idProdotto);
                break;
            case "abbigliamento":
                entity=serviceAbbigliamento.findById(idProdotto);
                break;
        }
        carrello.add(entity);
        session.setAttribute("carrello", carrello);
        String referer = request.getHeader("Referer");
        System.out.println("\n\n\n\n\nLISTA CARRELLO!!!!!!!!!!!: "+carrello+"\n\n\n\n\n");
        return "redirect:"+ referer;
    }
    
}
