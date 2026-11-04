package com.sumativa1.usuarios.repository.impl;

import org.springframework.stereotype.Repository;
import org.jdbi.v3.core.Jdbi;
import com.sumativa1.usuarios.repository.interfaces.IUsuarioRepository;
import com.sumativa1.usuarios.model.UsuarioModel;
import java.time.LocalDateTime;

@Repository 
public class UsuarioRepository implements IUsuarioRepository {
    
    private final Jdbi _jdbi;

    public UsuarioRepository(Jdbi jdbi) {
        _jdbi = jdbi;
    }

    @Override
    public UsuarioModel getById(int idusuario) {
        return _jdbi.withHandle(handle -> 
            handle.createQuery("""
                SELECT 
                idusuario
                , username
                , nombre
                , email
                , rol
                , activo
                , fecha_creacion
                FROM usuario WHERE idusuario = :idusuario
            """)
                .bind("idusuario", idusuario)
                .mapToBean(UsuarioModel.class)
                .findOne()
                .orElse(null)
        );
    }

    @Override 
    public UsuarioModel getByUsername(String username) {
        return _jdbi.withHandle(handle -> 
            handle.createQuery("""
                SELECT 
                *
                FROM usuario WHERE username = :username
            """)
                .bind("username", username)
                .mapToBean(UsuarioModel.class)
                .findOne()
                .orElse(null)
        );
    }

    @Override 
    public int validationUser(UsuarioModel usuario) {
        return _jdbi.withHandle(handle -> 
            handle.createQuery("""
                SELECT 
                count(*) AS count
                FROM usuario WHERE username = :username OR email = :email
            """)
                .bind("username", usuario.getUsername())
                .bind("email", usuario.getEmail())
                .mapToBean(int.class)
                .findOne()
                .orElse(0)
        );
    }

    @Override 
    public int create(UsuarioModel usuario) {

        LocalDateTime now = LocalDateTime.now();
        usuario.setFecha_creacion(now);

        return _jdbi.withHandle(handle -> 
            handle.createUpdate("""
                INSERT INTO usuario (username, password_hash, nombre, email, rol, activo, fecha_creacion)
                VALUES (:username, :password_hash, :nombre, :email, :rol, :activo, :fecha_creacion)
            """)
                .bind("username", usuario.getUsername())
                .bind("password_hash", usuario.getPassword_hash())
                .bind("nombre", usuario.getNombre())
                .bind("email", usuario.getEmail())
                .bind("rol", usuario.getRol())
                .bind("activo", usuario.getActivo())
                .bind("fecha_creacion", usuario.getFecha_creacion())
                .executeAndReturnGeneratedKeys("idusuario")
                .mapTo(int.class)
                .one()
        );
    }
    
}
