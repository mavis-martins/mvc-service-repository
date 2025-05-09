package com.exemplo.organizacao.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProdutoDto {

    private UUID id;
    private String nome;
    private BigDecimal preco;
}
