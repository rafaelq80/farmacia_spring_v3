package com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List <Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	/**
	 *  Método Personalizado - Buscar por Nome do Produto e pelo Nome do Laboratório
	 *  
	 *  MySQL: select * from tb_produtos where nome = "produto" and laboratorio = "laboratorio";
	 */
	 
	public List <Produto> findAllByNomeAndLaboratorio(String nome, String laboratorio);
	
	/**
	 *  Método Personalizado - Buscar por Nome do Produto ou pelo Nome do Laboratório
	 *  
	 *  MySQL: select * from tb_produtos where nome = "produto" or laboratorio = "laboratorio";
	 */
	public List <Produto> findAllByNomeOrLaboratorio(String nome, String laboratorio);

	/**
	 *  Método Personalizado - Buscar por Nome do Produto ou pelo Nome do Laboratório
	 *  
	 *  MySQL: select * from tb_produtos where preco between inicio and fim;
	 */
	
	List<Produto> findAllByPrecoBetween(BigDecimal inicio, BigDecimal fim);

}
