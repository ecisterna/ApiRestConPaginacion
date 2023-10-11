package com.example.ApiRestSinPaginacion.services;

import com.example.ApiRestSinPaginacion.entities.Localidad;
import com.example.ApiRestSinPaginacion.repositories.BaseRepository;
import com.example.ApiRestSinPaginacion.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService{
    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
