package com.mcd.mars.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcd.mars.data.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {
	public List<Product> findAll();
	public Product findById(long id);
}
