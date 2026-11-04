package com.sumativa1.usuarios.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UsuarioRequestDTO {
    
    @Data 
    @NoArgsConstructor 
    @AllArgsConstructor 
    @Builder 
    public static class Create {
        @NotBlank(message = "El usuario es obligatorio")
        private String username;
        @NotBlank(message = "La contraseña es obligatoria")
        private String password;
        @NotBlank (message = "El nombre es obligatorio")
        private String nombre;
        @NotBlank (message = "El email es obligatorio")
        private String email;
        @NotBlank (message = "El rol es obligatorio")
        private String rol;
        @NotNull (message = "El estado activo es obligatorio")
        private Integer activo;
    }
}
