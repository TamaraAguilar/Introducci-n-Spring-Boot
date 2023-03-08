package com.generation.firstspring.service;
import com.generation.firstspring.model.Equipo;
import com.generation.firstspring.repository.EquipoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EquipoService {
    
    private EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository){
        this.equipoRepository= equipoRepository;
    }

    public void saveEquipo(Equipo equipo){
        //método post
        this.equipoRepository.save(equipo);
    }

    public void updateEquipo(Equipo equipo){
        //método update
        this.equipoRepository.save(equipo);
    }

    public List<Equipo> findAll(){
        //método get
        return equipoRepository.findAll();
    }

    public void deleteEquipo(Integer id){
        //método delete
        equipoRepository.deleteById(id);
    }



}
