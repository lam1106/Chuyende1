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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laotrinhjavaweb.model.Car;
import com.laotrinhjavaweb.repository.CarRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	
	// Lấy tất cả dữ liệu xe
	@GetMapping("/getAllCar")
	public ResponseEntity<?> getALlCar() throws Exception {
	    return ResponseEntity.ok(carRepository.findAll());
	}
	
	// Thêm 1 xe 
	@PostMapping("/addCart")
	public ResponseEntity<?> addCart(@RequestBody Car car) throws Exception {
		LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedTime = currentTime.format(formatter);
        car.setDateCreate(formattedTime);
	    return ResponseEntity.ok(carRepository.save(car));
	}
	
	// Xóa xe theo id
	@DeleteMapping("/deleteCar/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable int id) throws Exception {
		carRepository.deleteById(id);
	    return ResponseEntity.ok().build();
	}
	
	// Lấy dữ liệu xe theo id
	@GetMapping("/getCarById/{id}")
	public ResponseEntity<?> getALlCar(@PathVariable int id) throws Exception {
	    return ResponseEntity.ok(carRepository.findById(id));
	}
	
}
