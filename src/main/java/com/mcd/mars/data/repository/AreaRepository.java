package com.mcd.mars.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcd.mars.data.entity.Area;


public interface AreaRepository extends CrudRepository<Area, Long> {
	public List<Area> findAll();
	public Area findById(long id);
	/*
	@Query(value="select * from area where Name = ?1", nativeQuery=true)
	public List<Area> findByName(String name);
	
	@Query(value="select * from area where Type = ?1", nativeQuery=true)
	public List<Area> findByType(String type);
	
	@Query(value="select * from area where parent = ?1", nativeQuery=true)
	public List<Area> getChildren(long id);
	
	@Query(value="select * from area where parent = (select id from area where name = ?1)", nativeQuery=true)
	public List<Area> getChildren(String areaName);
	*/
}
