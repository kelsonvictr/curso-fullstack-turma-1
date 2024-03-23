package br.com.gerenciadordeprodutos.api.Supplier.repository;

import br.com.gerenciadordeprodutos.api.Supplier.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
