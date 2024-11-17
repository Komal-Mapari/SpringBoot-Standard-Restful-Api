package com.cjc.app.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.model.Product;
import com.cjc.app.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping(value = "/products",
			consumes ={"application/json"},
		     produces = {"application/json"})
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product pro = productService.addProduct(product);
		
		return new ResponseEntity<Product>(pro,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/products",
			produces = {"application/json"})
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> proList=productService.getAllProcduct();
		
		return new ResponseEntity<List<Product>>(proList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/products/{id}",
			produces = {"application/json"})
	public ResponseEntity<Product> getProduct(@PathVariable ("id") int id) {
		Product product = productService.getProduct(id);
		
		if(product != null) {
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable ("id") int id){
		
		Boolean flag = productService.deleteProduct(id);
		
		if(flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/products/{id}",
			consumes ={"application/json"},
			produces = {"application/json"})
	public ResponseEntity<Product> updateProduct(@PathVariable ("id")int id, @RequestBody Product product){
		Product updatedProduct = productService.updateProduct(id,product);
		
		if(updatedProduct != null) {
			return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
		}
		
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping(value = "/products/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable int id,@RequestBody Product product){
		Product pro = productService.editProduct(id,product);
		
		if(pro!=null) {
			return new ResponseEntity<Product>(pro,HttpStatus.OK);
		}
		
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
}
