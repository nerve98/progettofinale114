package com.generation.progettofinale.Services;

import com.generation.progettofinale.dao.DaoUtente;
import com.generation.progettofinale.models.Utente;

public class ServiceUtente extends GenericService<Long, Utente, DaoUtente>{

    public Utente findByUsernameAndPassword(String username, String password){
        Utente utente= getDao().readUsernameAndPassword(username, password);
        return utente;
    }
}
