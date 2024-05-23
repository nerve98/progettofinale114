package com.generation.progettofinale.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.generation.progettofinale.dao.DaoAbbigliamento;
import com.generation.progettofinale.models.Abbigliamento;


@Service
public class ServiceAbbigliamento extends GenericService<Long, Abbigliamento, DaoAbbigliamento>{
     public List<Abbigliamento> search(String prodotto, Integer prezzoMax, Boolean protezione){
        Map<Long, Abbigliamento> result=getDao().search(prodotto, prezzoMax, protezione);
        List<Abbigliamento> list=new ArrayList<>();
        for(Abbigliamento a: result.values()){
            list.add(a);
        }
        return list;
    }
}
