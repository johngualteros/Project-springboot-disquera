package com.disquera.disquera.model.service;

import java.util.List;

import com.disquera.disquera.model.Artista;

public interface IArtistaService{
    public List <Artista> findAll();
    public void save (Artista artista);
    public Artista findOne(Integer idArtista);
    public void delete(Integer idArtista);
}

