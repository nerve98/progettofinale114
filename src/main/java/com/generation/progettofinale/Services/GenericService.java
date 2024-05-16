package com.generation.progettofinale.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.generation.progettofinale.dao.IDao;
import com.generation.progettofinale.models.Entity;

import lombok.Data;

@Data
public abstract class GenericService<TipoID, E extends Entity, D extends IDao<TipoID, E>> {
    @Autowired
    private D dao;

    @Autowired
    private ApplicationContext context;

    //scrivo un findAll generico quindi invece di
    //usare i tipo specifici uso i tipi generici
    public List<E> findAll(){
        //restituisco tutti gli elementi presenti nel database
        //che verranno poi recuperati dallo specifico dao
        Map<TipoID, E> result=dao.read();
        List<E> list=new ArrayList<>();
        for(E e: result.values()){
            list.add((E) e);
        }
        return list;
    }

    public E findById(TipoID id){
        E e= dao.readById(id);
        return e;
    }

    public boolean update(Map<String, String> map){
        //devo trasformare la mappa in un oggetto di tipo E
        E e= createEntity(map);
        dao.update(e);
        return true;
    }

    public boolean delete(TipoID id){
        dao.delete(id);
        return true;
    }

    public abstract E createEntity(Map<String, String> map);
}
