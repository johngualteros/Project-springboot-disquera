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
@Table(name="artista")
public class Artista{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtista;
    
    @Column(name="numeroDocumento", length=50, nullable =false)
    @NotEmpty
    private String numeroDocumento;
    @Column(name="tipoDocumento", length=50, nullable =false)
    @NotEmpty
    private String tipoDocumento;
    @Column(name="nombreArtista", length=50, nullable =false)
    @NotEmpty
    private String nombreArtista;
    @Column(name="apellidoArtista", length=50, nullable =false)
    @NotEmpty
    private String apellidoArtista;
    @Column(name="nombreArtistico", length=50, nullable =false)
    @NotEmpty
    private String nombreArtistico;
    @Column(name="fechaNacimiento", length=50, nullable =false)
    @NotEmpty
    private String fechaNacimiento;
    @Column(name="email", length=50, nullable =false)
    @NotEmpty
    private String email;
    @Column(name="estadoArtista" ,length=1)
    private Boolean estadoArtista;
    @ManyToOne(fetch = FetchType.LAZY)
    private Disquera disquera;
    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Album> album;

    public Artista(){
        album=new ArrayList<Album>();
    }

    public Artista(Integer idArtista, @NotEmpty String numeroDocumento, @NotEmpty String tipoDocumento,
            @NotEmpty String nombreArtista, @NotEmpty String apellidoArtista, @NotEmpty String nombreArtistico,
            @NotEmpty String fechaNacimiento, @NotEmpty String email, Boolean estadoArtista, Disquera disquera,
            List<Album> album) {
        this.idArtista = idArtista;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombreArtista = nombreArtista;
        this.apellidoArtista = apellidoArtista;
        this.nombreArtistico = nombreArtistico;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.estadoArtista = estadoArtista;
        this.disquera = disquera;
        this.album = album;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getApellidoArtista() {
        return apellidoArtista;
    }

    public void setApellidoArtista(String apellidoArtista) {
        this.apellidoArtista = apellidoArtista;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstadoArtista() {
        return estadoArtista;
    }

    public void setEstadoArtista(Boolean estadoArtista) {
        this.estadoArtista = estadoArtista;
    }

    public Disquera getDisquera() {
        return disquera;
    }

    public void setDisquera(Disquera disquera) {
        this.disquera = disquera;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    
}
