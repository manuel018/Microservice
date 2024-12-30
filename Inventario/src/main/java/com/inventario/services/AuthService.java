package com.inventario.services;

import com.inventario.entities.Usuario;
import com.inventario.entities.dto.LoginDTO;
import com.inventario.entities.dto.RegistroDTO;
import com.inventario.httpclient.RegistroClient;
import com.inventario.repositories.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private RegistroClient registroClient;

    public Optional<Usuario> authUser(LoginDTO loginDTO) {
        //solo si existe y compra mientas
        Usuario user = this.loginDtoToUsuario(loginDTO);

        Usuario userBase = usuarioRepo.findByUsuario(user.getUsuario()).orElse(new Usuario());

        if (user.getUsuario().equals(userBase.getUsuario()) && user.getPassword().equals(userBase.getPassword())) {
            registroClient.post(new RegistroDTO(null, userBase.getUsuario(), "Login", LocalDateTime.now().toString()));
            return Optional.of(userBase);
        } else {
            return Optional.empty();
        }
    }

    private Usuario loginDtoToUsuario(LoginDTO logingDTO) {
        return Usuario.builder()
                .usuario(logingDTO.usuario())
                .password(logingDTO.password())
                .build();
    }
}
