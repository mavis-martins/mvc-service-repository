package com.exemplo.organizacao.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResponseCreateClienteDto {
    private UUID id;
    private String nome;
    private String phone;
}
