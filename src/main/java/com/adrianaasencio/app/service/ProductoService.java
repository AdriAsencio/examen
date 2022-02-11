package com.adrianaasencio.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.adrianaasencio.app.entity.producto;



public interface ProductoService {

	public Iterable<producto> findAll();
	
	public Page<producto> findAll(Pageable pageable);
	
	public Optional<producto> findById(Long id);
	
	public producto save (producto product);
	
	public void deleteById (Long id);
}
