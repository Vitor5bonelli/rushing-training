package com.company;

import java.util.List;
import java.util.Map;

public abstract class GenericDAO2<K, T extends Entidade<K>> {
    protected Map<K, T> bancoDeDados;

    /*
    public GenericDAO2(Map<K, T> bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

     */

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

    public abstract void update(K key, T object);

}




