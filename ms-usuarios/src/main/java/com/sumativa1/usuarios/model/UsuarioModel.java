package main.java.com.sumativa1.usuarios.model;

import loombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    private int idusuario;
    private String username;
    private String password_hash;
    private String email;
    private String nombre;
    private String rol;
    private Integer activo;
    private LocalDateTime fecha_creacion;
}
