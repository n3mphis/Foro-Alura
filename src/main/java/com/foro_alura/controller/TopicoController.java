package com.foro_alura.controller;

import com.foro_alura.domain.Topico.Topico;
import com.foro_alura.domain.Topico.TopicoRequestDTO;
import com.foro_alura.domain.Topico.TopicoResponseDTO;
import com.foro_alura.domain.Topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping("/topicos")
    public ResponseEntity<TopicoResponseDTO> registrarTopico(
            @RequestBody @Valid TopicoRequestDTO datosTopico,
            UriComponentsBuilder uriBuilder) {
        Topico topicoCreado = topicoService.crearTopico(datosTopico);

        TopicoResponseDTO responseDTO = new TopicoResponseDTO(topicoCreado);

        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoCreado.getId()).toUri();

        return ResponseEntity.created(url).body(responseDTO);
    }

}
