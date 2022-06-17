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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//Si no valida puede ser que la libreria era de hibernate
@Entity
@Table(name="disquera")
public class Disquera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisquera;
    
    @Column(name="nitDisquera", length=50, nullable =false)
    @NotEmpty
    private String nitDisquera;

    @Column(name="nombreDisquera", length=50, nullable =false)
    @NotEmpty
    private String nombreDisquera;

    @Column(name="telefonoDisquera", length=50, nullable =false)
    @NotEmpty
    private String telefonoDisquera;

    @Column(name="direccionDisquera", length=50, nullable =false)
    @NotEmpty
    private String direccionDisquera;

    @Column(name="estadoDisquera" ,length=1)
    private Boolean estadoDisquera;

    @OneToMany(mappedBy = "disquera", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Artista> artista;
    
    public Disquera() {
        artista=new ArrayList<Artista>();
    }

    public Disquera(Integer idDisquera, @NotEmpty String nitDisquera, @NotEmpty String nombreDisquera,
            @NotEmpty String telefonoDisquera, @NotEmpty String direccionDisquera, Boolean estadoDisquera,
            List<Artista> artista) {
        this.idDisquera = idDisquera;
        this.nitDisquera = nitDisquera;
        this.nombreDisquera = nombreDisquera;
        this.telefonoDisquera = telefonoDisquera;
        this.direccionDisquera = direccionDisquera;
        this.estadoDisquera = estadoDisquera;
        this.artista = artista;
    }

    public Integer getIdDisquera() {
        return idDisquera;
    }

    public void setIdDisquera(Integer idDisquera) {
        this.idDisquera = idDisquera;
    }

    public String getNitDisquera() {
        return nitDisquera;
    }

    public void setNitDisquera(String nitDisquera) {
        this.nitDisquera = nitDisquera;
    }

    public String getNombreDisquera() {
        return nombreDisquera;
    }

    public void setNombreDisquera(String nombreDisquera) {
        this.nombreDisquera = nombreDisquera;
    }

    public String getTelefonoDisquera() {
        return telefonoDisquera;
    }

    public void setTelefonoDisquera(String telefonoDisquera) {
        this.telefonoDisquera = telefonoDisquera;
    }

    public String getDireccionDisquera() {
        return direccionDisquera;
    }

    public void setDireccionDisquera(String direccionDisquera) {
        this.direccionDisquera = direccionDisquera;
    }

    public Boolean getEstadoDisquera() {
        return estadoDisquera;
    }

    public void setEstadoDisquera(Boolean estadoDisquera) {
        this.estadoDisquera = estadoDisquera;
    }

    public List<Artista> getArtista() {
        return artista;
    }

    public void setArtista(List<Artista> artista) {
        this.artista = artista;
    }

    
}
