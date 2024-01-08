package com.laotrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laotrinhjavaweb.model.CarRental;

public interface CarRentalRepository extends JpaRepository<CarRental, Integer> {
	
	// Lấy dữ liệu xe thuê xe tự lái theo idUser
	@Query("SELECT c FROM CarRental c WHERE c.user.id = :idUser")
	List<CarRental> findByUserId(@Param("idUser") int idUser);
}
