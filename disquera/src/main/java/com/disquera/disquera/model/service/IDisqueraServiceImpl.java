package com.disquera.disquera.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disquera.disquera.model.Disquera;
import com.disquera.disquera.model.IDisquera;

@Service
public class IDisqueraServiceImpl implements IDisqueraService {
    @Autowired
    private IDisquera disquerad;

    @Override
    public List<Disquera> findAll() {
        return (List<Disquera>) disquerad.findAll();
    }

    @Override
    public void save(Disquera genero) {
        disquerad.save(genero);
    }

    @Override
    public Disquera findOne(Integer idDisquera) {
        return disquerad.findById(idDisquera).orElse(null);
    }

    @Override
    public void delete(Integer idDisquera) {
        disquerad.deleteById(idDisquera);
    }
}