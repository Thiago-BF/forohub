package com.thiago.forohub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosCrearTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje

) {
}