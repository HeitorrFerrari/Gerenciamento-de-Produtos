package com.example.GerenciamentoProdutos.Services;


import com.example.GerenciamentoProdutos.ProdutoModel;
import com.example.GerenciamentoProdutos.Repositories.ProdutoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepositorie produtoRepositorie;

    public ProdutoModel criarProduto (ProdutoModel produtoModel) {
        return produtoRepositorie.save(produtoModel);
    }

    public List<ProdutoModel> buscarProduto () {
        return produtoRepositorie.findAll();
    }

    public ProdutoModel buscarId (Long id) {
        return produtoRepositorie.findById(id).get();
    }

    public void deletarProduto (Long id) {
        produtoRepositorie.deleteById(id);
    }

}
