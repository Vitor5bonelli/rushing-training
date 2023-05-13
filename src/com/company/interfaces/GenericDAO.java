package com.company.interfaces;

import java.util.Map;

public interface GenericDAO<K, T>{
    public void insert(T object);
    public T findOne(K key);
    public Map<K, T> findAll();
    public void remove(K key);
    public void update(K key, T object);


}