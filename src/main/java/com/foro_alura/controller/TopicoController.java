package com.foro_alura.controller;

import com.foro_alura.domain.Topico.*;
import com.foro_alura.domain.ValidacionException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<TopicoResponseDTO> registrarTopico(
            @RequestBody @Valid TopicoRequestDTO datosTopico,
            UriComponentsBuilder uriBuilder) {
        TopicoResponseDTO topicoCreado = topicoService.crearTopico(datosTopico);

        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoCreado.getId()).toUri();

        return ResponseEntity.created(url).body(topicoCreado);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoResponseDTO>> listarTopicos(@PageableDefault(size = 10, sort = {"fechaCreacion"})Pageable paginacion) {
        Page<Topico> topicos = topicoService.listarTopicos(paginacion);

        Page<TopicoResponseDTO> topicosPaginadosDTO = topicos.map(TopicoResponseDTO::new);

        return ResponseEntity.ok(topicosPaginadosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detallarTopico(@PathVariable Long id) {
        TopicoResponseDTO topicoResponseDTO = topicoService.detallarTopico(id);

        return ResponseEntity.ok(topicoResponseDTO);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> actualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoActualizarDTO topicoActualizarDTO) {
        TopicoResponseDTO actualizado = topicoService.actualizarTopico(id, topicoActualizarDTO);

        return ResponseEntity.ok(actualizado);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> eliminarTopico(@PathVariable Long id) {
        topicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
