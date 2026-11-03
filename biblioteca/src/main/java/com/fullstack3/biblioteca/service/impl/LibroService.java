package com.fullstack3.biblioteca.service.impl;

import org.springframework.stereotype.Service;

import com.fullstack3.biblioteca.dto.response.LibroResponseDTO;
import com.fullstack3.biblioteca.model.LibroModel;
import com.fullstack3.biblioteca.repository.interfaces.ILibroRepository;
import com.fullstack3.biblioteca.service.interfaces.ILibroService;
import com.fullstack3.biblioteca.mapper.LibroMapper;
import com.fullstack3.biblioteca.dto.request.LibroRequestDTO;
import com.fullstack3.biblioteca.exception.ResourceNotFoundException;
import java.util.List;

@Service 
public class LibroService implements ILibroService {
    
    private final ILibroRepository _repo;
    private final LibroMapper _mapper;

    public LibroService(ILibroRepository repo, LibroMapper mapper) {
        _repo = repo;
        _mapper = mapper;
    }

    @Override 
    public List<LibroResponseDTO> obtenerLibros() {
        List<LibroModel> libros = _repo.getAllLibros();
        return _mapper.toResponseList(libros);
    }

    @Override
    public LibroResponseDTO obtenerLibroPorId(int id) {
        LibroModel libro = _repo.getById(id);

        if (libro == null) {
            throw new ResourceNotFoundException("Libro no encontrado con ID: " + id);
        }

        return _mapper.toResponse(libro);
    }

    @Override 
    public LibroResponseDTO crearLibro(LibroRequestDTO.Create request) {
        var libro = _mapper.toEntityCreate(request);
        var result = _repo.create(libro);
        return obtenerLibroPorId(result);
    }

    @Override 
    public String actualizarLibro(LibroRequestDTO.Update request) {

        var libro = _mapper.toEntityUpdate(request);

        if (_repo.getById(libro.getIdlibro()) == null) {
            throw new ResourceNotFoundException("Libro no encontrado con ID: " + libro.getIdlibro());
        }

        _repo.update(libro);

        return "Libro actualizado con éxito";
    }

    @Override
    public void eliminarLibro(int id) {
        if (_repo.getById(id) == null) {
            throw new ResourceNotFoundException("Libro no encontrado con ID: " + id);
        }
        _repo.delete(id);
    }
}
