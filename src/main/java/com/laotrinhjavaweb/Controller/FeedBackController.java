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

import com.laotrinhjavaweb.model.FeedBack;
import com.laotrinhjavaweb.model.User;
import com.laotrinhjavaweb.repository.FeedBackRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class FeedBackController {
	@Autowired 
	
	// Thêm feedback
	private FeedBackRepository feedBackRepository;
	@PostMapping("/addFeedBack")
	public ResponseEntity<?> addFeedBack(@RequestBody FeedBack feedBack) throws Exception {
		LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedTime = currentTime.format(formatter);
        feedBack.setDate(formattedTime);
	    return ResponseEntity.ok(feedBackRepository.save(feedBack));
	}
	
	@GetMapping("findAllFeedBack")
	public ResponseEntity<?> findAllFeedBack() throws Exception {
	    return ResponseEntity.ok(feedBackRepository.findAll());
	}
}
