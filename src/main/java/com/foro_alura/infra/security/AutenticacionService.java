package com.foro_alura.infra.security;

import com.foro_alura.domain.Usuario.Usuario;
import com.foro_alura.domain.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("Buscando usuario por correo: " + username);
        return usuarioRepository.findByCorreoElectronico(username);
    }
}
