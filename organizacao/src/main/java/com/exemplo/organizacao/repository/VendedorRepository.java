package com.exemplo.organizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.organizacao.model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, UUID> {

}
