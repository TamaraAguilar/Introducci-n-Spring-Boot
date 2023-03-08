package com.generation.firstspring.controller;
import com.generation.firstspring.model.Equipo;
import com.generation.firstspring.service.EquipoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin("*")
@RestController

public class EquipoController {
    
    private EquipoService equipoService;

    public EquipoController(@Autowired EquipoService equipoService){
        this.equipoService= equipoService;
      }

    //post -> ingresar datos a la base
    @PostMapping("equipo/Save")
    public void guardarEquipo(@RequestBody Equipo equipo){
        //llamar a nuestro servicio
        equipoService.saveEquipo(equipo);
    }

    //put -> editar datos en la base
    @PutMapping("/equipo/Update")
    public void editarEquipo(@RequestBody Equipo equipo){
       equipoService.updateEquipo(equipo);
    }

    //delete -> eliminar datos en la base
    @DeleteMapping("/equipo/Delete/{id}")
    public void eliminarEquipo(@PathVariable Integer id){
       equipoService.deleteEquipo(id);
    }

    //get -> obtener datos desde la base de datos
    @GetMapping("/equipo/FindAll")
    public List<Equipo> obtenerEquipo(){
       return equipoService.findAll();
    }
    

}
