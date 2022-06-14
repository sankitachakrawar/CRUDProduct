package com.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	
	//public ProductDto findById(Long Id);
	
	Optional<ProductEntity> findById(Long id ,Class<ProductEntity> ProductEntity);
	


}
