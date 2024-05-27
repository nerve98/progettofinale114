package com.generation.progettofinale.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

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
        query = "INSERT INTO immagini (nome,url,idMoto,idCasco,idAbbigliamento) VALUES (?,?,$1?,$2?,$3?)";
        List<String> values = new ArrayList<>();
        values.add(e.getNome());
        values.add(e.getUrl());
        if(e.getIdMoto()==null){
            query=query.replace(",idMoto", "");
            query=query.replace(",$1?", "");
        }
        else{
            query=query.replace("$1?", "?");
            values.add(String.valueOf(e.getIdMoto()));
        }
        if(e.getIdCasco()==null){
            query=query.replace(",idCasco", "");
            query=query.replace(",$2?", "");
        }
        else{
            query=query.replace("$2?", "?");
            values.add(String.valueOf(e.getIdCasco()));
        }
        if(e.getIdAbbigliamento()==null){
            query=query.replace(",idAbbigliamento", "");
            query=query.replace(",$3?", "");
        }
        else{
            query=query.replace("$3?", "?");
            values.add(String.valueOf(e.getIdAbbigliamento()));
        }
        /*return db.executeDML(query, 
        e.getNome(),
        e.getUrl(), 
        String.valueOf(e.getIdMoto()),
        String.valueOf(e.getIdCasco()), 
        String.valueOf(e.getIdAbbigliamento()));*/
        return db.executeDML(query, values.toArray(new String[values.size()]));
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
        query = "UPDATE immagini SET nome=?, url=?";
        List<String> values = new ArrayList<>();
        values.add(e.getNome());
        values.add(e.getUrl());
        if (e.getIdMoto() != null) {
            query += ", idMoto=?";
            values.add(String.valueOf(e.getIdMoto()));
        }
        if (e.getIdCasco() != null) {
            query += ", idCasco=?";
            values.add(String.valueOf(e.getIdCasco()));
        }
        if (e.getIdAbbigliamento() != null) {
            query += ", idAbbigliamento=?";
            values.add(String.valueOf(e.getIdAbbigliamento()));
        }
        query += " WHERE id=?";
        values.add(String.valueOf(e.getId()));
        db.executeDML(query, values.toArray(new String[values.size()]));}
    
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

    public List<Immagini> readByForeignKeyLista(Entity e) {
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
        List<Immagini> ris=new ArrayList<>();
        for(Map<String,String> map: immaginiMap.values()){
            ris.add(context.getBean(Immagini.class,map));
        }
        return ris;
    }



    
}
