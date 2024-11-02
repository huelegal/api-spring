package vitor.dev.api.dto;

import vitor.dev.api.model.Produto;

public record ProdutoOutputDTO(int id, String nome, String descricao, Double preco) {

    public ProdutoOutputDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());
    }
}
