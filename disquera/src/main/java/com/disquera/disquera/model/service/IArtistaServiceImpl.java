package com.disquera.disquera.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disquera.disquera.model.Artista;
import com.disquera.disquera.model.IArtista;

@Service
public class IArtistaServiceImpl implements IArtistaService {
    @Autowired
    private IArtista artistad;

    @Override
    public List<Artista> findAll() {
        return (List<Artista>) artistad.findAll();
    }

    @Override
    public void save(Artista artista) {
        artistad.save(artista);
    }

    @Override
    public Artista findOne(Integer idArtista) {
        return artistad.findById(idArtista).orElse(null);
    }

    @Override
    public void delete(Integer idArtista) {
        artistad.deleteById(idArtista);
    }
}