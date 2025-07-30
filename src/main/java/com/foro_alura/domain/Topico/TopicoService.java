package com.foro_alura.domain.Topico;

import com.foro_alura.domain.Curso.Curso;
import com.foro_alura.domain.Curso.CursoRepository;
import com.foro_alura.domain.Usuario.Usuario;
import com.foro_alura.domain.Usuario.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TopicoService {
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public Topico crearTopico(TopicoRequestDTO datos) {
        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado con id " + datos.autorId()));

        Curso curso = cursoRepository.findById(datos.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con id " + datos.cursoId()));

        Topico topico = new Topico(
                null,
                datos.titulo(),
                datos.mensaje(),
                LocalDateTime.now(),
                StatusTopico.NO_RESPONDIDO,
                autor,
                curso
        );

        return topicoRepository.save(topico);
    }

    public Page<Topico> listarTopicos(Pageable paginacion) {
        return topicoRepository.findAll(paginacion);
    }

    public Optional<Topico> buscarTopicoPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Optional<Topico> buscarTopicoPorTitulo(String titulo) {
        return topicoRepository.findByTitulo(titulo);
    }
}
