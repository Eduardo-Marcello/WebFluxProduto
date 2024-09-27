package br.com.marcello.projetoexemploreactivespring.service;

import br.com.marcello.projetoexemploreactivespring.model.Produto;
import br.com.marcello.projetoexemploreactivespring.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Flux<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Mono<Produto> save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Produto> update(Long id, Produto produto) {
        // Verifica se o produto com o ID fornecido existe
        log.info("Updating produto: {}", produto);
        return produtoRepository.findById(id)
                .flatMap(existingProduto -> {
                    // Atualiza as propriedades do produto existente com os valores do produto fornecido
                    existingProduto.setNome(produto.getNome());
                    existingProduto.setPreco(produto.getPreco());
                    // Adicione outras atualizações conforme necessário

                    // Salva o produto atualizado
                    return produtoRepository.save(existingProduto);
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")));
    }

    public Mono<Void> deleteById(Long id) {
        return produtoRepository.deleteById(id);
    }
}
