package com.generation.firstspring.service;
import com.generation.firstspring.model.Estudiante;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.generation.firstspring.repository.EstudianteRepository;

@Service
@Transactional
public class EstudianteService {

    //se conecta con el archivo repository para poder ocuparlo a nivel
    //de las instrucciones creadas en esta
    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository){
        this.estudianteRepository= estudianteRepository;
    }
    
    
    public void saveEstudiante(Estudiante estudiante){
        //este .save está haciendo el trabajo de insert into,
        //pero java ya lo reconoce por defecto, entonces lo hará de manera automática cuando
        //reconozca este método
        this.estudianteRepository.save(estudiante);
    }

    public void updateEstudiante(Estudiante estudiante){
        //a pesar de ser una función de actualización se ocupa
        //el mismo método de guardado
        //lo mismo que create
        this.estudianteRepository.save(estudiante);
    }

    public List<Estudiante> findAll(){
        return estudianteRepository.findAll();
    }

    public void deleteEstudiante(Integer id){
        estudianteRepository.deleteById(id);
    }

    //Estas funciones de arriba SIEMPRE se hacen


    public List<Estudiante> estudiantesConLL(){
        return estudianteRepository.findEstudiantesWithLL();
    }

    public List<Estudiante> estudiantePorEquipo(Integer equipo){
        return estudianteRepository.findEstudianteByEquipo(equipo);
    }

    //Estas funciones dependen de las query de los repositorios.
    
}
