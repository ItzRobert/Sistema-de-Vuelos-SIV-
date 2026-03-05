package com.siv.api.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsuarioOperativo", schema = "dbo")
public class UsuarioOperativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioOperativoId")
    private Integer usuarioOperativoId;

    @Column(name = "Usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "NombreCompleto", nullable = false, length = 120)
    private String nombreCompleto;

    @Column(name = "Rol", nullable = false, length = 30)
    private String rol;

    @Column(name = "Activo", nullable = false)
    private Boolean activo;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

  
    public Integer getUsuarioOperativoId() { return usuarioOperativoId; }
    public void setUsuarioOperativoId(Integer usuarioOperativoId) { this.usuarioOperativoId = usuarioOperativoId; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		
	}
}