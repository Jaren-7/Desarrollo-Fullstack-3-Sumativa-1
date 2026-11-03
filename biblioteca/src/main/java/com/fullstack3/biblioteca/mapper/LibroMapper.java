package com.fullstack3.biblioteca.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.fullstack3.biblioteca.dto.response.LibroResponseDTO;
import com.fullstack3.biblioteca.dto.request.LibroRequestDTO;
import com.fullstack3.biblioteca.model.LibroModel;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LibroMapper {
    
    @Mapping(target = "idlibro", ignore = true)
    // @Mapping(target = "titulo", ignore = true)
    // @Mapping(target = "autor", ignore = true)
    // @Mapping(target = "publicacion", ignore = true)
    // @Mapping(target = "genero", ignore = true)
    LibroModel toEntityCreate(LibroRequestDTO.Create request);
    LibroModel toEntityUpdate(LibroRequestDTO.Update request);

    List<LibroResponseDTO> toResponseList(List<LibroModel> libros);

    
    LibroResponseDTO toResponse(LibroModel libro);

}
