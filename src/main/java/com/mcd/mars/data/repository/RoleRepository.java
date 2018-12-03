package com.mcd.mars.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcd.mars.data.entity.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	public List<Role> findAll();
	public Role findById(long id);
}
