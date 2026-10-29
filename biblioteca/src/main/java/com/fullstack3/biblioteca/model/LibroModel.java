package com.fullstack3.biblioteca.model;

import lombok.Data;

@Data 
public class LibroModel {
    
    private int idlibro;
    private String titulo;
    private String autor;
    private int publicacion;
    private String genero;

}
