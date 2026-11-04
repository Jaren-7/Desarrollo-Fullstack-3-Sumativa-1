package com.sumativa1.usuarios.repository.interfaces;

import com.sumativa1.usuarios.model.UsuarioModel;

public interface IUsuarioRepository {

    UsuarioModel getById(int idusuario);

    UsuarioModel getByUsername(String username);

    int validationUser(UsuarioModel usuario);

    int create(UsuarioModel usuario);

}
