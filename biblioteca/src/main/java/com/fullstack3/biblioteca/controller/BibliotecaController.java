package com.fullstack3.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fullstack3.biblioteca.service.interfaces.ILibroService;

import jakarta.validation.Valid;

import com.fullstack3.biblioteca.dto.response.LibroResponseDTO;
import com.fullstack3.biblioteca.dto.request.LibroRequestDTO;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


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

    @GetMapping("/libro")
    public ResponseEntity<LibroResponseDTO> BuscarLibroPorId(@RequestParam int id) {
        LibroResponseDTO libro = _service.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }

    @PostMapping("/libro/crear")
    public ResponseEntity<LibroResponseDTO> CrearLibro(@Valid @RequestBody LibroRequestDTO.Create request) {
        LibroResponseDTO nuevoLibro = _service.crearLibro(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }
    
    
}
