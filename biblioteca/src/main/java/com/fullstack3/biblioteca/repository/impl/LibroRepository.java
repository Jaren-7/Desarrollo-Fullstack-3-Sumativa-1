package com.fullstack3.biblioteca.repository.impl;

import org.springframework.stereotype.Repository;
import com.fullstack3.biblioteca.repository.interfaces.ILibroRepository;
import com.fullstack3.biblioteca.model.LibroModel;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

@Repository 
public class LibroRepository implements ILibroRepository {
    
    private final Jdbi _jdbi;

    public LibroRepository(Jdbi jdbi) {
        _jdbi = jdbi;
    }

    @Override 
    public List<LibroModel> getAllLibros() {
        
        return _jdbi.withHandle(handle ->
            handle.createQuery("""
                SELECT 
                idlibro
                , titulo
                , autor
                , publicacion
                , genero
                FROM libros
            """)
            .mapToBean(LibroModel.class)
            .list()
        );
    }

    @Override 
    public LibroModel getById(int id) {
        return _jdbi.withHandle(handle ->
            handle.createQuery("""
                SELECT 
                idlibro
                , titulo
                , autor
                , publicacion
                , genero
                FROM libros
                WHERE idlibro = :id
            """)
            .bind("id", id)
            .mapToBean(LibroModel.class)
            .findOne()
            .orElse(null)
        );
    }

    @Override
    public int create(LibroModel libro) {
        return _jdbi.withHandle(handle ->
            handle.createUpdate("""
                INSERT INTO libros (titulo, autor, publicacion, genero)
                VALUES (:titulo, :autor, :publicacion, :genero)
            """)
            .bind("titulo", libro.getTitulo())
            .bind("autor", libro.getAutor())
            .bind("publicacion", libro.getPublicacion())
            .bind("genero", libro.getGenero())
            .executeAndReturnGeneratedKeys("idlibro")
            .mapTo(int.class)
            .one()
        );
    }

}
