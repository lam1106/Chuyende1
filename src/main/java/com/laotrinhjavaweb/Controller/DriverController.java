package com.laotrinhjavaweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.laotrinhjavaweb.repository.DriverRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	// Lấy tất cả thông tin tài xế
	@GetMapping("/getAllDriver")
	public ResponseEntity<?> getAllDriver() throws Exception {
	    return ResponseEntity.ok(driverRepository.findAll());
	}
	
	// Xóa tài xế
	@DeleteMapping("/deleteDriver/{id}")
	public ResponseEntity<?> deleteDriver(@PathVariable int id) throws Exception {
		driverRepository.deleteById(id);
	    return ResponseEntity.ok().build();
	}
}
