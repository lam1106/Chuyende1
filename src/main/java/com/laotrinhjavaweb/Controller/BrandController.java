package com.laotrinhjavaweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laotrinhjavaweb.repository.BrandRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class BrandController {
	
	@Autowired 
	private BrandRepository brandRepository;
	
	// Lấy dữ liệu hãng xe
	@GetMapping("/getALlBrand")
	public ResponseEntity<?> getALlBrand() throws Exception {
	    return ResponseEntity.ok(brandRepository.findAll());
	}
}
