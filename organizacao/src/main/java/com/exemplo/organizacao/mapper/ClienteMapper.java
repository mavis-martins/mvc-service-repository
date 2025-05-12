package com.exemplo.organizacao.mapper;

import com.exemplo.organizacao.dto.ClienteDto;
import com.exemplo.organizacao.model.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setPhone(dto.getPhone());
        return cliente;
    }

    public static ClienteDto toDto(Cliente entity) {
        ClienteDto dto = new ClienteDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setPhone(entity.getPhone());
        dto.setCpf(entity.getCpf());
        return dto;
    }
}
