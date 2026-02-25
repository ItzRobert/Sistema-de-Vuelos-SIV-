package com.siv.api.application.service.catalogos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.siv.api.application.dto.catalogos.AerolineaDto;
import com.siv.api.entity.dbo.catalogos.Aerolinea;
import com.siv.api.repository.catalogos.AerolineaRepository;

@Service
public class ListarAerolineasService {

    private final AerolineaRepository aerolineaRepository;

    public ListarAerolineasService(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    public List<AerolineaDto> listarTodas() {
        List<Aerolinea> aerolineas = aerolineaRepository.findAll();
        return aerolineas.stream()
                .map(this::convertirADto)
                .collect(Collectors.toList()); 
    }

    private AerolineaDto convertirADto(Aerolinea aerolinea) {
        AerolineaDto dto = new AerolineaDto();
        dto.setId(aerolinea.getAerolineaId());
        dto.setCodigoIata(aerolinea.getCodigoIATA());
        dto.setNombre(aerolinea.getNombre());
        dto.setActiva(aerolinea.getActiva());
        return dto;
    }
}