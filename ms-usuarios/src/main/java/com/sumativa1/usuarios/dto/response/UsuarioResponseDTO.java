package com.sumativa1.usuarios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class UsuarioResponseDTO {
    private int idusuario;
    private String username;
    private String email;
    private String nombre;
    private String rol;
    private Integer activo;
    private String fecha_creacion;
}
