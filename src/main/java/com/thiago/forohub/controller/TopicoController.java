package com.thiago.forohub.controller;

import com.thiago.forohub.domain.topico.Topico;
import com.thiago.forohub.domain.topico.TopicoRepository;
import com.thiago.forohub.domain.topico.dto.DatosActualizarTopico;
import com.thiago.forohub.domain.topico.dto.DatosCrearTopico;
import com.thiago.forohub.domain.topico.dto.DatosListadoTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<DatosListadoTopico> crearTopico(
            @RequestBody @Valid DatosCrearTopico datos,
            UriComponentsBuilder uriBuilder) {

        Topico topico = new Topico(datos.titulo(), datos.mensaje());
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity.created(uri)
                .body(new DatosListadoTopico(topico));
    }

    @GetMapping
    public Page<DatosListadoTopico> listarTopicos(Pageable paginacion) {
        return repository.findByActivoTrue(paginacion)
                .map(DatosListadoTopico::new);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {

        Topico topico = repository.getReferenceById(id);
        topico.desactivar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarTopico datos) {

        Topico topico = repository.getReferenceById(id);
        topico.actualizar(datos.titulo(), datos.mensaje());

        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }
}