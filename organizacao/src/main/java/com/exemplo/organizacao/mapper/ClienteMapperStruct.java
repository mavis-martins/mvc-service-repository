package com.exemplo.organizacao.mapper;

import com.exemplo.organizacao.dto.ClienteDto;
import com.exemplo.organizacao.dto.ResponseCreateClienteDto;
import com.exemplo.organizacao.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapperStruct {
    Cliente toEntity(ClienteDto dto);
    ClienteDto toClienteDto(Cliente entity);
    ResponseCreateClienteDto toResponseCreateClienteDto(Cliente entity);
}
