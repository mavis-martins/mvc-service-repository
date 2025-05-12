package com.exemplo.organizacao.service;

import com.exemplo.organizacao.dto.ClienteDto;
import com.exemplo.organizacao.dto.ResponseCreateClienteDto;
import com.exemplo.organizacao.mapper.ClienteMapperStruct;
import com.exemplo.organizacao.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exemplo.organizacao.repository.ClienteRepository;

import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapperStruct clienteMapperStruct;

    public ResponseCreateClienteDto salvar(ClienteDto dto) {
        Cliente cliente = clienteMapperStruct.toEntity(dto);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteMapperStruct.toResponseCreateClienteDto(clienteSalvo);
    }

    public ClienteDto buscarClientePorId(UUID id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        ClienteDto dto = new ClienteDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setPhone(cliente.getPhone());
        dto.setCpf(cliente.getCpf());
        return dto;
    }
}
