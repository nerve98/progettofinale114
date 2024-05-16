package com.generation.progettofinale.dao;

import java.util.HashMap;
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
        String.valueOf(e.isProtezione()),
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
        String.valueOf(e.isProtezione()),
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
        databaseMySql.executeDML(query,String.valueOf(id));
        Map<Long,Map<String,String>> vestiti = databaseMySql.executeDQL(query,String.valueOf(id));
        Abbigliamento a = null;
        for(Map<String,String> map : vestiti.values()){
            a = context.getBean(Abbigliamento.class, map);
        }
        
        return a;
    }

}