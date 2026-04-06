package com.siv.api.controller.web;

import com.siv.api.application.interfaces.catalogos.IAerolineaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AerolineaPageController {

    private final IAerolineaService aerolineaService;

    public AerolineaPageController(IAerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @GetMapping("/web/aerolineas")
    public String listar(Model model) {
        model.addAttribute("aerolineas", aerolineaService.listarTodas());
        return "aerolineas/index";
    }
}
