package com.example.ApiRestSinPaginacion.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import com.example.ApiRestSinPaginacion.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E,ID> {

}
