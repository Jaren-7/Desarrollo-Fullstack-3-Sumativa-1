package com.fullstack3.biblioteca.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LibroRequestDTO {

    @Data 
    @NoArgsConstructor 
    @AllArgsConstructor 
    @Builder 
    public static class Create {

        @NotBlank(message = "El título no puede estar vacío")
        private String titulo;
        @NotBlank(message = "El autor no puede estar vacío")
        private String autor;
        @NotNull(message = "La fecha de publicación no puede estar vacía")
        private Integer publicacion;
        @NotBlank(message = "El género no puede estar vacío")
        private String genero;
    }
}