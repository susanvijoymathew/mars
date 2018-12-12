package com.mcd.mars.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mcd.mars.data.entity.Promotion;


public interface PromotionRepository extends CrudRepository<Promotion, Long> {
	public List<Promotion> findAll();
	public Promotion findById(long id);
	
	@Query(value="select * from promotion where start_date <= NOW() or end_date >= NOW()", nativeQuery=true)
	public List<Promotion> findAllActivePromotions();
	
	@Query(value="select * from promotion where start_date >= ?1 and end_date <= ?2", nativeQuery=true)
	public List<Promotion> findByStartAndEndDates(Date startDate, Date endDate);
	
	public List<Promotion> findByStartDateGreaterThanEqual(Date startDate);
	public List<Promotion> findByEndDateLessThanEqual(Date endDate);
}
