package com.foro_alura.domain.Topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTitulo(String titulo);

    Optional<Topico> findByMensaje(String mensaje);

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findByCursoNombre(String nombreCurso, Pageable paginacion);

    Page<Topico> findByAutorNombre(String nombreAutor, Pageable pagionacion);
}
