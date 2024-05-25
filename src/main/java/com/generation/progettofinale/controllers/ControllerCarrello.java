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
import com.generation.progettofinale.models.Abbigliamento;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Moto;
import com.generation.progettofinale.models.Utente;

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

    @GetMapping("/carrello")
    public String carrello() {
        return "carrello.html";
    }

    @GetMapping("/addCarrello")
    public String abbigliamentoById(@RequestParam(name = "idProdotto") Long idProdotto,
            @RequestParam(name = "tipoProdotto") String tipoProdotto,
            HttpSession session,
            Model model,
            HttpServletRequest request) {
        Object utenteObj = session.getAttribute("utente");
        Object loggatoObj = (String) session.getAttribute("loggato");
        Utente utente = null;
        String loggato = null;

        List<Entity> carrello = (List<Entity>) session.getAttribute("carrello");
        if (carrello == null) {
            carrello = new ArrayList<Entity>();
        }
        Entity entity = null;
        switch (tipoProdotto) {
            case "moto":
                entity = serviceMoto.findById(idProdotto);
                break;
            case "casco":
                entity = serviceCasco.findById(idProdotto);
                break;
            case "abbigliamento":
                entity = serviceAbbigliamento.findById(idProdotto);
                break;
        }
        carrello.add(entity);
        session.setAttribute("carrello", carrello);

        System.out.println("\n\n\n\n\nLISTA CARRELLO!!!!!!!!!!!: " + carrello + "\n\n\n\n\n");

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/lista-carrello")
    public String carrello(HttpSession session, Model model) {
        List<Entity> carrello = (List<Entity>) session.getAttribute("carrello");
        List<Abbigliamento> vestiti = new ArrayList<>();
        List<Casco> caschi = new ArrayList<>();
        List<Moto> moto = new ArrayList<>();
        double totale = 0;
        if (carrello != null) {
            for (Entity entity : carrello) {
                if (entity instanceof Abbigliamento) {
                    vestiti.add((Abbigliamento) entity);
                    totale += ((Abbigliamento) entity).getPrezzo();
                } else if (entity instanceof Casco) {
                    caschi.add((Casco) entity);
                    totale += ((Casco) entity).getPrezzo();
                } else if (entity instanceof Moto) {
                    moto.add((Moto) entity);
                    totale += ((Moto) entity).getPrezzo();
                }
            }
        }
        model.addAttribute("vestiti", vestiti);
        model.addAttribute("caschi", caschi);
        model.addAttribute("moto", moto);
        model.addAttribute("totale", totale);
        return "carrello.html";
    }

    @GetMapping("/rimuovi-carrello")
    public String rimuoviById(HttpSession session, Model model, @RequestParam(name = "id") Long id, @RequestParam(name = "tipo") String tipo) {
        List<Entity> carrello = (List<Entity>) session.getAttribute("carrello");
        if (carrello != null) {
            for (Entity entity : carrello) {
                if (entity.getId() == id) {
                    if(entity instanceof Abbigliamento && tipo.equals("abbigliamento")){
                        carrello.remove(entity);
                        break;
                    }
                    else if(entity instanceof Casco && tipo.equals("casco")){
                        carrello.remove(entity);
                        break;
                    }
                    else if(entity instanceof Moto && tipo.equals("moto")){
                        carrello.remove(entity);
                        break;
                    }
                    
                }
            }
        }
        session.setAttribute("carrello", carrello);
        return "redirect:/lista-carrello";
    }

}