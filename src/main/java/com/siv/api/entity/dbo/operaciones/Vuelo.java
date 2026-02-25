package com.siv.api.entity.dbo.operaciones;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.*;

import com.siv.api.entity.dbo.catalogos.Aerolinea;
import com.siv.api.entity.dbo.catalogos.Aeropuerto;
import com.siv.api.entity.dbo.catalogos.EstadoVuelo;

@Entity
@Table(name = "Vuelo", schema = "dbo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VueloId")
    private Long vueloId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AerolineaId", nullable = false)
    private Aerolinea aerolinea;

    @Column(name = "NumeroVuelo", nullable = false, length = 10)
    private String numeroVuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrigenAeropuertoId", nullable = false)
    private Aeropuerto origenAeropuerto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DestinoAeropuertoId", nullable = false)
    private Aeropuerto destinoAeropuerto;

    @Column(name = "FechaVuelo", nullable = false)
    private LocalDate fechaVuelo;

    @Column(name = "HoraProgramadaSalida")
    private LocalTime horaProgramadaSalida;

    @Column(name = "HoraProgramadaLlegada")
    private LocalTime horaProgramadaLlegada;

    @Column(name = "HoraEstimadaSalida")
    private LocalTime horaEstimadaSalida;

    @Column(name = "HoraEstimadaLlegada")
    private LocalTime horaEstimadaLlegada;

    @Column(name = "Puerta", length = 10)
    private String puerta;

    @Column(name = "Terminal", length = 10)
    private String terminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EstadoVueloId", nullable = false)
    private EstadoVuelo estadoVuelo;

    @Column(name = "Fuente", nullable = false, length = 30)
    private String fuente;

    @Column(name = "UltimaActualizacion", nullable = false)
    private LocalDateTime ultimaActualizacion;

    // Getters/Setters (puedes generarlos con Eclipse)
    public Long getVueloId() { return vueloId; }
    public void setVueloId(Long vueloId) { this.vueloId = vueloId; }

    public Aerolinea getAerolinea() { return aerolinea; }
    public void setAerolinea(Aerolinea aerolinea) { this.aerolinea = aerolinea; }

    public String getNumeroVuelo() { return numeroVuelo; }
    public void setNumeroVuelo(String numeroVuelo) { this.numeroVuelo = numeroVuelo; }

    public Aeropuerto getOrigenAeropuerto() { return origenAeropuerto; }
    public void setOrigenAeropuerto(Aeropuerto origenAeropuerto) { this.origenAeropuerto = origenAeropuerto; }

    public Aeropuerto getDestinoAeropuerto() { return destinoAeropuerto; }
    public void setDestinoAeropuerto(Aeropuerto destinoAeropuerto) { this.destinoAeropuerto = destinoAeropuerto; }

    public LocalDate getFechaVuelo() { return fechaVuelo; }
    public void setFechaVuelo(LocalDate fechaVuelo) { this.fechaVuelo = fechaVuelo; }

    public LocalTime getHoraProgramadaSalida() { return horaProgramadaSalida; }
    public void setHoraProgramadaSalida(LocalTime horaProgramadaSalida) { this.horaProgramadaSalida = horaProgramadaSalida; }

    public LocalTime getHoraProgramadaLlegada() { return horaProgramadaLlegada; }
    public void setHoraProgramadaLlegada(LocalTime horaProgramadaLlegada) { this.horaProgramadaLlegada = horaProgramadaLlegada; }

    public LocalTime getHoraEstimadaSalida() { return horaEstimadaSalida; }
    public void setHoraEstimadaSalida(LocalTime horaEstimadaSalida) { this.horaEstimadaSalida = horaEstimadaSalida; }

    public LocalTime getHoraEstimadaLlegada() { return horaEstimadaLlegada; }
    public void setHoraEstimadaLlegada(LocalTime horaEstimadaLlegada) { this.horaEstimadaLlegada = horaEstimadaLlegada; }

    public String getPuerta() { return puerta; }
    public void setPuerta(String puerta) { this.puerta = puerta; }

    public String getTerminal() { return terminal; }
    public void setTerminal(String terminal) { this.terminal = terminal; }

    public EstadoVuelo getEstadoVuelo() { return estadoVuelo; }
    public void setEstadoVuelo(EstadoVuelo estadoVuelo) { this.estadoVuelo = estadoVuelo; }

    public String getFuente() { return fuente; }
    public void setFuente(String fuente) { this.fuente = fuente; }

    public LocalDateTime getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion;}}