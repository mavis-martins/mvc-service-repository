package com.exemplo.organizacao.repository;

import com.exemplo.organizacao.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, UUID> {
}
