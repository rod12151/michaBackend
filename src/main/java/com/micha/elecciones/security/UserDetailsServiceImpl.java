package com.micha.elecciones.security;

import com.micha.elecciones.model.daos.UsuarioRepository;
import com.micha.elecciones.model.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new AppUserDetails(usuario);
    }
}
