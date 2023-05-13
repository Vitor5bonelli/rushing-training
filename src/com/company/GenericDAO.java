package com.company;

import com.company.interfaces.Entidade;

import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<K, T extends Entidade<K>> {
    protected Map<K, T> bancoDeDados = new HashMap<>();

    public void insert(T object) {
        bancoDeDados.put(object.getId(), object);
    }

    public void remove(K key) {
        bancoDeDados.remove(key);
    }

    public T findOne(K key) {
        return bancoDeDados.get(key);
    }

    public Map<K, T> findAll() {
        return bancoDeDados;
    }

    public void update(K key, T object){
        bancoDeDados.replace(key, object);
    };

}




