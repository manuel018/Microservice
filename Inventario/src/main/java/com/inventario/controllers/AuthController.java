package com.inventario.controllers;

import com.inventario.entities.dto.LoginDTO;
import com.inventario.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/inventario/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> post(@RequestBody LoginDTO loginDTO) {
        //Mejorar logica
        try {
            if (authService.authUser(loginDTO).isPresent()) {
                return ResponseEntity.ok("Login");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
