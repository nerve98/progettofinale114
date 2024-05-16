package com.generation.progettofinale.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = false)
@Data
public class Immagini extends Entity{
    
    private String nome, url;
    private Long idMoto, idCasco, idAbbigliamento;
    
}
