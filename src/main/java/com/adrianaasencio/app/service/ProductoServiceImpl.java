package com.adrianaasencio.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrianaasencio.app.entity.producto;
import com.adrianaasencio.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<producto> findAll(Pageable pageable) {
		return productoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<producto> findById(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	@Transactional
	public producto save(producto product) {
		return productoRepository.save(product);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
		
	}

}
