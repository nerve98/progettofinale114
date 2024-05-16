package com.generation.progettofinale.models;

import java.sql.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class Utente extends Entity{
    private String username, password, nome, cognome, email,numeroCellulare;
    private Date dataNascita;
    private boolean admin;
    
}