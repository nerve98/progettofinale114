package com.generation.progettofinale.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.generation.progettofinale.Services.ServiceAbbigliamento;
import com.generation.progettofinale.Services.ServiceImmagini;
import com.generation.progettofinale.models.Abbigliamento;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Immagini;
import com.generation.progettofinale.models.Utente;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerAbbigliamento {

    @Autowired
    private ServiceAbbigliamento serviceAbbigliamento;

    @Autowired
    private ServiceImmagini serviceImmagini;





    @GetMapping("/abbigliamento")
    public String abbigliamento(Model model,
        @RequestParam (name = "abbigliamento") Optional<String> paramAbbigliamento,
        @RequestParam (name = "prezzoMax") Optional<Integer> paramPrezzoMax,
        @RequestParam (name ="protezione") Optional<Boolean> paramProtezione,HttpSession session){
        String abbigliamento = paramAbbigliamento.orElse(null);
        Integer prezzoMax = paramPrezzoMax.orElse(null);
        Boolean protezione = paramProtezione.orElse(null);
        System.out.println("*******\n"+abbigliamento+"\n*******");
        List<Abbigliamento> vestiti;
        List<Immagini> immagini;
        if((abbigliamento==null || abbigliamento.isEmpty()) && (prezzoMax==null) && (protezione==null)){
            vestiti = serviceAbbigliamento.findAll();
            immagini = serviceImmagini.findImmaginiAbbigliamento(vestiti);
        }
        else{
            vestiti = serviceAbbigliamento.search(abbigliamento, prezzoMax, protezione);
            immagini = serviceImmagini.findImmaginiAbbigliamento(vestiti);
        }
        model.addAttribute("vestiti", vestiti);
        model.addAttribute("immagini", immagini);
        model.addAttribute("isAdmin", session.getAttribute("admin"));
        model.addAttribute("loggato", session.getAttribute("loggato"));
        List<Entity> carrello=(List<Entity>) session.getAttribute("carrello");
        if(carrello!=null && carrello.size()>0){
            model.addAttribute("numCarrello", carrello.size());
        }
        /*else{
            model.addAttribute("numCarrello", 0);
        }*/
        System.out.println(immagini);
        return "abbigliamentov3.html";
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
                if(loggato.equals("ok")){
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
    








