package com.generation.progettofinale.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = false)
@Data
public class Abbigliamento extends Entity{

private String nomeAbbigliamento, coloreAbbigliamento, materiale, brand;
private boolean protezione;
private double prezzo; 
}
