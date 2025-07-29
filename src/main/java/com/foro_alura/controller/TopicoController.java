package com.foro_alura.controller;

import com.foro_alura.domain.Curso.Curso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicoController {

    @PostMapping("/topicos")
    public ResponseEntity registrarTopico(@RequestBody String titulo, String mensaje, String autor, Curso curso) {
        return ResponseEntity.ok("todo bien");
    }
}
