package com.crud.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crud.dto.ChangePasswordDto;
import com.crud.dto.ProductDto;
import com.crud.entity.ProductEntity;
import com.crud.exceptionsHandling.ResourceNotFoundException;



public interface ProductServiceInterface {

	//Add products
	public ProductEntity addProduct(ProductEntity productEntity);
	
	
	//for display list of products
	public List<ProductEntity> getAllProducts();


	ProductEntity findById(Long id) throws ResourceNotFoundException;

	public void deleteProduct(Long id);

	//void changePassword(Long userId, ChangePasswordDto userBody, HttpServletRequest request) throws ResourceNotFoundException;
	
	
	
}
