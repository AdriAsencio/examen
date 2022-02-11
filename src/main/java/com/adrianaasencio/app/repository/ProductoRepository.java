package com.adrianaasencio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianaasencio.app.entity.producto;


public interface ProductoRepository extends JpaRepository<producto, Long>{

}
