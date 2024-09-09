package cl.semaluc.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import cl.semaluc.datasource.UserRepository;
import cl.semaluc.model.dto.UserCreatedDTO;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.model.entity.User;
import cl.semaluc.model.mapper.UserDTOToUser;
import cl.semaluc.model.mapper.UserToUserCreatedDTO;

@Service
public class UserService {
	
	private final ValidateUser validateUser;

	private final UserRepository userRepository;
	private final JwtTokenGenerator tokenGenerator;
	
	private final UserToUserCreatedDTO toUserCreatedDTOMapper;
	private final UserDTOToUser toUserMapper;
	
	public UserService(ValidateUser validateUser,
			UserRepository userRepository, 
			JwtTokenGenerator tokenGenerator,
			UserToUserCreatedDTO toUserCreatedDTOMapper,
			UserDTOToUser toUserMapper) {
		this.validateUser = validateUser; 
		this.userRepository = userRepository;
		this.tokenGenerator = tokenGenerator;
		this.toUserCreatedDTOMapper = toUserCreatedDTOMapper;
		this.toUserMapper = toUserMapper;
	}


	public UserCreatedDTO createUser(UserDTO userDTO) {
		validateUser.execute(userDTO);
		User user = toUserMapper.execute(userDTO);
		setCreationAttributes(user);
		User userSaved = userRepository.save(user);
		return toUserCreatedDTOMapper.execute(userSaved);
	}
	
	private void setCreationAttributes(User user) {
		Date today = new Date();
		user.setCreated(today);
		user.setLastLogin(today);
		user.setModified(today);
		user.setActive(true);
		user.setToken(tokenGenerator.execute(user.getName()));
	}
}
