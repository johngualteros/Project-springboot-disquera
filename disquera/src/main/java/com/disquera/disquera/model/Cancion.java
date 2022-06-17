package com.disquera.disquera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//Si no valida puede ser que la libreria era de hibernate
@Entity
@Table(name="cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCancion;
    
    @Column(name="nombreCancion", length=50, nullable =false)
    @NotEmpty
    private String nombreCancion;

    @Column(name="fechaGrabacion", length=50, nullable =false)
    @NotEmpty
    private String fechaGrabacion;

    @Column(name="duracionCancion", length=50, nullable =false)
    @NotEmpty
    private String duracionCancion;

    @Column(name="estadoCancion" ,length=1)
    private Boolean estadoCancion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    public Cancion(){}

    public Cancion(Integer idCancion, @NotEmpty String nombreCancion, @NotEmpty String fechaGrabacion,
            @NotEmpty String duracionCancion, Boolean estadoCancion, Album album) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.fechaGrabacion = fechaGrabacion;
        this.duracionCancion = duracionCancion;
        this.estadoCancion = estadoCancion;
        this.album = album;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getFechaGrabacion() {
        return fechaGrabacion;
    }

    public void setFechaGrabacion(String fechaGrabacion) {
        this.fechaGrabacion = fechaGrabacion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public Boolean getEstadoCancion() {
        return estadoCancion;
    }

    public void setEstadoCancion(Boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    
    
}
