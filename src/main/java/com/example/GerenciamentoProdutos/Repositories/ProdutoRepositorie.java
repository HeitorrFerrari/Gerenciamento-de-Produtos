package com.example.GerenciamentoProdutos.Repositories;

import com.example.GerenciamentoProdutos.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorie extends JpaRepository<ProdutoModel,Long> {
}
