package com.disquera.disquera.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disquera.disquera.model.Genero;
import com.disquera.disquera.model.IGenero;

@Service
public class IGeneroServiceImpl implements IGeneroService {
    @Autowired
    private IGenero generod;

    @Override
    public List<Genero> findAll() {
        return (List<Genero>) generod.findAll();
    }

    @Override
    public void save(Genero genero) {
        generod.save(genero);
    }

    @Override
    public Genero findOne(Integer idGenero) {
        return generod.findById(idGenero).orElse(null);
    }

    @Override
    public void delete(Integer idGenero) {
        generod.deleteById(idGenero);
    }
}