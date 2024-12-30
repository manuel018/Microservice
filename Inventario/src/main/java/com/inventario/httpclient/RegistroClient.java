package com.inventario.httpclient;

import com.inventario.entities.dto.RegistroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Registro", url = "http://localhost:8085/registro")
public interface RegistroClient {

    @PostMapping
    public RegistroDTO post(@RequestBody RegistroDTO registro);
}
