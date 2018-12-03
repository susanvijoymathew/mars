package com.mcd.mars.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mcd.mars.data.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
	public List<User> findAll();
	public User findById(long id);
	
	@Query(value="SELECT * FROM User_Details", nativeQuery=true)
	public List<User> findWithNativeQuery();
}
