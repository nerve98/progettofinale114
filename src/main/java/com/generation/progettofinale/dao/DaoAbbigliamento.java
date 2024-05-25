package com.generation.progettofinale.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.generation.progettofinale.models.Abbigliamento;


import lombok.Data;

@Data
@Service
public class DaoAbbigliamento implements IDao<Long, Abbigliamento>{
    
    
    private final Database databaseMySql;

    private final ApplicationContext context;

    
    @Override
    public Long create(Abbigliamento e) {

        Long id = null;
        String query="INSERT INTO abbigliamento(nomeAbbigliamento, coloreAbbigliamento, protezione, materiale, brand, prezzo) VALUES(?,?,?,?,?,?)";
        databaseMySql.executeDML(query,
        e.getNomeAbbigliamento(),
        e.getColoreAbbigliamento(),
        String.valueOf(e.isProtezione()?1:0),
        e.getMateriale(),
        e.getBrand(),
        String.valueOf(e.getPrezzo()));     
        
        return id;
        
        }


    @Override
    public Map<Long, Abbigliamento> read() {

        String query="select * from abbigliamento";
        Map<Long, Map<String,String>> vestiti = databaseMySql.executeDQL(query);
        Map<Long,Abbigliamento> vestitiMap = new HashMap<>();

        for(Map<String,String> map : vestiti.values()){
            map.put("protezione", map.get("protezione").equals("1")?"true":"false");
            Abbigliamento a = context.getBean(Abbigliamento.class, map);
            vestitiMap.put(a.getId(), a);
        }

        return vestitiMap;
    }


    @Override
    public void update(Abbigliamento e) {

        String query="UPDATE abbigliamento SET nomeAbbigliamento=?, coloreAbbigliamento=?, protezione=?, materiale=?, brand=?, prezzo=? WHERE id=?";
        databaseMySql.executeDML(query,
        e.getNomeAbbigliamento(), 
        e.getColoreAbbigliamento(),
        String.valueOf(e.isProtezione()?1:0),
        e.getMateriale(),
        e.getBrand(),
        String.valueOf(e.getPrezzo()),
        String.valueOf(e.getId()));

    }


    @Override
    public void delete(Long id) {

        String query="DELETE FROM abbigliamento WHERE id=?";
        databaseMySql.executeDML(query,String.valueOf(id));

    }


    @Override
    public Abbigliamento readById(Long id) {

        String query="SELECT * FROM abbigliamento WHERE id=?";
        //databaseMySql.executeDML(query,String.valueOf(id));
        Map<Long,Map<String,String>> vestiti = databaseMySql.executeDQL(query,String.valueOf(id));
        Abbigliamento a = null;
        for(Map<String,String> map : vestiti.values()){
            map.put("protezione", map.get("protezione").equals("1")?"true":"false");
            a = context.getBean(Abbigliamento.class, map);
        }
        
        return a;
    }
       public Map<Long, Abbigliamento> search(String prodotto, Integer prezzoMax, Boolean protezione) {
        String query = "select * from abbigliamento where $1 $2 $3";
        boolean oneParam=false;
        List<String> parametri=new ArrayList<>();
        if(prodotto!=null && !prodotto.isEmpty()) {
            query=query.replace("$1", "nomeAbbigliamento like CONCAT( ?,'%') or nomeAbbigliamento like CONCAT('% ',?,'%')");
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
        if(protezione!=null) {
            if(oneParam){
                query=query.replace("$3"," and  $3");
            }
            else{
                oneParam=true;
            }
            query=query.replace("$3", "protezione=?");
            parametri.add(protezione?"1":"0");
        }
        else {
            query=query.replace("$3", "");
        }
        System.out.println(query);
        Map<Long, Map<String, String>> abbigliamento = databaseMySql.executeDQL(query, parametri.toArray(new String[parametri.size()]));
        Abbigliamento a=null;
        Map<Long, Abbigliamento> abbiMap = new HashMap<>();
        for(Map<String,String> map: abbigliamento.values()){
            map.put("protezione", map.get("protezione").equals("1")?"true":"false");
            a=context.getBean(Abbigliamento.class, map);
            abbiMap.put(a.getId(), a);
        }
        return abbiMap;
    }

}