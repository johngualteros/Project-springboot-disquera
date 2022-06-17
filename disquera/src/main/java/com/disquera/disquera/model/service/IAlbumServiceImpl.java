package com.disquera.disquera.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disquera.disquera.model.Album;
import com.disquera.disquera.model.IAlbum;

@Service
public class IAlbumServiceImpl implements IAlbumService {
    @Autowired
    private IAlbum albumed;

    @Override
    public List<Album> findAll() {
        return (List<Album>) albumed.findAll();
    }

    @Override
    public void save(Album album) {
        albumed.save(album);
    }

    @Override
    public Album findOne(Integer idAlbum) {
        return albumed.findById(idAlbum).orElse(null);
    }

    @Override
    public void delete(Integer idAlbum) {
        albumed.deleteById(idAlbum);
    }
}