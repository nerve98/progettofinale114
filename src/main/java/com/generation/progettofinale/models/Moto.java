package com.generation.progettofinale.models;

import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Moto extends Entity{
    private int cilindrata,capacitaSerbatoio,potenzaCV,potenzaKV;
    private double peso,altezzaSella,consumo,prezzo;
    private boolean elettronico,trasmissioneM;
    private String euro,nomeMotore,marca,tipoMoto,coloreMoto,targa;
    private Date annoProduzione;
}
