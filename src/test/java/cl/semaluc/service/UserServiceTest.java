package cl.semaluc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.semaluc.datasource.UserRepository;
import cl.semaluc.model.dto.UserCreatedDTO;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.model.entity.User;
import cl.semaluc.model.mapper.UserDTOToUser;
import cl.semaluc.model.mapper.UserToUserCreatedDTO;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	private UserService service;
	
	@Mock private ValidateUser validateUser;

	@Mock private UserRepository userRepository;
	@Mock private JwtTokenGenerator tokenGenerator;
	
	@Mock private UserToUserCreatedDTO toUserCreatedDTOMapper;
	@Mock private UserDTOToUser toUserMapper;
	
	@BeforeEach
	void setUp() {
		this.service = new UserService(
				validateUser, 
				userRepository, 
				tokenGenerator, 
				toUserCreatedDTOMapper,
				toUserMapper);
	}
	
	@Test
	void should_return_an_created_user() {
		
		UserDTO userDTO = getUserDTOMock();
		User user = getUserMock();
		UserCreatedDTO userCreated = getUserCreatedDTOMock();
		
		doNothing().when(validateUser).execute(userDTO);
		when(toUserMapper.execute(userDTO)).thenReturn(user);
		when(userRepository.save(user)).thenReturn(user);
		when(toUserCreatedDTOMapper.execute(user)).thenReturn(userCreated);
		
		UserCreatedDTO res = service.createUser(userDTO);
		
		verify(toUserMapper, times(1)).execute(userDTO);
		verify(validateUser, times(1)).execute(userDTO);
		verify(userRepository, times(1)).save(user);
		verify(toUserCreatedDTOMapper, times(1)).execute(user);
		
		assertNotNull(res);
		assertEquals(UserCreatedDTO.class, res.getClass());
	}

	private UserCreatedDTO getUserCreatedDTOMock() {
		return new UserCreatedDTO();
	}

	private User getUserMock() {
		return new User();
	}

	private UserDTO getUserDTOMock() {
		return new UserDTO();
	}
}
