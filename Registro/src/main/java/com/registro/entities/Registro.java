package com.registro.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Registro {

    @Id
    private String id;
    private String usuario;
    private String accion;
    private String fecha;

}
