package com.disquera.disquera.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//Si no valida puede ser que la libreria era de hibernate
@Entity
@Table(name="album")
public class Album{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;
    
    @Column(name="nombreAlbum", length=50, nullable =false)
    @NotEmpty
    private String nombreAlbum;
    @Column(name="Publicacion", length=50, nullable =false)
    @NotEmpty
    private String Publicacion;
    @Column(name="estadoAlbum" ,length=1)
    private Boolean estadoAlbum;
    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;
    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;
    
    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cancion> cancion;

    public Album(){
        cancion=new ArrayList<Cancion>();
    }

    public Album(Integer idAlbum, @NotEmpty String nombreAlbum, @NotEmpty String publicacion, Boolean estadoAlbum,
            Genero genero, Artista artista, List<Cancion> cancion) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        Publicacion = publicacion;
        this.estadoAlbum = estadoAlbum;
        this.genero = genero;
        this.artista = artista;
        this.cancion = cancion;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(String publicacion) {
        Publicacion = publicacion;
    }

    public Boolean getEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(Boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }

    
        
}
