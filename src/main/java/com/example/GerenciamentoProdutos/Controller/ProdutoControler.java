package com.example.GerenciamentoProdutos.Controller;

import com.example.GerenciamentoProdutos.ProdutoModel;
import com.example.GerenciamentoProdutos.Services.ProdutoServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoControler {

    @Autowired
    private ProdutoServices produtoServices;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarAluno(@RequestBody ProdutoModel produtoModel) {

        ProdutoModel request = produtoServices.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> buscarProdutos () {
        List<ProdutoModel> request = produtoServices.buscarProduto();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletarProduto (@PathVariable Long id) {
        produtoServices.deletarProduto(id);

        return ResponseEntity.noContent().build();
    }
}
