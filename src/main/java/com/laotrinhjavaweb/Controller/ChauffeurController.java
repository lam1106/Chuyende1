package com.laotrinhjavaweb.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laotrinhjavaweb.model.CarRental;
import com.laotrinhjavaweb.model.ChauffeurService;
import com.laotrinhjavaweb.repository.ChauffeurServiceRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ChauffeurController {
	
	@Autowired
	private ChauffeurServiceRepository chauffeurServiceRepository;
	
	// Thuê xe có tài xế
	@PostMapping("/addChauffeurService")
	public ResponseEntity<?> addChauffeurService(@RequestBody ChauffeurService chauffeurService) throws Exception {
		if(chauffeurService.getDriver().getId()==0) {
			return ResponseEntity.notFound().build();
		}
	    return ResponseEntity.ok(chauffeurServiceRepository.save(chauffeurService));
	}
	// Xác nhận cho thuê xe có tài xế
	@PostMapping("/updateStatusDriver/{id}")
	public ResponseEntity<?> updateStatus(@PathVariable int id) throws Exception {
		ChauffeurService chauffeurService = chauffeurServiceRepository.getById(id);
		chauffeurService.setStatus("YES");
	    return ResponseEntity.ok(chauffeurServiceRepository.save(chauffeurService));
	}
	
	// Lấy dữ liệu thuê xe có tài xế theo idUser
	@PostMapping("/findChauffeurService/{id}")
	public ResponseEntity<?> findChauffeurService(@PathVariable int id) throws Exception {
	    return ResponseEntity.ok(chauffeurServiceRepository.findByUserId(id));
	}
	
	@GetMapping("/findAllChauffeurService")
	public ResponseEntity<?> findAllChauffeurService() throws Exception {
	    return ResponseEntity.ok(chauffeurServiceRepository.findAll());
	}
	
	// Xóa dữ liệu thuê xe có tài xế
	@DeleteMapping("/deleteChauffeurService/{id}")
	public ResponseEntity<?> deleteCarRental(@PathVariable int id) throws Exception {
		chauffeurServiceRepository.deleteById(id);
	    return ResponseEntity.ok().build();
	}
}
