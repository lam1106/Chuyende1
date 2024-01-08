package com.laotrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.laotrinhjavaweb.model.ChauffeurService;

public interface ChauffeurServiceRepository extends JpaRepository<ChauffeurService, Integer> {
	
	// Lấy dữ liệu từ bảng thuê xe có tài xế có idUser = idUser
	@Query("SELECT c FROM ChauffeurService c WHERE c.user.id = :idUser")
	List<ChauffeurService> findByUserId(@Param("idUser") int idUser);
}
