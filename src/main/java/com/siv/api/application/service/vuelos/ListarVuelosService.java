package com.siv.api.application.service.vuelos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siv.api.domain.model.vuelos.Vuelo;
import com.siv.api.domain.repository.VueloRepository;

@Service
public class ListarVuelosService {

    private final VueloRepository repo;

    public ListarVuelosService(VueloRepository repo) {
        this.repo = repo;
    }

    public List<Vuelo> ejecutar() {
        return repo.findAll();
    }
}
