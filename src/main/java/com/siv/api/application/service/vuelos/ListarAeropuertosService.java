package com.siv.api.application.service.vuelos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siv.api.domain.model.vuelos.Aeropuerto;
import com.siv.api.domain.repository.AeropuertoRepository;

@Service
public class ListarAeropuertosService {

    private final AeropuertoRepository repo;

    public ListarAeropuertosService(AeropuertoRepository repo) {
        this.repo = repo;
    }

    public List<Aeropuerto> ejecutar() {
        return repo.findAll();
    }
}
