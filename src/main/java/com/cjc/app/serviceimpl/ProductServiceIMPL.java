package com.cjc.app.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cjc.app.model.Product;
import com.cjc.app.repository.ProductRepository;
import com.cjc.app.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService{

	private ProductRepository productRepository;

	public ProductServiceIMPL(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	@Override
	public List<Product> getAllProcduct() {
		 
		return productRepository.findAll();
	}
	
	@Override
	public Product getProduct(int id) {
		
		if(productRepository.existsById(id)) {
			return productRepository.findById(id).get();
		}
		return null;
	}
	
	@Override
	public Boolean deleteProduct(int id) {
	     if(productRepository.existsById(id)) {
	    	  productRepository.deleteById(id);
	    	  return true;
	     }
		return false;
	}
	
	@Override
	public Product updateProduct(int id, Product product) {
		
		if(productRepository.existsById(id)) {
			product.setProductId(id);
			return productRepository.save(product);
		}
		return null;
	}

	@Override
	public Product editProduct(int id, Product product) {
		if(productRepository.existsById(id)) {
			Product exitsingProduct = productRepository.findById(id).get();
			
			if(product.getProductName()!=null) {
				exitsingProduct.setProductName(product.getProductName());
			}
			
			if(product.getProductPrice()!=null) {
				exitsingProduct.setProductPrice(product.getProductPrice());
			}
			
			if(product.getProductType()!=null) {
				exitsingProduct.setProductType(product.getProductType());
			}
			if(product.getProductColor()!=null) {
				exitsingProduct.setProductColor(product.getProductColor());
			}
			
			return productRepository.save(exitsingProduct);
		}
		return null;
	}
}
