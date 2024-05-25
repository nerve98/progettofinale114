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

    @GetMapping("/admin-immagini")
    public String immagini(Model model, HttpSession session) {
    List<Immagini> ris = serviceImmagini.findAll();
    model.addAttribute("immagini", ris);
    return "adminImmagini.html";
    }
    

    @PostMapping("/inserisci-immagine")
    public String inserisciImmagine(@RequestParam
    Map<String,String> paramsImm,
    HttpSession session, 
    Model model){
        System.out.println("PARAMSIMM\n**********\n"+paramsImm.keySet()+"\n**********\n"+paramsImm.values());
    Object utenteObj = session.getAttribute("utente");
    Object loggatoObj = session.getAttribute("loggato");
    Utente utente = null;
    String loggato = null;
        if(loggatoObj instanceof String && 
        utenteObj instanceof Utente){
            utente = (Utente) utenteObj;
            loggato = (String) loggatoObj;
            if(loggato!=null && utente!=null){
                if(loggato.equals("ok") && utente.isAdmin()){
                    serviceImmagini.insert(paramsImm);
                    return "redirect:/admin-immagini";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }
    }




       
    @PostMapping("/modifica-immagine")
    public String modificaImmagine(@RequestParam 
    Map<String,String> paramsImm,
    HttpSession session,
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
                    serviceImmagini.update(paramsImm);
                    return "redirect:/admin-immagini";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }
    }









    @GetMapping("/elimina-immagine")
    public String eliminaImmagine(@RequestParam
    (name="idImmagine", defaultValue="0") 
    Long idImmagine,
    HttpSession session,
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
                    if(idImmagine == 0){
                        model.addAttribute("error",
                                          "errore nella eliminazione dell'immagine");
                        return "paginaErrore.html";
                    }
                    serviceImmagini.delete(idImmagine);
                    return "redirect:/immagini";
                }
            }
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Ops, si è verificato un errore");
            return "paginaErrore.html";
        }
    }






    @GetMapping("/immagini-byId")
    public String immaginiById(@RequestParam(
        name="idImmagine", defaultValue="0") 
        Long idImmagine, HttpSession session,
        Model model){
        Immagini immagine = serviceImmagini.findById(idImmagine);
        if(immagine==null){
            model.addAttribute("error", "Errore nella ricerca dell'immagine associato al parametro con id = "+ idImmagine);
            return "paginaErrore.html"; 
        }
        else{
            model.addAttribute("immagine", immagine);
            return "dettaglioImmagine.html";
        }
    }

}
