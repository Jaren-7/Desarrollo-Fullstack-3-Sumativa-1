package com.sumativa1.usuarios.service.interfaces;

import com.sumativa1.usuarios.dto.response.UsuarioResponseDTO;
import com.sumativa1.usuarios.dto.request.UsuarioRequestDTO;

public interface IUsuarioService {

    UsuarioResponseDTO buscarUsuario(String username);

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO.Create usuario);
}
