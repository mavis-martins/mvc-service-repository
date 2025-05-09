package com.exemplo.organizacao.repository;

import org.springframework.stereotype.Repository;
import com.exemplo.organizacao.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {

}
