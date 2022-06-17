package com.disquera.disquera.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.disquera.disquera.model.Disquera;
import com.disquera.disquera.model.IDisquera;
import com.disquera.disquera.model.service.IDisqueraService;

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
@SessionAttributes("disquera")
@RequestMapping("/disquera")
public class DisqueraController {

    @Autowired
    private IDisqueraService disquerad;

    @GetMapping(path={"/index"})
    public String home(){
        return "redirect:/index";
    }


    @GetMapping(path={"/","","listarDisquera"})
        public String listar(Model m){
        m.addAttribute("disquera", disquerad.findAll());
        return "views/disquera/getDisquera";
    }

    @GetMapping(path={"formDisquera","agregarDisquera","AgregarDisquera"})
    public String form(Model m){
        Disquera disquera=new Disquera();
        m.addAttribute("disquera", disquera);
        m.addAttribute("accion","Agregar Disquera");
        m.addAttribute("ac",false);
        return "views/disquera/postDisquera";
    }

    @GetMapping(path={"/edit/{idDisquera}"})
    public String ver(@PathVariable Integer idDisquera, Model m){
        Disquera disquera=null;
        if(idDisquera>0){
            disquera=disquerad.findOne(idDisquera);
        }else{
            return"redirect:/disquera/listarDisquera";
        }
        m.addAttribute("disquera", disquera);
        m.addAttribute("accion","Editar Disquera");
        m.addAttribute("ac",true);
        return "views/disquera/postDisquera";
    }

    @GetMapping("/delete/{idDisquera}")
        public String delete(@PathVariable Integer idDisquera) {
        if(idDisquera > 0) {
        disquerad.delete(idDisquera);
        }

        return "redirect:/disquera/listarDisquera";
    }
    
    
    @PostMapping("/add")
        public String add(@Valid Disquera disquera,BindingResult response, Model m,SessionStatus status){
            if(response.hasErrors()){
                return "views/disquera/postDisquera";
            }
            disquerad.save(disquera);
            status.setComplete();
            return "redirect:/disquera/listarDisquera";
    }
}