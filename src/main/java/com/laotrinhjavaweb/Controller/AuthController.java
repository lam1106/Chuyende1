package com.laotrinhjavaweb.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.laotrinhjavaweb.model.User;
import com.laotrinhjavaweb.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	// Xử lý đăng nhập
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws Exception {
	    User data = userRepository.findByUsername(user.getUsername());
	    if (data != null && user.getPassword().equals(data.getPassword())) {
	        return ResponseEntity.ok(data);
	    } 
	    return ResponseEntity.badRequest().body(data);
	}
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) throws Exception {
	    User data = userRepository.findByUsername(user.getUsername());
	    if (data == null ) { 
	    	user.setRole("ROLE_USER");
			LocalDateTime currentTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedTime = currentTime.format(formatter);
	        user.setCreation_date(formattedTime);
	    	userRepository.save(user);
	        return ResponseEntity.ok(data);
	    } 
	    return ResponseEntity.badRequest().body(data);
	}
	
}
