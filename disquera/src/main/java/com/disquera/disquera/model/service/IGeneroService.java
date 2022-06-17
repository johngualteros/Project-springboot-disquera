package com.disquera.disquera.model.service;

import java.util.List;

import com.disquera.disquera.model.Genero;

public interface IGeneroService{
    public List <Genero> findAll();
    public void save (Genero genero);
    public Genero findOne(Integer idGenero);
    public void delete(Integer idGenero);
}

