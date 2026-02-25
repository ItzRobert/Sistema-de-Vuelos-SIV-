package com.siv.api.controller.catalogos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.api.application.dto.catalogos.AerolineaDto;
import com.siv.api.application.service.catalogos.ListarAerolineasService;

@RestController
@RequestMapping("/aerolineas")
public class AerolineaController {

    private final ListarAerolineasService listarAerolineasService;

    public AerolineaController(ListarAerolineasService listarAerolineasService) {
        this.listarAerolineasService = listarAerolineasService;
    }

    @GetMapping
    public List<AerolineaDto> listar() {
        return listarAerolineasService.listarTodas();
    }
}