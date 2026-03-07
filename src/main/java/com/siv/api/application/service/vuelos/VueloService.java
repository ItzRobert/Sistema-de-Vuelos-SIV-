package com.siv.api.application.service.vuelos;

import java.util.List;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.application.dto.vuelos.VueloDto;
import com.siv.api.application.interfaces.vuelos.IVueloService;
import com.siv.api.domain.model.vuelos.Vuelo;
import com.siv.api.domain.repository.AerolineaRepository;
import com.siv.api.domain.repository.AeropuertoRepository;
import com.siv.api.domain.repository.VueloRepository;

public class VueloService implements IVueloService {

    private final VueloRepository vueloRepository;
    private final AerolineaRepository aerolineaRepository;
    private final AeropuertoRepository aeropuertoRepository;

    public VueloService(
            VueloRepository vueloRepository,
            AerolineaRepository aerolineaRepository,
            AeropuertoRepository aeropuertoRepository
    ) {
        this.vueloRepository = vueloRepository;
        this.aerolineaRepository = aerolineaRepository;
        this.aeropuertoRepository = aeropuertoRepository;
    }

    @Override
    public List<VueloDto> listarTodos() {
        return vueloRepository.findAll()
                .stream()
                .map(this::convertirADto)
                .toList();
    }

    @Override
    public VueloDto crear(CrearVueloRequest request) {
        if (request.numero == null || request.numero.isBlank()) {
            throw new IllegalArgumentException("El número de vuelo es obligatorio");
        }

        if (request.origenAeropuertoId.equals(request.destinoAeropuertoId)) {
            throw new IllegalArgumentException("El aeropuerto origen y destino no pueden ser iguales");
        }

        aerolineaRepository.findById(request.aerolineaId.intValue())
                .orElseThrow(() -> new IllegalArgumentException("La aerolínea no existe"));

        aeropuertoRepository.findById(request.origenAeropuertoId.intValue())
                .orElseThrow(() -> new IllegalArgumentException("El aeropuerto origen no existe"));

        aeropuertoRepository.findById(request.destinoAeropuertoId.intValue())
                .orElseThrow(() -> new IllegalArgumentException("El aeropuerto destino no existe"));

        Vuelo vuelo = new Vuelo(
                null,
                request.numero,
                request.aerolineaId,
                request.origenAeropuertoId,
                request.destinoAeropuertoId,
                request.fecha,
                request.horaSalida,
                request.horaLlegada
        );

        Vuelo guardado = vueloRepository.save(vuelo);
        return convertirADto(guardado);
    }

    private VueloDto convertirADto(Vuelo vuelo) {
        VueloDto dto = new VueloDto();
        dto.setId(vuelo.getId());
        dto.setNumero(vuelo.getNumero());
        dto.setAerolineaId(vuelo.getAerolineaId());
        dto.setOrigenAeropuertoId(vuelo.getOrigenAeropuertoId());
        dto.setDestinoAeropuertoId(vuelo.getDestinoAeropuertoId());
        dto.setFecha(vuelo.getFecha());
        dto.setHoraSalida(vuelo.getHoraSalida());
        dto.setHoraLlegada(vuelo.getHoraLlegada());
        return dto;
    }
}
