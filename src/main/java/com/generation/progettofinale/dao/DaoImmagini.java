package com.generation.progettofinale.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.generation.progettofinale.models.Abbigliamento;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.models.Entity;
import com.generation.progettofinale.models.Immagini;
import com.generation.progettofinale.models.Moto;

import lombok.Data;
@Service
@Data
public class DaoImmagini implements IDao<Long, Immagini>{


    private final Database db;
    private final ApplicationContext context;
    private String query;
    
    @Override
    public Long create(Immagini e) {
        query = "INSERT INTO immagini (nome,url,idMoto,idCasco,idAbbigliamento) VALUES (?,?,?,?,?)";
        return db.executeDML(query, 
        e.getNome(),
        e.getUrl(), 
        String.valueOf(e.getIdMoto()),
        String.valueOf(e.getIdCasco()), 
        String.valueOf(e.getIdAbbigliamento()));
    }

    @Override
    public Map<Long, Immagini> read() {

        query= "SELECT * FROM immagini";
        Map<Long, Map<String, String>> immaginiMap=db.executeDQL(query);
        Map<Long,Immagini> immagine = new HashMap<>();
        for(Map<String,String> map: immaginiMap.values()){
            Immagini i=context.getBean(Immagini.class,map);
            immagine.put(i.getId(),i);
        }
        return immagine;
    }
    @Override
    public void update(Immagini e) {
        query = "UPDATE immagini SET nome=?, url=?, idMoto=?, idCasco=?, idAbbigliamento=? WHERE id=?";
        db.executeDML(query, 
        e.getNome(),
        e.getUrl(), 
        String.valueOf(e.getIdMoto()),
        String.valueOf(e.getIdCasco()), 
        String.valueOf(e.getIdAbbigliamento()),
        String.valueOf(e.getId()));
    }
    @Override
    public void delete(Long id) {

        query="DELETE FROM immagini WHERE id=?";
        db.executeDML(query, String.valueOf(id));

    }
    @Override
    public Immagini readById(Long id) {

       query="SELECT * FROM immagini WHERE id=?";
       Map<Long, Map<String, String>> immaginiMap=db.executeDQL(query, String.valueOf(id));
       Immagini i=null;
       for(Map<String,String> map: immaginiMap.values()){
           i=context.getBean(Immagini.class,map);
    }

    return i;
    }

    
    public Immagini readByForeignKey(Entity e) {
        String queryS="SELECT * FROM immagini";
        if(e instanceof Moto){
            queryS+=" WHERE idMoto=?";
        }
        else if(e instanceof Casco){
            queryS+=" WHERE idCasco=?";
        }
        else {
            queryS+=" WHERE idAbbigliamento=?";
        }
        Map<Long, Map<String, String>> immaginiMap=db.executeDQL(queryS, String.valueOf(e.getId()));
        Immagini i=null;
        for(Map<String,String> map: immaginiMap.values()){
            i=context.getBean(Immagini.class,map);
        }

        return i;
    }



    
}
