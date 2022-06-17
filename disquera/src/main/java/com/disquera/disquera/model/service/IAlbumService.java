package com.disquera.disquera.model.service;

import java.util.List;

import com.disquera.disquera.model.Album;

public interface IAlbumService{
    public List <Album> findAll();
    public void save (Album album);
    public Album findOne(Integer idAlbum);
    public void delete(Integer idAlbum);
}

