package com.generation.progettofinale.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Immagini extends Entity{
    
    private String nome, url;
    private Long idMoto, idCasco, idAbbigliamento;
    
}
