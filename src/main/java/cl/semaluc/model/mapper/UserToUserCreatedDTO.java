package cl.semaluc.model.mapper;

import org.springframework.stereotype.Component;

import cl.semaluc.model.dto.UserCreatedDTO;
import cl.semaluc.model.entity.User;

@Component
public class UserToUserCreatedDTO {
	public UserCreatedDTO execute(User user) {
		UserCreatedDTO userCreated = new UserCreatedDTO();
		userCreated.setId(user.getId());
		userCreated.setName(user.getName());
		userCreated.setCreated(user.getCreated());
		userCreated.setModified(user.getModified());
		userCreated.setLastLogin(user.getLastLogin());
		userCreated.setIsactive(user.isActive());
		userCreated.setToken(user.getToken());
		return userCreated;
	}
}
