package com.registro.controllers;

import com.registro.entities.Registro;
import com.registro.services.RegistroService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping()
    public List<Registro> list() {
        return registroService.getRegistros();
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Registro registro) {
        return ResponseEntity.ok(registroService.saveRegistro(registro));
    }

    /* NO USADOS AUN YA QUE SOLO ES GUARDAR Y MOSTRAR LOGS DE LOS MOVIMIENTOS EN EL INVENTARIO
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
     */
}
