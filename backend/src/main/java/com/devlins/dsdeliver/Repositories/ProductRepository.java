package com.devlins.dsdeliver.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devlins.dsdeliver.entities.Product;

import java.util.List;

						//CAMADA DE ACESSO A DADOS

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAllByOrderByNameAsc();

}
