package com.disquera.disquera.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.disquera.disquera.model.Album;
import com.disquera.disquera.model.IAlbum;
import com.disquera.disquera.model.service.IAlbumService;

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
@SessionAttributes("album")
@RequestMapping("/album")
public class AlbumController {
    
    @Autowired
    private IAlbumService albumed;
    
    @GetMapping(path={"/index"})
    public String home(){
        return "redirect:/index";
    }
    @GetMapping(path={"/","","/listarAlbum"})
        public String listar(Model m){
        m.addAttribute("album", albumed.findAll());
        return "views/album/getAlbum";
    }

    @GetMapping(path={"/formlistarAlbum","/agregarAlbum","/AgregarAlbum"})
    public String form(Model m){
        Album album=new Album();
        m.addAttribute("album", album);
        m.addAttribute("accion","Agregar Album");
        m.addAttribute("ac",false);
        return "views/album/postAlbum";
    }


    @GetMapping(path={"/edit/{idAlbum}"})
    public String ver(@PathVariable Integer idAlbum, Model m){//mas datos despues de la ,
        Album album=null;
        if(idAlbum>0){
            album=albumed.findOne(idAlbum);
        }else{
            return"redirect:/album/listarAlbum";
        }
        m.addAttribute("album", album);
        m.addAttribute("accion","Editar Album");
        m.addAttribute("ac",true);
        return "views/album/postAlbum";
    }
    @GetMapping("/delete/{idAlbum}")
    public String delete(@PathVariable Integer idAlbum) {
        if(idAlbum > 0) {
            albumed.delete(idAlbum);
        }

    return "redirect:/album/listarAlbum";
}
    @PostMapping("/add")
    public String add(@Valid Album album,BindingResult response, Model m,SessionStatus status){

        if(response.hasErrors()){
            return "views/album/postAlbum";
        }
        albumed.save(album);
        status.setComplete();
        return "redirect:/album/listarAlbum";
}
}
