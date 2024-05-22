package com.generation.progettofinale.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.generation.progettofinale.dao.DaoCasco;
import com.generation.progettofinale.models.Casco;


@Service
public class ServiceCasco extends GenericService<Long, Casco, DaoCasco> {

    public List<Casco> search(String prodotto, Integer prezzoMax, Boolean visieraOscurata){
        Map<Long, Casco> result=getDao().search(prodotto, prezzoMax, visieraOscurata);
        List<Casco> list=new ArrayList<>();
        for(Casco c: result.values()){
            list.add(c);
        }
        return list;
    }
}