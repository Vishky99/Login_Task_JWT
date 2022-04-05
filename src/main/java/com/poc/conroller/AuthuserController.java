package com.poc.conroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Authuser;
import com.poc.repository.AuthuserRepository;
import com.poc.service.AuthuserDetails;

@RestController
@RequestMapping("/auth")
public class AuthuserController {
	
	@Autowired
	private AuthuserRepository userRep;
	
	@GetMapping("/page")
	public String page() {
		return "Successfully Logged In !";
	}
	
	@GetMapping("/users")		//get all users
	public List<Authuser> getAuction(){
		return userRep.findAll();
	}
	
	@GetMapping("/info")		//get current logged in user
	public Optional<Authuser> getCurrentUser() {
		return userRep.findById(AuthuserDetails.getUser().getId());
	}

}
