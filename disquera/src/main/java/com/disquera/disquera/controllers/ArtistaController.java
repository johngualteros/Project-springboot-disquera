package com.disquera.disquera.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.disquera.disquera.model.Artista;
import com.disquera.disquera.model.IArtista;
import com.disquera.disquera.model.service.IArtistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@SessionAttributes("artista")
@RequestMapping("/artista")
public class ArtistaController {
    
    @Autowired
    private IArtistaService artistad;
    
    @GetMapping(path={"/index"})
    public String home(){
        return "redirect:/index";
    }
    @GetMapping(path={"/","","/listarArtista"})
        public String listar(Model m){
        m.addAttribute("artista", artistad.findAll());
        return "views/artista/getArtista";
    }

    @GetMapping(path={"/formlistarArtista","/agregarArtista","/AgregarArtista"})
    public String form(Model m){
        Artista artista=new Artista();
        m.addAttribute("artista", artista);
        m.addAttribute("accion","Agregar Artista");
        m.addAttribute("ac",false);
        return "views/artista/postArtista";
    }


    @GetMapping(path={"/edit/{idArtista}"})
    public String ver(@PathVariable Integer idArtista, Model m){//mas datos despues de la ,
        Artista artista=null;
        if(idArtista>0){
            artista=artistad.findOne(idArtista);
        }else{
            return"redirect:/artista/listarArtista";
        }
        m.addAttribute("artista", artista);
        m.addAttribute("accion","Editar Album");
        m.addAttribute("ac",true);
        return "views/artista/postArtista";
    }
    @GetMapping("/delete/{idArtista}")
    public String delete(@PathVariable Integer idArtista) {
        if(idArtista > 0) {
            artistad.delete(idArtista);
        }

    return "redirect:/artista/listarArtista";
}
    @PostMapping("/add")
    public String add(@Valid Artista artista,BindingResult response, Model m,SessionStatus status){

        if(response.hasErrors()){
            return "views/artista/postArtista";
        }
        artistad.save(artista);
        status.setComplete();
        return "redirect:/artista/listarArtista";
}
}
