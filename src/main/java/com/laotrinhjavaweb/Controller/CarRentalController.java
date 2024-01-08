package com.laotrinhjavaweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laotrinhjavaweb.model.Car;
import com.laotrinhjavaweb.model.CarRental;
import com.laotrinhjavaweb.repository.CarRentalRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CarRentalController {
	@Autowired
	private CarRentalRepository carRentalRepository;
	
	// Đăng ký thuê xe
	@PostMapping("/addCarRental")
	public ResponseEntity<?> addCart(@RequestBody CarRental carRental) throws Exception {
	    return ResponseEntity.ok(carRentalRepository.save(carRental));
	}

	// Lâys dữ liệu thuê xe tự lái theo id người dùng
	@PostMapping("/findRentalById/{id}")
	public ResponseEntity<?> findRentalById(@PathVariable int id) throws Exception {
	    return ResponseEntity.ok(carRentalRepository.findByUserId(id));
	}
	
	// Xác nhận cho thuê
	@PostMapping("/updateStatus/{id}")
	public ResponseEntity<?> updateStatus(@PathVariable int id) throws Exception {
		CarRental carRental = carRentalRepository.getById(id);
		carRental.setStatus("YES");
	    return ResponseEntity.ok(carRentalRepository.save(carRental));
	}
	
	// Lâys tất cả danh sách thuê xe tự lái
	@GetMapping("/findAllRental")
	public ResponseEntity<?> findAllRental() throws Exception {
	    return ResponseEntity.ok(carRentalRepository.findAll());
	}
	
	// Xóa thuê xe tự lái
	@DeleteMapping("/deleteCarRental/{id}")
	public ResponseEntity<?> deleteCarRental(@PathVariable int id) throws Exception {
		carRentalRepository.deleteById(id);
	    return ResponseEntity.ok().build();
	}

}
