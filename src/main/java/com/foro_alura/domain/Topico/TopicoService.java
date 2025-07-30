package com.foro_alura.domain.Topico;

import com.foro_alura.domain.Curso.Curso;
import com.foro_alura.domain.Curso.CursoRepository;
import com.foro_alura.domain.Usuario.Usuario;
import com.foro_alura.domain.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @Transactional
    public TopicoResponseDTO crearTopico(TopicoRequestDTO datos) {
        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado con id " + datos.autorId()));

        Curso curso = cursoRepository.findById(datos.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con id " + datos.cursoId()));

        Topico topico = new Topico(datos.titulo(), datos.mensaje(), autor, curso);

        topicoRepository.save(topico);

        return new TopicoResponseDTO(topico);
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
