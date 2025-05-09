package com.exemplo.organizacao.service;


import com.exemplo.organizacao.dto.ProdutoDto;
import com.exemplo.organizacao.model.Produto;
import com.exemplo.organizacao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoDto salvar(ProdutoDto dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto salvo = produtoRepository.save(produto);

        ProdutoDto resposta = new ProdutoDto();
        resposta.setId(salvo.getId());
        resposta.setNome(salvo.getNome());
        resposta.setPreco(salvo.getPreco());

        return resposta;
    }

    public List<ProdutoDto> listarTodos() {
        return produtoRepository.findAll().stream().map(produto -> {
            ProdutoDto dto = new ProdutoDto();
            dto.setId(produto.getId());
            dto.setNome(produto.getNome());
            dto.setPreco(produto.getPreco());
            return dto;
        }).collect(Collectors.toList());
    }

    public ProdutoDto buscarProdutoPorId(UUID id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        ProdutoDto dto = new ProdutoDto();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        return dto;
    }

    public void deletar(UUID id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }
}
