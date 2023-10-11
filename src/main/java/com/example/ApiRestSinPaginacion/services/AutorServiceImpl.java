package com.example.ApiRestSinPaginacion.services;

import com.example.ApiRestSinPaginacion.entities.Autor;
import com.example.ApiRestSinPaginacion.entities.Persona;
import com.example.ApiRestSinPaginacion.repositories.AutorRepository;
import com.example.ApiRestSinPaginacion.repositories.BaseRepository;
import com.example.ApiRestSinPaginacion.services.AutorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
}