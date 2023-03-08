package com.generation.firstspring.controller;
import com.generation.firstspring.model.Estudiante;
import com.generation.firstspring.service.EstudianteService;
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

//se debe especificar que es una clase de tipo controlador
@Controller
//se debe especificar el origen de las peticiones, en este caso pueden
//venir de cualquier lado
@CrossOrigin("*")
@RestController

public class EstudianteController {

    private EstudianteService estudianteService;

    public EstudianteController(@Autowired EstudianteService estudianteService){
      this.estudianteService= estudianteService;
    }

    //post, get, delete, put
    //todo ronda en torno a estas cuatro solicitudes

    //post -> ingresar datos a la base
    @PostMapping("estudiante/Save")
    public void guardarEstudiante(@RequestBody Estudiante estudiante){
        //llamar a nuestro servicio
        estudianteService.saveEstudiante(estudiante);
    }

    //put -> editar datos en la base
     @PutMapping("/estudiante/Update")
     public void editarEstudiante(@RequestBody Estudiante estudiante){
        estudianteService.updateEstudiante(estudiante);
     }

     //delete -> eliminar datos en la base
     @DeleteMapping("/estudiante/Delete/{id}")
     public void eliminarEstudiante(@PathVariable Integer id){
        estudianteService.deleteEstudiante(id);
     }

     //get -> obtener datos desde la base de datos
     @GetMapping("/estudiante/FindAll")
     public List<Estudiante> obtenerEstudiante(){
        return estudianteService.findAll();
     }

     @GetMapping("/estudiante/ConLL")
     public List<Estudiante> estudiantesConLL(){
        return estudianteService.estudiantesConLL();
     }

     @GetMapping("/estudiante/PorEquipo/{equipo}")
     public List<Estudiante> estudiantesPorEquipo(@PathVariable Integer equipo){
        return estudianteService.estudiantePorEquipo(equipo);
     }
     
}
