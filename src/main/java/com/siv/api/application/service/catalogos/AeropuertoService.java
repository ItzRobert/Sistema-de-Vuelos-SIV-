package com.siv.api.application.service.catalogos;

import java.util.List;

import com.siv.api.application.dto.catalogos.AeropuertoDto;
import com.siv.api.application.interfaces.catalogos.IAeropuertoService;
import com.siv.api.domain.model.vuelos.Aeropuerto;
import com.siv.api.domain.repository.AeropuertoRepository;
import org.springframework.stereotype.Service;
@Service
public class AeropuertoService implements IAeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    @Override
    public List<AeropuertoDto> listarTodos() {
        return aeropuertoRepository.findAll()
                .stream()
                .map(this::convertirDto)
                .toList();
    }

    @Override
    public AeropuertoDto obtenerPorId(Long id) {
        var aeropuerto = aeropuertoRepository.findById(id.intValue())
                .orElseThrow(() -> new IllegalArgumentException("Aeropuerto no encontrado"));

        return convertirDto(aeropuerto);
    }

    private AeropuertoDto convertirDto(Aeropuerto aeropuerto) {
        AeropuertoDto dto = new AeropuertoDto();
        dto.setId(aeropuerto.getId());
        dto.setCodigoIata(aeropuerto.getCodigoIATA());
        dto.setNombre(aeropuerto.getNombre());
        dto.setCiudad(aeropuerto.getCiudad());
        dto.setPais(aeropuerto.getPais());
        dto.setActivo(aeropuerto.isActivo());
        return dto;
    }
}