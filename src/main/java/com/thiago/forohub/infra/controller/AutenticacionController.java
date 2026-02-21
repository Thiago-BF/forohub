package com.thiago.forohub.infra.controller;

import com.thiago.forohub.domain.usuario.DatosAutenticacion;
import com.thiago.forohub.domain.usuario.Usuario;
import com.thiago.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String autenticar(@RequestBody @Valid DatosAutenticacion datos) {

        var authToken = new UsernamePasswordAuthenticationToken(
                datos.login(),
                datos.password()
        );

        var authentication = authenticationManager.authenticate(authToken);

        var usuario = (Usuario) authentication.getPrincipal();

        return tokenService.generarToken(usuario);
    }
}