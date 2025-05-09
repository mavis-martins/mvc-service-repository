package com.exemplo.organizacao.service;

import com.exemplo.organizacao.dto.ClienteDto;
import com.exemplo.organizacao.dto.ResponseCreateClienteDto;
import com.exemplo.organizacao.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exemplo.organizacao.repository.ClienteRepository;

import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseCreateClienteDto salvar(ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setPhone(dto.getPhone());

        Cliente salvo = clienteRepository.save(cliente);

        ResponseCreateClienteDto resposta = new ResponseCreateClienteDto();
        resposta.setId(salvo.getId());
        resposta.setNome(salvo.getNome());
        resposta.setPhone(salvo.getPhone());
        return resposta;
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
