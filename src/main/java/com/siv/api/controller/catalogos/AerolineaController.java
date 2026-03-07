package com.siv.api.controller.catalogos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.api.application.dto.catalogos.AerolineaDto;
import com.siv.api.application.interfaces.catalogos.IAerolineaService;

@RestController
public class AerolineaController {

    private final IAerolineaService aerolineaService;

    public AerolineaController(IAerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @GetMapping("/aerolineas")
    public List<AerolineaDto> listarTodas() {
        return aerolineaService.listarTodas();
    }
}