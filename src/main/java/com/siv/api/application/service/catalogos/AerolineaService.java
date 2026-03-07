package com.siv.api.application.service.catalogos;

import java.util.List;

import com.siv.api.application.dto.catalogos.AerolineaDto;
import com.siv.api.application.interfaces.catalogos.IAerolineaService;
import com.siv.api.domain.model.catalogos.Aerolinea;
import com.siv.api.domain.repository.AerolineaRepository;

public class AerolineaService implements IAerolineaService {

    private final AerolineaRepository aerolineaRepository;

    public AerolineaService(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    @Override
    public List<AerolineaDto> listarTodas() {
        return aerolineaRepository.findAll()
                .stream()
                .map(this::convertirADto)
                .toList();
    }

    private AerolineaDto convertirADto(Aerolinea aerolinea) {
        AerolineaDto dto = new AerolineaDto();
        dto.setId(aerolinea.getId());
        dto.setCodigoIata(aerolinea.getCodigoIata());
        dto.setNombre(aerolinea.getNombre());
        dto.setActiva(aerolinea.isActiva());
        return dto;
    }
}