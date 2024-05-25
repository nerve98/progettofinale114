package com.generation.progettofinale.dao;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


import com.generation.progettofinale.models.Casco;

import lombok.Data;

@Data
@Service
public class DaoCasco implements IDao<Long, Casco>{
    
    private final Database database;

    private final ApplicationContext context;

    @Override
    public Long create(Casco e) {
        String query="INSERT INTO casco (modello, nomeCasco, visieraOscurata, coloreCasco, prezzo) VALUES (?,?,?,?,?)";
        Long id=null;
        if (e!=null && e instanceof Casco) {
            id=database.executeDML(query, e.getModello(), e.getNomeCasco(), e.getVisieraOscurata()?"1":"0", e.getColoreCasco(), String.valueOf(e.getPrezzo()));
        }
        return id;
    }

    @Override
    public Map<Long, Casco> read() {
        String query = "select * from casco";
        Map<Long, Map<String, String>> caschi = database.executeDQL(query);
        Casco c=null;
        Map<Long, Casco> caschiMap = new HashMap<>();
        for(Map<String, String> map: caschi.values()){
            map.put("visieraOscurata", map.get("visieraOscurata").equals("1")?"true":"false");
            c=context.getBean(Casco.class, map);
            caschiMap.put(c.getId(), c);
        }
        return caschiMap;
    }


    public Map<Long, Casco> search(String prodotto, Integer prezzoMax, Boolean visieraOscurata) {
        String query = "select * from casco where $1 $2 $3";
        boolean oneParam=false;
        List<String> parametri=new ArrayList<>();
        if(prodotto!=null && !prodotto.isEmpty()) {
            query=query.replace("$1", "nomeCasco like CONCAT( ?,'%') or nomeCasco like CONCAT('% ',?,'%') or modello like CONCAT( ?,'%') or modello like CONCAT('% ',?,'%')");
            parametri.add(prodotto);
            parametri.add(prodotto);
            parametri.add(prodotto);
            parametri.add(prodotto);
            oneParam=true;
        }
        else {
            query=query.replace("$1", "");
        }
        if(prezzoMax!=null) {
            if(oneParam){
                query=query.replace("$2"," and  $2");
                System.out.println(query);
            }
            else{
                oneParam=true;
            }
            query=query.replace("$2", "prezzo<=?");
            parametri.add(String.valueOf(prezzoMax));
        }
        else {
            query=query.replace("$2", "");
        }
        if(visieraOscurata!=null) {
            if(oneParam){
                query=query.replace("$3"," and  $3");
            }
            else{
                oneParam=true;
            }
            query=query.replace("$3", "visieraOscurata=?");
            parametri.add(visieraOscurata?"1":"0");
        }
        else {
            query=query.replace("$3", "");
        }
        System.out.println(query);
        Map<Long, Map<String, String>> caschi = database.executeDQL(query, parametri.toArray(new String[parametri.size()]));
        Casco c=null;
        Map<Long, Casco> caschiMap = new HashMap<>();
        for(Map<String, String> map: caschi.values()){
            map.put("visieraOscurata", map.get("visieraOscurata").equals("1")?"true":"false");
            c=context.getBean(Casco.class, map);
            caschiMap.put(c.getId(), c);
        }
        return caschiMap;
    }


    @Override
    public void update(Casco e) {
        String query = "UPDATE casco SET modello=?, nomeCasco=?, visieraOscurata=?, coloreCasco=?, prezzo=? WHERE id=?";
        database.executeDML(query, e.getModello(), e.getNomeCasco(), e.getVisieraOscurata()?"1":"0", e.getColoreCasco(), String.valueOf(e.getPrezzo()), String.valueOf(e.getId()));
    }

    @Override
    public void delete(Long id) {
        String query="DELETE FROM casco WHERE id=?";
        database.executeDML(query, String.valueOf(id));
    }

    @Override
    public Casco readById(Long id) {
        String query = "select * from casco where id=?";
        Map<Long, Map<String, String>> caschi = database.executeDQL(query, String.valueOf(id));
        Casco c=null;
        for(Map<String, String> map: caschi.values()){
            map.put("visieraOscurata", map.get("visieraOscurata").equals("1")?"true":"false");
            c=context.getBean(Casco.class, map);
        }
        return c;
    }
    
}
