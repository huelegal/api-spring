package vitor.dev.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vitor.dev.api.dto.ProdutoInputDTO;
import vitor.dev.api.enums.CategoriaProduto;

@Table(name = "produto")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Double preco;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    public Produto(ProdutoInputDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.preco = data.preco();
        this.categoria = data.categoria();
        /*
         * Se esta classe tivesse composição, como endereço, seria necessário repetir o
         * processo:
         * Criar um construtor na classe endereço que recebe os dados do DTO da classe
         * endereço, e dentro do contrutor do produto chamar este endereço.
         * this.endereco = new Endereco(dados.endereco)
         * dados.endereco seria o DTO da do Endereco
         */
    }
}
