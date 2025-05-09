package com.exemplo.organizacao.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ItemVendaDto {
    private UUID produtoId;
    private Integer quantidade;
    private BigDecimal subtotal;
}
