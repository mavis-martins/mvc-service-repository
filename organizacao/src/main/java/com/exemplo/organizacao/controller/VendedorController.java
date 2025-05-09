package com.exemplo.organizacao.controller;

import com.exemplo.organizacao.dto.VendedorDto;
import com.exemplo.organizacao.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<VendedorDto> criarVendedor(@RequestBody VendedorDto vendedorDto) {
        VendedorDto vendedorSalvo = vendedorService.salvar(vendedorDto);
        return ResponseEntity.ok(vendedorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<VendedorDto>> buscarVendedores() {
        List<VendedorDto> vendedor = vendedorService.listarTodos();
        return ResponseEntity.ok(vendedor);
    }
}
