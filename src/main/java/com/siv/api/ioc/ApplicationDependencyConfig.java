package com.siv.api.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siv.api.application.interfaces.catalogos.IAerolineaService;
import com.siv.api.application.interfaces.vuelos.IVueloService;
import com.siv.api.application.service.catalogos.AerolineaService;
import com.siv.api.application.service.vuelos.VueloService;
import com.siv.api.domain.repository.AerolineaRepository;
import com.siv.api.domain.repository.AeropuertoRepository;
import com.siv.api.domain.repository.VueloRepository;

@Configuration
public class ApplicationDependencyConfig {

    @Bean
    IAerolineaService aerolineaService(AerolineaRepository aerolineaRepository) {
        return new AerolineaService(aerolineaRepository);
    }

    @Bean
    IVueloService vueloService(
            VueloRepository vueloRepository,
            AerolineaRepository aerolineaRepository,
            AeropuertoRepository aeropuertoRepository
    ) {
        return new VueloService(vueloRepository, aerolineaRepository, aeropuertoRepository);
    }
}