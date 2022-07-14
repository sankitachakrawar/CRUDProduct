package com.crud.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.ChangePasswordDto;

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
	 * @Override public void changePassword(Long userId, ChangePasswordDto userBody,
	 * HttpServletRequest request) throws ResourceNotFoundException {
	 * 
	 * ProductEntity userData =
	 * productRepository.findByIdAndIsActiveTrue(userId).orElseThrow(() -> new
	 * ResourceNotFoundException("User Not Found")); final String requestTokenHeader
	 * = request.getHeader("Authorization"); String username = null; String jwtToken
	 * = null; JsonObject jsonObj = null; jwtToken =
	 * requestTokenHeader.substring(7); username =
	 * jwtTokenUtil.getEmailFromToken(jwtToken); jsonObj =
	 * JsonParser.parseString(username).getAsJsonObject(); UserDataDto userDatas =
	 * new UserDataDto(); userDatas.setUserId((jsonObj.get("id").getAsLong()));
	 * 
	 * if (userDatas.getUserId() == userData.getId()) {
	 * 
	 * if (!bcryptEncoder.matches(userBody.getNewPassword(),
	 * userData.getPassword())) {
	 * 
	 * System.out.println("." + userBody.getNewPassword()); System.out.println("." +
	 * userBody.getPassword()); System.out.println("." +
	 * bcryptEncoder.encode((userBody.getPassword())));
	 * 
	 * if (bcryptEncoder.matches(userBody.getPassword(), userData.getPassword())) {
	 * 
	 * userData.setPassword(bcryptEncoder.encode(userBody.getNewPassword()));
	 * System.out.println("New Password" + userData.getPassword());
	 * 
	 * } else {
	 * 
	 * throw new ResourceNotFoundException("Please enter old password correct");
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * throw new
	 * ResourceNotFoundException("password must be differ from old password");
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * throw new ResourceNotFoundException("Access Denied");
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

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
