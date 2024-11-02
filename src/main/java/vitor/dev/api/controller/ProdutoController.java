package vitor.dev.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import vitor.dev.api.dto.ProdutoInputDTO;
import vitor.dev.api.dto.ProdutoOutputDTO;
import vitor.dev.api.model.Produto;
import vitor.dev.api.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid ProdutoInputDTO data) {
        produtoRepository.save(new Produto(data));
    }

    @GetMapping
    public Page<ProdutoOutputDTO> select(@PageableDefault(size = 10, sort = { "nome" }) Pageable page) {
        /*
         * localhost:8080/produto?size=1&page=1&sort=nome,desc
         * Faz a paginação do retorno @PageableDefault é sobrescrito pela URL
         */
        return produtoRepository.findAll(page).map(ProdutoOutputDTO::new);
    }

    // @GetMapping
    // public List<ProdutoOutputDTO> select() {
    // return
    // produtoRepository.findAll().stream().map(ProdutoOutputDTO::new).toList();
    // }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid ProdutoInputDTO data) {

    }
}
