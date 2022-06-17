package com.disquera.disquera.model.service;

import java.util.List;

import com.disquera.disquera.model.Disquera;

public interface IDisqueraService{
    public List <Disquera> findAll();
    public void save (Disquera disquera);
    public Disquera findOne(Integer idDisquera);
    public void delete(Integer idDisquera);
}

