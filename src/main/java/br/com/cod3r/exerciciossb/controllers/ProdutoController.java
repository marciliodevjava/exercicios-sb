package br.com.cod3r.exerciciossb.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepository;

//Crud - Create
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	// - Create - Post
//	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})// POST e PUT
	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {

		produtoRepository.save(produto);
		return produto;
	}

	// - Read todos - Get
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}


	// - Read por ID - Get
	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}

	@GetMapping(path = "/pagina/{numeroPagina}/{qtbePagina}")
	public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina, @PathVariable int qtbePagina) {
		if (qtbePagina <= 5) {
			qtbePagina = 5;
		} else if (qtbePagina <= 10) {
			qtbePagina = 10;
		} else {
			qtbePagina = 15;
		}
		Pageable page = PageRequest.of(numeroPagina, qtbePagina);
		return produtoRepository.findAll(page);
	}

	// - Update - Put
	@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	// - Delete
	@DeleteMapping(path = "/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
}
