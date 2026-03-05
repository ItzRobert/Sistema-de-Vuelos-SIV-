package com.siv.api.application.service.vuelos;

import org.springframework.stereotype.Service;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.domain.model.vuelos.Vuelo;
import com.siv.api.domain.repository.VueloRepository;

@Service
public class CrearVueloService {

    private final VueloRepository repo;

    public CrearVueloService(VueloRepository repo) {
        this.repo = repo;
    }

    public Vuelo ejecutar(CrearVueloRequest r) {
        // id null porque lo genera DB
        var vuelo = new Vuelo(
                null,
                r.numero,
                r.aerolineaId,
                r.origenAeropuertoId,
                r.destinoAeropuertoId,
                r.fecha,
                r.horaSalida,
                r.horaLlegada
        );
        return repo.save(vuelo);
    }
}
