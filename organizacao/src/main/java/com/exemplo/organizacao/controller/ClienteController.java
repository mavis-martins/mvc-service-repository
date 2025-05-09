package com.exemplo.organizacao.controller;

import com.exemplo.organizacao.dto.ClienteDto;
import com.exemplo.organizacao.dto.ResponseCreateClienteDto;
import com.exemplo.organizacao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ResponseCreateClienteDto> criarCliente(@RequestBody ClienteDto clienteDto) {
        ResponseCreateClienteDto clienteSalvo = clienteService.salvar(clienteDto);
        return ResponseEntity.ok(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable UUID id) {
        ClienteDto clienteEncontrado = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(clienteEncontrado);
    }
}
