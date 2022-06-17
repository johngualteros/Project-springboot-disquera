package com.disquera.disquera.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disquera.disquera.model.Cancion;
import com.disquera.disquera.model.ICancion;

@Service
public class ICancionServiceImpl implements ICancionService {
    @Autowired
    private ICancion cancioned;

    @Override
    public List<Cancion> findAll() {
        return (List<Cancion>) cancioned.findAll();
    }

    @Override
    public void save(Cancion cancion) {
        cancioned.save(cancion);
    }

    @Override
    public Cancion findOne(Integer idCancion) {
        return cancioned.findById(idCancion).orElse(null);
    }

    @Override
    public void delete(Integer idCancion) {
        cancioned.deleteById(idCancion);
    }
}