package cl.semaluc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cl.semaluc.datasource.UserRepository;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.utils.EmailAlreadyRegisteredExpcetion;
import cl.semaluc.utils.EmailExpcetion;

@Service
public class ValidateUser {
	
	@Value("${validation.email.regex}")
    private String emailRegex;
	
	private final UserRepository userRepository;

	public ValidateUser(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void execute (UserDTO userDTO) {
		if(userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
			throw new EmailAlreadyRegisteredExpcetion();
		}
		if(!userDTO.getEmail().matches(emailRegex)) {
			throw new EmailExpcetion();
		}
	}
}
