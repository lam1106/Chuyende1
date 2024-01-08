package com.laotrinhjavaweb.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laotrinhjavaweb.model.User;
import com.laotrinhjavaweb.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	// Lấy tất cả dữ liệu user và gán mật khẩu bằng null
	@GetMapping("/getAllUSer")
	public ResponseEntity<?> getALlCar() throws Exception {
		List<User> list = userRepository.findAll();
		List<User> response = new ArrayList<User>();
		for (User user : list) {
		    user.setPassword(null);
		    response.add(user);
		}
	    return ResponseEntity.ok(response);
	}
	
	// Xóa user theo id
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable int id) throws Exception {
		userRepository.deleteById(id);
	    return ResponseEntity.ok().build();
	}
	
	//Sửa user
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user) throws Exception {
		User data = userRepository.findByUsername(user.getUsername());
		data.setUsername(user.getUsername());
		data.setName(user.getName());
		if (user.getPassword()!="") {
			data.setPassword(user.getPassword());
		}
		userRepository.save(data);
	    return ResponseEntity.ok().build();
	}
}
