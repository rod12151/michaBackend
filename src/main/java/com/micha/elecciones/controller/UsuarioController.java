package com.micha.elecciones.controller;

import com.micha.elecciones.exception.BadRequestException;
import com.micha.elecciones.model.daos.UsuarioRepository;
import com.micha.elecciones.model.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/auth/registro")
    Usuario registrarUsuario(@RequestBody @Validated Usuario usuario) {
        System.out.println("sddd"+usuario);
        boolean emailExiste = usuarioRepository.existsByEmail(usuario.getEmail());

        if (emailExiste) {
            throw new BadRequestException("El email ya fue registrado para otro usuario.");
        }
        //System.out.println("jjdjdjdjdjdj");
        usuario.setRol(Usuario.Rol.LECTOR);
        usuario.setPassword(passwordEncoder.encode(usuario.getPasswordPlain()));
        usuarioRepository.save(usuario);
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/auth/verificar-email")
    Map<String, Boolean> verificarEmail(@RequestParam String email) {
        boolean emailExiste = usuarioRepository.existsByEmail(email);

        Map<String, Boolean> resultado = new HashMap<>();
        resultado.put("exists", emailExiste);

        return resultado;
    }

    @GetMapping("/auth/listar")
    List<Usuario> listarusuario(){
        return usuarioRepository.findAll();
    }
}
