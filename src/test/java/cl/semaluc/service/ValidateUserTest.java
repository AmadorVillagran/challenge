package cl.semaluc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.semaluc.datasource.UserRepository;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.model.entity.User;
import cl.semaluc.utils.EmailAlreadyRegisteredExpcetion;

@ExtendWith(MockitoExtension.class)
public class ValidateUserTest {
	
	private ValidateUser validateUser;
	@Mock
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		validateUser = new ValidateUser(userRepository);
	}
	
	@Test
	void should_throws_EmailAlreadyRegisteredExpcetion_when_user_email_is_present() {
		final String expectedMessage = "El correo ya está registrado";
		UserDTO userDTO = getUserDTOMock();
		Optional<User> optionaUser = Optional.of(getUserMock());
		
		when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(optionaUser);
		
		EmailAlreadyRegisteredExpcetion thrown = assertThrows(EmailAlreadyRegisteredExpcetion.class,
				()->validateUser.execute(userDTO));
		
		assertEquals(expectedMessage, thrown.getMessage());
	}

	private User getUserMock() {
		return new User();
	}

	private UserDTO getUserDTOMock() {
		return new UserDTO();
	}

}
