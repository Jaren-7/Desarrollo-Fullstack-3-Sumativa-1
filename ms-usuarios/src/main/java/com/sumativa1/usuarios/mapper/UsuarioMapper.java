package com.sumativa1.usuarios.mapper;

import com.sumativa1.usuarios.dto.response.UsuarioResponseDTO;
import com.sumativa1.usuarios.dto.request.UsuarioRequestDTO;
import com.sumativa1.usuarios.model.UsuarioModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    
    @Mapping(target = "password_hash", ignore = true) 
    UsuarioResponseDTO toResponse(UsuarioModel usuario);

    @Mapping(target = "fecha_creacion", ignore = true)
    UsuarioModel toEntityCreate(UsuarioRequestDTO.Create usuario);

}
