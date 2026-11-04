package com.sumativa1.usuarios.service.impl;

import org.springframework.stereotype.Service;
import com.sumativa1.usuarios.service.interfaces.IUsuarioService;
import com.sumativa1.usuarios.dto.response.UsuarioResponseDTO;
import com.sumativa1.usuarios.repository.interfaces.IUsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sumativa1.usuarios.model.UsuarioModel;
import com.sumativa1.usuarios.mapper.UsuarioMapper;
import com.sumativa1.usuarios.exception.ResourceNotFoundException;
import java.util.Set;
import com.sumativa1.usuarios.dto.request.UsuarioRequestDTO;
import com.sumativa1.usuarios.exception.UserAlreadyExistsException;

@Service 
public class UsuarioService implements IUsuarioService {
    
    private final PasswordEncoder _passwordEncoder;
    private final IUsuarioRepository _repo;
    private final UsuarioMapper _mapper;

    private static final Set<String> ROLES_PERMITIDOS =
        Set.of("ADMIN", "BIBLIOTECARIO", "LECTOR");

    public UsuarioService(IUsuarioRepository repo, UsuarioMapper mapper, PasswordEncoder passwordEncoder) {
        _repo = repo;
        _mapper = mapper;
        _passwordEncoder = passwordEncoder;
    }

    @Override 
    public UsuarioResponseDTO buscarUsuario(String username) {
        
        UsuarioModel usuario = _repo.getByUsername(username);

        if (usuario == null) {
            throw new ResourceNotFoundException("Usuario " + username + " no encontrado");
        }

        return _mapper.toResponse(usuario);
    }

    @Override 
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO.Create usuario) {
        
        if (!ROLES_PERMITIDOS.contains(usuario.getRol().toUpperCase())) {
            throw new IllegalArgumentException("Rol no permitido: " + usuario.getRol());
        }

        UsuarioModel usuarioModel = _mapper.toEntityCreate(usuario);

        var existingUser = _repo.validationUser(usuarioModel);
        if (existingUser > 0) {
            throw new UserAlreadyExistsException("El usuario ya existe con el mismo username o email");
        }

        // Encriptar la contraseña antes de guardarla
        String hashedPassword = _passwordEncoder.encode(usuarioModel.getPassword_hash());
        usuarioModel.setPassword_hash(hashedPassword);

        var result = _repo.create(usuarioModel);
        return _mapper.toResponse(_repo.getById(result));
    }

}
