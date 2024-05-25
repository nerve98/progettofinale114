package com.generation.progettofinale.dao;

import com.generation.progettofinale.models.Moto;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Data
@Service
public class DaoMoto implements IDao<Long, Moto>{


    private final Database db;
    private final ApplicationContext context;
    private String query;


    @Override
    public Long create(Moto e) {

       query = "INSERT INTO moto (cilindrata,capacitaSerbatoio,potenzaCV,potenzaKV,peso,altezzaSella,consumo,prezzo,elettronico,trasmissioneM,euro,nomeMotore,marca,tipoMoto,coloreMoto,targa,annoProduzione) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       return db.executeDML(query,
       String.valueOf(e.getCilindrata()),
       String.valueOf(e.getCapacitaSerbatoio()),
       String.valueOf(e.getPotenzaCV()),
       String.valueOf(e.getPotenzaKV()),
       String.valueOf(e.getPeso()),
       String.valueOf(e.getAltezzaSella()),
       String.valueOf(e.getConsumo()),
       String.valueOf(e.getPrezzo()),
       String.valueOf(e.isElettronico()?1:0),
       String.valueOf(e.isTrasmissioneM()?1:0),
       e.getEuro(),
       e.getNomeMotore(),
       e.getMarca(),
       e.getTipoMoto(),
       e.getColoreMoto(),
       e.getTarga(),
       String.valueOf(e.getAnnoProduzione()));
       
    }


    @Override
    public Map<Long, Moto> read() {

        query= "SELECT * FROM moto";
        Map<Long, Map<String, String>> motoMap=db.executeDQL(query);
        Map<Long,Moto> moto = new HashMap<>();
        for(Map<String,String> map: motoMap.values()){
            map.put("elettronico", map.get("elettronico").equals("1")?"true":"false");
            map.put("trasmissioneM", map.get("trasmissioneM").equals("1")?"true":"false");
            Moto m=context.getBean(Moto.class,map);
            moto.put(m.getId(),m);
        }
        return moto;

    }


    @Override
    public void update(Moto e) {

        query="UPDATE moto SET cilindrata=?,capacitaSerbatoio=?,potenzaCV=?,potenzaKV=?,peso=?,altezzaSella=?,consumo=?,prezzo=?,elettronico=?,trasmissioneM=?,euro=?,nomeMotore=?,marca=?,tipoMoto=?,coloreMoto=?,targa=?,annoProduzione=? WHERE id=?";
        db.executeDML(query, String.valueOf(e.getCilindrata()),
        String.valueOf(e.getCapacitaSerbatoio()),
        String.valueOf(e.getPotenzaCV()),
        String.valueOf(e.getPotenzaKV()),
        String.valueOf(e.getPeso()),
        String.valueOf(e.getAltezzaSella()),
        String.valueOf(e.getConsumo()),
        String.valueOf(e.getPrezzo()),
        String.valueOf(e.isElettronico()?1:0),
        String.valueOf(e.isTrasmissioneM()?1:0),
        e.getEuro(),
        e.getNomeMotore(),
        e.getMarca(),
        e.getTipoMoto(),
        e.getColoreMoto(),
        e.getTarga(),
        String.valueOf(e.getAnnoProduzione()),
        String.valueOf(e.getId()));
    }



    @Override
    public void delete(Long id) {

        query="DELETE FROM moto WHERE id=?";
        db.executeDML(query, String.valueOf(id));

    }


    @Override
    public Moto readById(Long id) {

       query="SELECT * FROM moto WHERE id=?";
       //db.executeDML(query, String.valueOf(id));
       Map<Long, Map<String, String>> motoMap=db.executeDQL(query, String.valueOf(id));
       Moto m=null;
       for(Map<String,String> map: motoMap.values()){
            map.put("elettronico", map.get("elettronico").equals("1")?"true":"false");
            map.put("trasmissioneM", map.get("trasmissioneM").equals("1")?"true":"false");
           m=context.getBean(Moto.class,map);
        }

        return m;
    }

    public List<Moto> readByTipoMoto(String tipo) {
        query="SELECT * FROM moto WHERE tipoMoto=?";
        Map<Long, Map<String, String>> motoMap=db.executeDQL(query, tipo);
        List<Moto> m= new ArrayList<>();
        for(Map<String,String> map: motoMap.values()){
            map.put("elettronico", map.get("elettronico").equals("1")?"true":"false");
            map.put("trasmissioneM", map.get("trasmissioneM").equals("1")?"true":"false");
            m.add(context.getBean(Moto.class,map));
        }
        return m;
    }
            
}
