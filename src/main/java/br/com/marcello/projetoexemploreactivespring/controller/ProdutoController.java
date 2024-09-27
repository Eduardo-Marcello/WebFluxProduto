package br.com.marcello.projetoexemploreactivespring.controller;

import br.com.marcello.projetoexemploreactivespring.model.Produto;
import br.com.marcello.projetoexemploreactivespring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Flux<Produto> all(){
        return produtoService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Produto> findById(@PathVariable Long id){
        return produtoService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Produto> save(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @PutMapping("{id}")
    public Mono<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.update(id, produto);
    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return produtoService.deleteById(id);

    }
}
