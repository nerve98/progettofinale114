package com.generation.progettofinale.Services;

import org.springframework.stereotype.Service;

import com.generation.progettofinale.dao.DaoCasco;
import com.generation.progettofinale.models.Casco;

@Service
public class ServiceCasco extends GenericService<Long, Casco, DaoCasco> {



    /*@Override
    public Casco createEntity(Map<String, String> map) {
        Casco s=getContext().getBean(Casco.class, map);
        return s;
    }*/
}