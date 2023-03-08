package com.generation.firstspring.repository;
import com.generation.firstspring.model.Estudiante;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    
    //esta es una query nativa sin parámetros que nos permite obtener
    //los estudiantes que tengan una 'll' en su nombre
    //es una consulta personalizada
    @Query(value = "SELECT * FROM estudiantes WHERE nombre like '%ll%'", nativeQuery=true)
    List <Estudiante> findEstudiantesWithLL();

    //Esta es también otra query antiva, con parámetros que nos permite
    //obtener los estudiantes pertenecientes a un equipo el cual
    //yo voy a especificar cuando llame a esta consulta
    //tambien es una consulta personalizada
    @Query(value = "SELECT * FROM estudiantes WHERE equipo_id = ?1", nativeQuery = true)
    List <Estudiante> findEstudianteByEquipo(Integer equipo);

    //como hacer una funcion de modificacion en querys nativas
    //ojo este ejemplo es de otro proyecto
    /*@Modifying
    @Query(value = "UPDATE PRODUCT p SET p.STOCK = p.stock+10 WHERE p.id = ?1", nativeQuery = true)
    void sumarStock(Long recetaID);*/


}
