package com.generation.progettofinale.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.generation.progettofinale.models.Utente;

import lombok.Data;

@Data
@Service
public class DaoUtente implements IDao<Long, Utente>{
    
    private final Database database;

    private final ApplicationContext context;

    
        
    public Utente readUsernameAndPassword(String username, String password){
        String query="select * from utente where username=? and password=?";
        
        Map<Long, Map<String, String>> result=database.executeDQL(query, username, password);
        Utente u =null;
        for(Map<String, String> map: result.values()){
            map.put("admin", map.get("admin").equals("1")?"true":"false");
            u=context.getBean(Utente.class, map);
        }
        return u;
    }

    public Utente findUserByUsername(String username){
        String query="select * from utente where username=?";
        
        Map<Long, Map<String, String>> result=database.executeDQL(query, username);
        Utente u =null;
        for(Map<String, String> map: result.values()){
            map.put("admin", map.get("admin").equals("1")?"true":"false");
            u=context.getBean(Utente.class, map);
        }
        return u;
    }

    public Utente findUserByEmail(String email){
        String query="select * from utente where email=?";
        
        Map<Long, Map<String, String>> result=database.executeDQL(query, email);
        Utente u =null;
        for(Map<String, String> map: result.values()){
            map.put("admin", map.get("admin").equals("1")?"true":"false");
            u=context.getBean(Utente.class, map);
        }
        return u;
    }



    @Override
    public Long create(Utente u) {
        String query="insert into utente (username, password, numeroCellulare, email, nome, cognome, dataNascita, admin) values(?,?,?,?,?,?,?,?)";
        Long id=null;
        if (u!=null && u instanceof Utente) {
            id=database.executeDML(query, u.getUsername(), u.getPassword(), u.getNumeroCellulare(), u.getEmail(), u.getNome(), u.getCognome(), u.getDataNascita().toString(), u.isAdmin()?"1":"0");
        }
        return id;
    }


    @Override
    public Map<Long, Utente> read() {
        String query = "select * from utente";
        Map<Long, Map<String, String>> utenti = database.executeDQL(query);
        Utente u=null;
        Map<Long, Utente> utentiMap = new HashMap<>();
        for(Map<String, String> map: utenti.values()){
            map.put("admin", map.get("admin").equals("1")?"true":"false");
            u=context.getBean(Utente.class, map);
            utentiMap.put(u.getId(), u);
        }
        return utentiMap;
    }
    


    @Override
    public void update(Utente u) {
        String query = "UPDATE utente SET username=?, password=?, numeroCellulare=?, email=?, nome=?, cognome=?, dataNascita=?, admin=? WHERE id=?";
        database.executeDML(query, u.getUsername(), u.getPassword(), u.getNumeroCellulare(), u.getEmail(), u.getNome(), u.getCognome(), u.getDataNascita().toString(), u.isAdmin()?"1":"0", String.valueOf(u.getId()));
    }


    @Override
    public void delete(Long id) {
        String query="DELETE FROM utenti WHERE id=?";
        database.executeDML(query, String.valueOf(id));
    }


    @Override
    public Utente readById(Long id) {
        String query = "select * from utenti where id=?";
        Map<Long, Map<String, String>> utenti = database.executeDQL(query, String.valueOf(id));
        Utente u =null;
        for(Map<String, String> map: utenti.values()){
            map.put("admin", map.get("admin").equals("1")?"true":"false");
            u=context.getBean(Utente.class, map);
        }
        return u;
    }
}
