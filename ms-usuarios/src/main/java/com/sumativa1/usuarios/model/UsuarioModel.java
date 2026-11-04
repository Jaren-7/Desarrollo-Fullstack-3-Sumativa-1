package com.sumativa1.usuarios.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    private int idusuario;
    private String username;
    private String password_hash;
    private String nombre;
    private String email;
    private String rol;
    private Integer activo;
    private LocalDateTime fecha_creacion;
}
