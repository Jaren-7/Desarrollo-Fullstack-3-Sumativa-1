package com.fullstack3.biblioteca.service.interfaces;

import com.fullstack3.biblioteca.dto.response.LibroResponseDTO;
import com.fullstack3.biblioteca.dto.request.LibroRequestDTO;
import java.util.List;

public interface ILibroService {
    
    List<LibroResponseDTO> obtenerLibros();

    LibroResponseDTO obtenerLibroPorId(int id);

    LibroResponseDTO crearLibro(LibroRequestDTO.Create request);

}
