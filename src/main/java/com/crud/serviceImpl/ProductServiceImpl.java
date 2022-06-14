package com.crud.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.ProductDto;
import com.crud.entity.ProductEntity;
import com.crud.exceptionsHandling.ResourceNotFoundException;
import com.crud.repository.ProductRepository;
import com.crud.service.ProductServiceInterface;


@Service
public class ProductServiceImpl implements ProductServiceInterface{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductEntity addProduct(ProductEntity productDetail) {
		ProductEntity productEntity=new ProductEntity();
		//productEntity.setId(productDetail.getId());
		productEntity.setName(productDetail.getName());
		productEntity.setDescription(productDetail.getDescription());
		productEntity.setPrice(productDetail.getPrice());
		productEntity.setStatus(productDetail.getStatus());
		
		return productRepository.save(productEntity);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		
		return productRepository.findAll();
	}



	@Override
	public ProductEntity findById(Long id) throws ResourceNotFoundException {
		
		ProductEntity product=productRepository.findById(id,ProductEntity.class).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
		return product;

	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}

	/*
	 * @Override public void editUser(Long id, ProductDto productDto) throws
	 * ResourceNotFoundException { ProductEntity productData =
	 * productRepository.findById(id).orElseThrow(() -> new
	 * ResourceNotFoundException("User Not Found"));
	 * 
	 * productData.setName(productDto.getName());
	 * productData.setDescription(productDto.getDescription());
	 * productData.setPrice(productDto.getPrice());
	 * productData.setStatus(productDto.getStatus());
	 * 
	 * 
	 * }
	 */



	

	
	
	
}
