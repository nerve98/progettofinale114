package com.generation.progettofinale.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Casco extends Entity{
    private String modello;
    private String nomeCasco;
    private Boolean visieraOscurata;
    private String coloreCasco;
    private Double prezzo;
}
