package com.thiago.forohub.domain.topico.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(

        @NotNull
        Long id,

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje

) {
}