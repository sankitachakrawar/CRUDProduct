package com.crud.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.dto.ProductDto;
import com.crud.entity.ProductEntity;
import com.crud.exceptionsHandling.ResourceNotFoundException;
import com.crud.service.ProductServiceInterface;
import com.crud.utils.ErrorResponseDto;
import com.crud.utils.SuccessResponseDto;


@RestController
//@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceInterface productServiceInterface;
	
	@GetMapping("/products")
	public @ResponseBody List<ProductEntity> getAllProducts()throws Exception{
		return productServiceInterface.getAllProducts();
		
	}
	
	@SuppressWarnings({ "unchecked" })
	@PostMapping("/products")
	public ResponseEntity<ProductEntity> addProduct(@Validated @RequestBody ProductEntity productDetail) {
		
		return new ResponseEntity<>(productServiceInterface.addProduct(productDetail),HttpStatus.CREATED);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/products/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") Long id){
		try {
		
			ProductEntity product=productServiceInterface.findById(id);
			return new ResponseEntity(new SuccessResponseDto("Success", "success", product), HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			
			return new ResponseEntity(new ErrorResponseDto(e.getMessage(), "roleNotFound"), HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@DeleteMapping("/products/{id}")
	public Map<String, String> deleteProductById(@PathVariable("id")Long id) throws Exception {
		ProductEntity product = productServiceInterface.findById(id); 
		
		if (product != null) { 
			productServiceInterface.deleteProduct(id); 
			return Collections.singletonMap("success", "Record Deleted Successfully");
		} else {
			return Collections.singletonMap("fail", "Something is wrong");
		}

	}
	
	  
	
	/*
	 * @PutMapping("/products/{id}") public ResponseEntity<ProductEntity>
	 * updateProductById(@PathVariable("id") Long id, @RequestBody ProductEntity
	 * product) throws ResourceNotFoundException{ ProductEntity
	 * productEntity=productServiceInterface.findById(id);
	 * 
	 * productEntity.setName(product.getName());
	 * productEntity.setDescription(product.getDescription());
	 * productEntity.setPrice(product.getPrice());
	 * productEntity.setStatus(product.getStatus());
	 * 
	 * 
	 * 
	 * ProductEntity productsEntity2 =
	 * productServiceInterface.addProduct(productEntity); return
	 * ResponseEntity.ok().body(productsEntity2);
	 * 
	 * }
	 */
	


	
}
