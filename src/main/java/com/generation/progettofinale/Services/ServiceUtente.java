package com.generation.progettofinale.Services;

import org.springframework.stereotype.Service;

import com.generation.progettofinale.dao.DaoUtente;
import com.generation.progettofinale.models.Utente;

import lombok.Data;

@Service
@Data
public class ServiceUtente extends GenericService<Long, Utente, DaoUtente>{

    public Utente findByUsernameAndPassword(String username, String password){
        Utente utente= getDao().readUsernameAndPassword(username, password);
        return utente;
    }
}
