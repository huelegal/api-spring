package vitor.dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vitor.dev.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
