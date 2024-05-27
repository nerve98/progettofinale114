package com.generation.progettofinale.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.generation.progettofinale.dao.DaoImmagini;
import com.generation.progettofinale.models.Abbigliamento;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Immagini;
import com.generation.progettofinale.models.Moto;



@Service
public class ServiceImmagini extends GenericService<Long, Immagini, DaoImmagini>{
    public List<Immagini> findImmaginiCaschi(List<Casco> lista){
        List<Immagini> ris= new ArrayList<>();
        for(Casco c: lista){
            ris.add(findImmagine(c));
        }
        return ris;
    }

    public List<Immagini> findImmaginiMoto(List<Moto> lista){
        List<Immagini> ris= new ArrayList<>();
        for(Moto m: lista){
            ris.add(findImmagine(m));
        }
        return ris;
    }

    public List<Immagini> findImmaginiAbbigliamento(List<Abbigliamento> lista){
        List<Immagini> ris= new ArrayList<>();
        for(Abbigliamento a: lista){
            ris.add(findImmagine(a));
        }
        return ris;
    }

    public Immagini findImmagine(Entity e){
        Immagini img= getDao().readByForeignKey(e);
        return img;
    }


    public List<Immagini> findImmagineLista(Entity e){
        List<Immagini> img= getDao().readByForeignKeyLista(e);
        return img;
    }
}
