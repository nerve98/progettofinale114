package com.generation.progettofinale.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
@ConditionalOnProperty(name = "db.type", havingValue = "mysql")
public class DatabaseMySql implements Database{

    @Value("${db.mysql.username}")
    private String username;

    @Value("${db.mysql.password}")
    private String password;

    @Value("${db.mysql.url}")
    private String path;

    @Value("${db.mysql.timezone}")
    private String timeZone;

    @Value("${db.mysql.schema}")
    private String nomeDb;

    private Connection connection;

    //Inserisco il costruttore vuoto per poter utilizzare l'annotazione @Service di Spring Boot 
    //Spring ha bisogno di un costruttore vuoto per creare un @Bean
    public DatabaseMySql() {}

    @PostConstruct //Questa annotazione permette di eseguire il metodo subito dopo la creazione dell'oggetto(Costruttore)
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(path + nomeDb + timeZone, username, password);
        }
        catch(SQLException e){
            System.out.println("Errore connessione: " + e.getMessage());
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver non trovato");
        }
    }

    public void closeConnection(){
        try{
            connection.close();
        }
        catch(SQLException e){
            System.out.println("Errore chiusura connessione");
        }
    }
    public Connection getConnection(){
        return connection;
    }



    @Override
    public Long executeDML(String query, String... params) {
        Long id=-1L;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String generatedColumns[] = { "id" };
            ps = connection.prepareStatement(query, generatedColumns);
            for(int i=0;i<params.length;i++){
                ps.setString(i+1, params[i]);
            }
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                id = rs.getLong(1);
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }

        }catch(Exception e){
            System.out.println("Errore nella creazione dello statement " + e.getMessage());
            e.printStackTrace();
            return -2L;
        }
        return id;
    }

    @Override
    public Map<Long, Map<String, String>> executeDQL(String query, String... params) {
       Map<Long, Map<String, String>> result = new HashMap<>();
       PreparedStatement ps = null;
       ResultSet rs = null;
         try{
              ps = connection.prepareStatement(query);
              for(int i = 0; i < params.length; i++){
                ps.setString(i+1, params[i]);
              }
              rs = ps.executeQuery();
              Map<String, String> mappaProprietà;
              int columnCount = rs.getMetaData().getColumnCount();
              while(rs.next()){
                mappaProprietà = new HashMap<>();
                for(int i = 1; i <= columnCount; i++){
                    mappaProprietà.put(rs.getMetaData().getColumnName(i),
                     rs.getString(i));
                }
                result.put(rs.getLong("id"), mappaProprietà);
            }
            if(ps != null){
                ps.close();
              }
              if(rs != null){
                rs.close();
              }
            }catch(Exception e){
                e.printStackTrace();
            }
            return result;
    }
    
}

