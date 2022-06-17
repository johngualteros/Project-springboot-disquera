package com.disquera.disquera.model.service;

import java.util.List;

import com.disquera.disquera.model.Cancion;

public interface ICancionService {
    public List <Cancion> findAll();
    public void save (Cancion cancion);
    public Cancion findOne(Integer idCancion);
    public void delete(Integer idCancion);
}

