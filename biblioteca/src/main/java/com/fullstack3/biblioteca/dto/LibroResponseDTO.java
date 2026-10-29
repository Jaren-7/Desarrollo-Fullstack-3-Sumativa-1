package com.fullstack3.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class LibroResponseDTO {
    private int idlibro;
    private String titulo;
    private String autor;
    private int publicacion;
    private String genero;
}
