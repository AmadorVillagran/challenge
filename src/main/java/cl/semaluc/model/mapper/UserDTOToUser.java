package cl.semaluc.model.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cl.semaluc.model.dto.PhoneDTO;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.model.entity.Phone;
import cl.semaluc.model.entity.User;

@Component
public class UserDTOToUser {

	public User execute(UserDTO userDTO) {
		User userEntity = new User();
		userEntity.setName(userDTO.getName());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPhones(userDTO.getPhones().stream().map(p -> mapPhone(p)).collect(Collectors.toList()));
		return userEntity;
	}
	
	private Phone mapPhone(PhoneDTO phoneDTO) {
		Phone phoneEntity = new Phone();
		phoneEntity.setCityCode(phoneDTO.getCityCode());
		phoneEntity.setContryCode(phoneDTO.getContryCode());
		phoneEntity.setNumber(phoneDTO.getNumber());
		return phoneEntity;
	}
}
