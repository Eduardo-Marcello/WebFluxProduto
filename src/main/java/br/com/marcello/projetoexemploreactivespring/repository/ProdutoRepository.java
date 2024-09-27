package br.com.marcello.projetoexemploreactivespring.repository;

import br.com.marcello.projetoexemploreactivespring.model.Produto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProdutoRepository extends R2dbcRepository<Produto, Long> {
}
