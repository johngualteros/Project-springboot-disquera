package com.disquera.disquera.controllers;

import javax.validation.Valid;

import com.disquera.disquera.model.Cancion;
import com.disquera.disquera.model.service.ICancionService;

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
@SessionAttributes("cancion")
@RequestMapping("/cancion")
public class CancionController {

    @Autowired
    private ICancionService cancioned;

    @GetMapping(path={"/index"})
    public String home(){
        return "redirect:/index";
    }


    @GetMapping(path={"/","","listarCancion"})
        public String listar(Model m){
        m.addAttribute("cancion", cancioned.findAll());
        return "views/cancion/getCancion";
    }

    @GetMapping(path={"formCancion","agregarCancion","AgregarCancion"})
    public String form(Model m){
        Cancion cancion=new Cancion();
        m.addAttribute("cancion", cancion);
        m.addAttribute("accion","Agregar Cancion");
        m.addAttribute("ac",false);
        return "views/cancion/postCancion";
    }

    @GetMapping(path={"/edit/{idCancion}"})
    public String ver(@PathVariable Integer idCancion, Model m){
        Cancion cancion=null;
        if(idCancion>0){
            cancion=cancioned.findOne(idCancion);
        }else{
            return"redirect:/cancion/listarCancion";
        }
        m.addAttribute("cancion", cancion);
        m.addAttribute("accion","Editar Cancion");
        m.addAttribute("ac",true);
        return "views/cancion/postCancion";
    }

    @GetMapping("/delete/{idCancion}")
        public String delete(@PathVariable Integer idCancion) {
        if(idCancion > 0) {
        cancioned.delete(idCancion);
        }

        return "redirect:/cancion/listarCancion";
    }
    
    
    @PostMapping("/add")
        public String add(@Valid Cancion cancion,BindingResult response, Model m,SessionStatus status){

            if(response.hasErrors()){
                return "views/cancion/postCancion";
            }
            cancioned.save(cancion);
            status.setComplete();
            return "redirect:/cancion/listarCancion";
    }
}