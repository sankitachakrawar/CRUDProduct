package com.crud.service;

import java.util.List;



import com.crud.dto.ProductDto;
import com.crud.entity.ProductEntity;
import com.crud.exceptionsHandling.ResourceNotFoundException;



public interface ProductServiceInterface {

	//Add products
	public ProductEntity addProduct(ProductEntity productEntity);
	
	//for update product information
	//void updateProduct(Long id);
	
	//for display list of products
	public List<ProductEntity> getAllProducts();


	ProductEntity findById(Long id) throws ResourceNotFoundException;

	public void deleteProduct(Long id);

	//void editUser(Long id, ProductDto userBody) throws ResourceNotFoundException;

	
	
	
	
}
