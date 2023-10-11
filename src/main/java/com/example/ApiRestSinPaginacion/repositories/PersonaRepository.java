package com.example.ApiRestSinPaginacion.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.ApiRestSinPaginacion.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {

    //Anotacion Método de Query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ") //el ? indica q es tipo de parametro indexado y el 1 es la cantidad de parametros
    List <Persona> searchPersona(@Param("filtro")String filtro);

    //anotacion de JPQL usando parametros nombrados:
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    List <Persona> searchPersona1(@Param("filtro") String filtro);

    //anotacion con queries nativas
    @Query(
            value = "SELECT * FROM Persona WHERE Persona.nombre LIKE %:filtro% OR Persona.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List <Persona> search3(@Param("filtro") String filtro);

    //CON PAGINACION:
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ") //en %1?% el ? indica q es tipo de parametro indexado y el 1 es la cantidad de parametros
    Page<Persona> searchPersonaPaged(@Param("filtro")String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Persona WHERE Persona.nombre LIKE %:filtro% OR Persona.apellido LIKE %:filtro% ",
            countQuery =  "SELECT count(*) FROM Persona",  //esto se agrega pq en las nativas no es automatica la paginacion
            nativeQuery = true
    )
    Page<Persona> searchPersonaPaged3(@Param("filtro") String filtro, Pageable pageable);

}
