package com.siv.api.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.siv.api.application.interfaces.catalogos.IAeropuertoService;

@Controller
public class AeropuertoPageController {

    private final IAeropuertoService aeropuertoService;

    public AeropuertoPageController(IAeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping("/web/aeropuertos")
    public String listar(Model model) {
        model.addAttribute("aeropuertos", aeropuertoService.listarTodos());
        return "aeropuertos/index";
    }
}