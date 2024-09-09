package cl.semaluc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.semaluc.model.dto.UserCreatedDTO;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.service.UserService;
import jakarta.validation.Valid;

@RestController
public class CreateUserController {

	private final UserService userService;
	
	public CreateUserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/create-user")
	public ResponseEntity<UserCreatedDTO> execute(@Valid @RequestBody UserDTO user){	
		UserCreatedDTO userCreatedDTO = userService.createUser(user);
		return new ResponseEntity<>(userCreatedDTO, HttpStatus.CREATED);
	}
}
