package com.foro_alura.domain.Topico;

import com.foro_alura.domain.Curso.Curso;
import com.foro_alura.domain.Respuesta.Respuesta;
import com.foro_alura.domain.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private StatusTopico statusTopico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    public Topico(Object o, @NotBlank(message = "El titulo no puede estar en blanco") @Size(min = 5, max = 255, message = "El titulo debe tener entre 5 y 255 caracteres") String titulo, @NotBlank(message = "El mensaje no puede estar en blanco") String mensaje, LocalDateTime now, StatusTopico statusTopico, Usuario autor, Curso curso) {
    }
}
