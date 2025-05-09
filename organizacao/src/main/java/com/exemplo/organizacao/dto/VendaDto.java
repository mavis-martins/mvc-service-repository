package com.exemplo.organizacao.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class VendaDto {
    private UUID id;
    private LocalDateTime dataVenda;
    private UUID clienteId;
    private UUID vendedorId;
    private List<ItemVendaDto> itens;
}
