package com.generation.progettofinale.dao;

import java.util.Map;
import java.util.HashMap;

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

    @Override
    public void update(Casco e) {
        String query = "UPDATE casco SET modello=?, nomeCasco=?, visieraOscurata=?, coloreCasco=?, prezzo=? WHERE id=?";
        database.executeDML(query, e.getModello(), e.getNomeCasco(), e.getVisieraOscurata()?"1":"0", e.getColoreCasco(), String.valueOf(e.getPrezzo()), String.valueOf(e.getId()));
    }

    @Override
    public void delete(Long id) {
        String query="DELETE FROM persone WHERE id=?";
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
