package com.exemplo.organizacao.service;

import com.exemplo.organizacao.dto.VendedorDto;
import com.exemplo.organizacao.model.Vendedor;
import com.exemplo.organizacao.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public VendedorDto salvar(VendedorDto dto) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(dto.getNome());
        vendedor.setPhone(dto.getPhone());
        vendedor.setNumeroMatricula(dto.getNumeroMatricula());

        Vendedor salvo = vendedorRepository.save(vendedor);

        VendedorDto resposta = new VendedorDto();
        resposta.setId(salvo.getId());
        resposta.setNome(salvo.getNome());
        resposta.setPhone(salvo.getPhone());
        resposta.setNumeroMatricula(salvo.getNumeroMatricula());

        return resposta;
    }

    public List<VendedorDto> listarTodos() {
        return vendedorRepository.findAll().stream().map(vendedor -> {
            VendedorDto dto = new VendedorDto();
            dto.setId(vendedor.getId());
            dto.setNome(vendedor.getNome());
            dto.setPhone(vendedor.getPhone());
            dto.setNumeroMatricula(vendedor.getNumeroMatricula());
            return dto;
        }).collect(Collectors.toList());
    }

    public VendedorDto buscarVendedorPorId(UUID id) {
        Vendedor vendedor = vendedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));
        VendedorDto dto = new VendedorDto();
        dto.setId(vendedor.getId());
        dto.setNome(vendedor.getNome());
        dto.setPhone(vendedor.getPhone());
        dto.setNumeroMatricula(vendedor.getNumeroMatricula());
        return dto;
    }

    public void deletar(UUID id) {
        Vendedor vendedor = vendedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));
        vendedorRepository.delete(vendedor);
    }
}
