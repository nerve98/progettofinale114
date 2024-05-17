package com.generation.progettofinale.Services;

import org.springframework.stereotype.Service;

import com.generation.progettofinale.dao.DaoUtente;
import com.generation.progettofinale.models.Utente;


@Service
public class ServiceUtente extends GenericService<Long, Utente, DaoUtente>{

    public Utente findByUsernameAndPassword(String username, String password){
        Utente utente= getDao().readUsernameAndPassword(username, password);
        return utente;
    }

    public Utente findByUsername(String username){
        Utente utente= getDao().findUserByUsername(username);
        return utente;
    }

    public Utente findByEmail(String email){
        Utente utente= getDao().findUserByEmail(email);
        return utente;
    }
}
