package com.siv.api.controller.catalogos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.api.application.dto.catalogos.AerolineaDto;
import com.siv.api.application.interfaces.catalogos.IAerolineaService;

@RestController
@RequestMapping("/aerolineas")
public class AerolineaController {

    private final IAerolineaService aerolineaService;

    public AerolineaController(IAerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @GetMapping
    public List<AerolineaDto> listarTodas() {
        return aerolineaService.listarTodas();
    }

    @GetMapping("/{id}")
    public AerolineaDto obtenerPorId(@PathVariable Long id) {
        return aerolineaService.obtenerPorId(id);
    }
}