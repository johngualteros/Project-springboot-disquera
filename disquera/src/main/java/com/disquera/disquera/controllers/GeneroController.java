package com.disquera.disquera.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.disquera.disquera.model.Genero;
import com.disquera.disquera.model.IGenero;
import com.disquera.disquera.model.service.IGeneroService;

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
@SessionAttributes("genero")
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private IGeneroService generod;

    @GetMapping(path={"/index"})
    public String home(){
        return "redirect:/index";
    }


    @GetMapping(path={"/","","listarGenero"})
        public String listar(Model m){
        m.addAttribute("genero", generod.findAll());
        return "views/genero/getGenero";
    }

    @GetMapping(path={"formGenero","agregarGenero","AgregarGenero"})
    public String form(Model m){
        Genero genero=new Genero();
        m.addAttribute("genero", genero);
        m.addAttribute("accion","Agregar Genero");
        m.addAttribute("ac",false);
        return "views/genero/postGenero";
    }

    @GetMapping(path={"/edit/{idGenero}"})
    public String ver(@PathVariable Integer idGenero, Model m){
        Genero genero=null;
        if(idGenero>0){
            genero=generod.findOne(idGenero);
        }else{
            return"redirect:/genero/listarGenero";
        }
        m.addAttribute("genero", genero);
        m.addAttribute("accion","Editar Genero");
        m.addAttribute("ac",true);
        return "views/genero/postGenero";
    }

    @GetMapping("/delete/{idGenero}")
        public String delete(@PathVariable Integer idGenero) {
        if(idGenero > 0) {
        generod.delete(idGenero);
        }

        return "redirect:/genero/listarGenero";
    }
    
    
    @PostMapping("/add")
        public String add(@Valid Genero genero,BindingResult response, Model m,SessionStatus status){

            if(response.hasErrors()){
                return "views/genero/postGenero";
            }
            generod.save(genero);
            status.setComplete();
            return "redirect:/genero/listarGenero";
    }
}