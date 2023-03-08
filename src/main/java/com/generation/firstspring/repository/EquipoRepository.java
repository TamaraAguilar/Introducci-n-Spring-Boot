package com.generation.firstspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.firstspring.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    
}
