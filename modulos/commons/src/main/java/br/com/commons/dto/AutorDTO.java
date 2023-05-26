package br.com.commons.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AutorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String nome;
}
