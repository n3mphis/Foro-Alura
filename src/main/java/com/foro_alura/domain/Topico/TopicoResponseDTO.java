package com.foro_alura.domain.Topico;

import java.time.LocalDateTime;

public record TopicoResponseDTO(Long id,
                                String titulo,
                                String mensaje,
                                LocalDateTime fechaCreacion,
                                StatusTopico status,
                                String autorNombre,
                                String cursoNombre,
                                String cursoCategoria) {
    public TopicoResponseDTO(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatusTopico(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre(),
                String.valueOf(topico.getCurso().getCategoria()));
    }
}
