package com.example.ApiRestSinPaginacion.repositories;

import org.springframework.stereotype.Repository;
import com.example.ApiRestSinPaginacion.entities.Autor;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long> {

}
