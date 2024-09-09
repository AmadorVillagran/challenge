package cl.semaluc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.semaluc.model.dto.UserCreatedDTO;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.service.UserService;

@ExtendWith(MockitoExtension.class)
public class CreateUserControllerTest {
	
	private CreateUserController createUserController;
	@Mock
	private UserService userService;
	
	@BeforeEach
	void setUp() {
		this.createUserController = new CreateUserController(this.userService);
	}

	
	@Test 
	void should_return_201_OK_when_creteUser_is_execute() {
		final HttpStatus expectedHttpStatus = HttpStatus.CREATED;
		
		UserDTO userDTO = userDtoMock();
		UserCreatedDTO userCreatedDTO = userCreatedDTOMock();
		
		when(this.userService.createUser(userDTO)).thenReturn(userCreatedDTO);
		
		ResponseEntity<UserCreatedDTO> res = createUserController.execute(userDTO);
		
		assertEquals(expectedHttpStatus, res.getStatusCode());
	}


	private UserCreatedDTO userCreatedDTOMock() {
		return new UserCreatedDTO();
	}


	private UserDTO userDtoMock() {
		return new UserDTO();
	}
}
