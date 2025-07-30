package com.foro_alura.domain.Topico;

import com.foro_alura.domain.Curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TopicoRequestDTO(
        @NotBlank(message = "El titulo no puede estar en blanco")
        @Size(min = 5, max = 255, message = "El titulo debe tener entre 5 y 255 caracteres")
        String titulo,

        @NotBlank(message = "El mensaje no puede estar en blanco")
        String mensaje,

        @NotNull(message = "El ID del autor no puede ser nulo")
        Long autorId,

        @NotNull(message = "El ID del curso no puede ser nulo")
        Long cursoId
) {
}
