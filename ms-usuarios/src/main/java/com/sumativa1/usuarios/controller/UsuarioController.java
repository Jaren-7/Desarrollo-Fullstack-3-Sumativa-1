package com.sumativa1.usuarios.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sumativa1.usuarios.service.interfaces.IUsuarioService;
import com.sumativa1.usuarios.dto.response.UsuarioResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import com.sumativa1.usuarios.dto.request.UsuarioRequestDTO;
import org.springframework.http.HttpStatus;

@RestController 
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final IUsuarioService _service;

    public UsuarioController(IUsuarioService service) {
        _service = service;
    }

    @GetMapping("/consultar")
    public ResponseEntity<UsuarioResponseDTO> BuscarUsuario(@RequestParam String username) {
        UsuarioResponseDTO usuario = _service.buscarUsuario(username);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioResponseDTO> CrearUsuario(@Valid @RequestBody UsuarioRequestDTO.Create request) {
        
        UsuarioResponseDTO nuevoUsuario = _service.crearUsuario(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }
    
    

}
