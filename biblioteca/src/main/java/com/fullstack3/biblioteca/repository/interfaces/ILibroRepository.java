package com.fullstack3.biblioteca.repository.interfaces;

import com.fullstack3.biblioteca.model.LibroModel;
import java.util.List;

public interface ILibroRepository {

    List<LibroModel> getAllLibros();

    LibroModel getById(int id);

    int create(LibroModel libro);
}
