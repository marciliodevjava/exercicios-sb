package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import br.com.cod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

	public abstract Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	
	//Exemplos
	
//	findByNomeContaining
//	findByNomeIsContaining
//	findByNomeContains
	
//	findByNomeStartsWith
//	findByNomeEndsWith
	
//	findByNomeContaining
	
	// Exemplo utilizando uma query
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String parteNome);
}
