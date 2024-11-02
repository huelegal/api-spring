package vitor.dev.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import vitor.dev.api.enums.CategoriaProduto;

public record ProdutoInputDTO(
                @NotBlank String nome,
                @NotBlank String descricao,
                @NotNull @DecimalMin(value = "0.0") Double preco,
                @NotNull CategoriaProduto categoria) {
}
