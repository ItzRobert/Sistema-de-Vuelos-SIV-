package com.siv.api.application.service.vuelos;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.application.dto.vuelos.VueloDto;
import com.siv.api.application.interfaces.vuelos.IVueloService;
import com.siv.api.domain.model.vuelos.Vuelo;
import com.siv.api.domain.repository.AerolineaRepository;
import com.siv.api.domain.repository.AeropuertoRepository;
import com.siv.api.domain.repository.VueloRepository;

@Service
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
    public VueloDto obtenerPorId(Long id) {
        Vuelo vuelo = vueloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));

        return convertirADto(vuelo);
    }

    @Override
    public VueloDto crear(CrearVueloRequest request) {

        if (request.getNumeroVuelo() == null || request.getNumeroVuelo().isBlank()) {
            throw new IllegalArgumentException("El número de vuelo es obligatorio");
        }

        if (request.getOrigenAeropuertoId().equals(request.getDestinoAeropuertoId())) {
            throw new IllegalArgumentException("El aeropuerto origen y destino no pueden ser iguales");
        }

        aerolineaRepository.findById(request.getAerolineaId().intValue())
                .orElseThrow(() -> new IllegalArgumentException("La aerolínea no existe"));

        aeropuertoRepository.findById(request.getOrigenAeropuertoId().intValue())
                .orElseThrow(() -> new IllegalArgumentException("El aeropuerto origen no existe"));

        aeropuertoRepository.findById(request.getDestinoAeropuertoId().intValue())
                .orElseThrow(() -> new IllegalArgumentException("El aeropuerto destino no existe"));

        Vuelo vuelo = new Vuelo(
                null,
                request.getNumeroVuelo(),
                request.getAerolineaId().longValue(),
                request.getOrigenAeropuertoId().longValue(),
                request.getDestinoAeropuertoId().longValue(),
                request.getEstadoVueloId().longValue(),
                request.getFuente(),
                LocalDate.parse(request.getFechaVuelo()),
                LocalTime.parse(request.getHoraProgramadaSalida()),
                LocalTime.parse(request.getHoraProgramadaLlegada())
        );

        try {
            Vuelo guardado = vueloRepository.save(vuelo);
            return convertirADto(guardado);

        } catch (Exception e) {
            String mensaje = e.getMessage();
            Throwable causa = e.getCause();

            if ((mensaje != null && mensaje.contains("UQ_Vuelo")) ||
                (causa != null && causa.getMessage() != null && causa.getMessage().contains("UQ_Vuelo"))) {
                throw new IllegalArgumentException(
                        "Ya existe un vuelo con esa aerolínea, número, fecha, origen y destino.");
            }

            throw e;
        }
    }

    @Override
    public VueloDto actualizar(Long id, CrearVueloRequest request) {

        if (request.getNumeroVuelo() == null || request.getNumeroVuelo().isBlank()) {
            throw new IllegalArgumentException("El número de vuelo es obligatorio");
        }

        if (request.getOrigenAeropuertoId().equals(request.getDestinoAeropuertoId())) {
            throw new IllegalArgumentException("El aeropuerto origen y destino no pueden ser iguales");
        }

        vueloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));

        aerolineaRepository.findById(request.getAerolineaId().intValue())
                .orElseThrow(() -> new IllegalArgumentException("La aerolínea no existe"));

        aeropuertoRepository.findById(request.getOrigenAeropuertoId().intValue())
                .orElseThrow(() -> new IllegalArgumentException("El aeropuerto origen no existe"));

        aeropuertoRepository.findById(request.getDestinoAeropuertoId().intValue())
                .orElseThrow(() -> new IllegalArgumentException("El aeropuerto destino no existe"));

        Vuelo vueloActualizado = new Vuelo(
                id,
                request.getNumeroVuelo(),
                request.getAerolineaId().longValue(),
                request.getOrigenAeropuertoId().longValue(),
                request.getDestinoAeropuertoId().longValue(),
                request.getEstadoVueloId().longValue(),
                request.getFuente(),
                LocalDate.parse(request.getFechaVuelo()),
                LocalTime.parse(request.getHoraProgramadaSalida()),
                LocalTime.parse(request.getHoraProgramadaLlegada())
        );

        try {
            Vuelo actualizado = vueloRepository.save(vueloActualizado);
            return convertirADto(actualizado);

        } catch (Exception e) {
            String mensaje = e.getMessage();
            Throwable causa = e.getCause();

            if ((mensaje != null && mensaje.contains("UQ_Vuelo")) ||
                (causa != null && causa.getMessage() != null && causa.getMessage().contains("UQ_Vuelo"))) {
                throw new IllegalArgumentException(
                        "Ya existe un vuelo con esa aerolínea, número, fecha, origen y destino.");
            }

            throw e;
        }
    }

    @Override
    public void eliminar(Long id) {
        vueloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));

        vueloRepository.deleteById(id);
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