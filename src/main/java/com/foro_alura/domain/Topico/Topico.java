package com.foro_alura.domain.Topico;

import com.foro_alura.domain.Curso.Curso;
import com.foro_alura.domain.Respuesta.Respuesta;
import com.foro_alura.domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_topico")
    private StatusTopico statusTopico;       // por default

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.fechaCreacion = LocalDateTime.now();
        this.statusTopico = StatusTopico.ABIERTO;
    }

    public void actualizarTopico(String titulo, String mensaje) {
        if (titulo != null && !titulo.isBlank()) {
            this.titulo = titulo;
        }

        if (mensaje != null && !mensaje.isBlank()) {
            this.mensaje = mensaje;
        }
    }
}
