package com.adrianaasencio.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianaasencio.app.entity.producto;
import com.adrianaasencio.app.service.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody producto product){
		
		if(product.getCanti() <=0 || product.getPess() <=0 ) {
			return ResponseEntity.notFound().build();
		}else {
			int n1 = product.getCanti(); 
			float n2 = product.getPess();
			float total = n1*n2;
			product.setTotal(total);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(product));
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<?> read (@PathVariable(value="id")Long userId) {
		Optional<producto> oUser= productoService.findById(userId);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}	
	
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody producto userDetails, @PathVariable(value = "id") Long userId){
	Optional<producto> product = productoService.findById(userId);
	
		if(!product.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.coyProperties(userDetails,user.get()); copiar todo el objeto
		product.get().setDescri(userDetails.getDescri());
		product.get().setPess(userDetails.getPess());
		product.get().setCanti(userDetails.getCanti());
		int n11 = userDetails.getCanti(); 
		float n21 = userDetails.getPess();
		float total = n11*n21;
		product.get().setTotal(total);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(product.get()));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id") Long userId){
		
		if(!productoService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping
	public List<producto> readAll(){
		List<producto> productos= StreamSupport
			.stream(productoService.findAll().spliterator(), false)
			.collect(Collectors.toList());
		return productos;
	}
	

}
