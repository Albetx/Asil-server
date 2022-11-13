package com.example.demo.authapi;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;

import java.net.URI;
import java.util.List;

import com.example.demo.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
	private final UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<User>getUserByEmail(@RequestParam(defaultValue = "test") String email){
		return ResponseEntity.ok().body(userService.getUser(email));
	}
	
	@PostMapping("/users/save")
	public ResponseEntity<User>saveUser(@RequestBody User user){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
//	@PostMapping("/role/save")
//	public ResponseEntity<Role>saveRole(@RequestBody Role role){
//		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/roles/save").toUriString());
//		return ResponseEntity.created(uri).body(userService.saveRole(role));
//	}
	
	@PostMapping("/role/setrole")
	public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getEmail(), form.getRoleName());
		return ResponseEntity.ok().build();
	}


}

@Data 
class RoleToUserForm{
	private String email;
	private String roleName;
}
