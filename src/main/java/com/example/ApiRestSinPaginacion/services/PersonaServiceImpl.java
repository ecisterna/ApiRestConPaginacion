package com.example.ApiRestSinPaginacion.services;

import com.example.ApiRestSinPaginacion.entities.Persona;
import com.example.ApiRestSinPaginacion.repositories.BaseRepository;
import com.example.ApiRestSinPaginacion.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> searchPersona(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.searchPersona(filtro);
            return personas;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //paginacion:
    @Override
    public Page<Persona> searchPersonaPaged(String filtro, Pageable pageable) throws Exception {
        try {
            //metodo query
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //jpql
            Page<Persona> personas = personaRepository.searchPersonaPaged(filtro, pageable);
            return personas;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
