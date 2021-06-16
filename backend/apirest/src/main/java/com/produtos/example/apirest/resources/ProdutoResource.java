package com.produtos.example.apirest.resources;

import com.produtos.example.apirest.models.Produto;
import com.produtos.example.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value="/")
@Api(value="API REST Produtos")
//@CrossOrigin(origins="*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @CrossOrigin
    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna um produto único")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id) {
        return produtoRepository.findById(id);
    }

    @CrossOrigin
    @PostMapping("/produto")
    @ApiOperation(value="Salva um produto")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @CrossOrigin
    @DeleteMapping("/produto")
    @ApiOperation(value="Deleta um produto")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @CrossOrigin
    @PutMapping("/produto")
    @ApiOperation(value="Atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}
