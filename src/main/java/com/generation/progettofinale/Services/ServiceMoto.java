package com.generation.progettofinale.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.progettofinale.dao.DaoMoto;
import com.generation.progettofinale.models.Moto;



@Service
public class ServiceMoto extends GenericService<Long, Moto, DaoMoto>{
    

    public List<Moto> readByTipoMoto(String tipoMoto){
        return getDao().readByTipoMoto(tipoMoto);
    }


}
