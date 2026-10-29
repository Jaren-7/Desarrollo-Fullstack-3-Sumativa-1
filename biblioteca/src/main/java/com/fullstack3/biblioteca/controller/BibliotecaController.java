package com.fullstack3.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.fullstack3.biblioteca.dto.LibroResponseDTO;

@RestController
@RequestMapping ("/biblioteca")
public class BibliotecaController {

    private final ILibroService _service;

    public BibliotecaController(ILibroService service) {
        _service = service;
    }

    @GetMapping 
    public ResponseEntity<List<LibroResponseDTO>> Libros() {
        List<LibroResponseDTO> libros = _service.obtenerLibros();
        return ResponseEntity.ok(libros);
    }
    
}
