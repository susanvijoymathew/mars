package com.mcd.mars.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcd.mars.data.entity.Area;


public interface AreaRepository extends CrudRepository<Area, Long> {
	public List<Area> findAll();
	public Area findById(long id);
}
