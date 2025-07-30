package com.foro_alura.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCorreoElectronico(String username);
}
