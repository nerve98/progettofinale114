package com.generation.progettofinale.dao;
import java.util.Map;

public interface Database {

    Long executeDML(String query,String...params);

    Map<Long,Map<String,String>> executeDQL(String query,String...params);
    
}
