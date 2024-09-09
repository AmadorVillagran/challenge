package cl.semaluc.model.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.semaluc.model.dto.PhoneDTO;
import cl.semaluc.model.dto.UserDTO;
import cl.semaluc.model.entity.Phone;
import cl.semaluc.model.entity.User;

@ExtendWith(MockitoExtension.class)
public class UserDTOToUserTest {
	
	private UserDTOToUser userDTOToUserMapper;
	
	@BeforeEach
	void setUp() {
		this.userDTOToUserMapper = new UserDTOToUser();
	}
	
	@Test
	void shoudl_map_attributed_passed_into_UserDTO_to_User() {
		User expectedUser = getUser();
		
		UserDTO userDTO = getUserDTOMock();
		
		User res = userDTOToUserMapper.execute(userDTO);
		
		assertEquals(expectedUser.getName(),res.getName());
		assertEquals(expectedUser.getEmail(),res.getEmail());
		assertEquals(expectedUser.getPassword(),res.getPassword());
		
		for(int i = 0; i < expectedUser.getPhones().size(); i++) {
			assertEquals(expectedUser.getPhones().get(i).getNumber(),res.getPhones().get(i).getNumber());
			assertEquals(expectedUser.getPhones().get(i).getContryCode(),res.getPhones().get(i).getContryCode());
			assertEquals(expectedUser.getPhones().get(i).getCityCode(),res.getPhones().get(i).getCityCode());

		}

	}

	private UserDTO getUserDTOMock() {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("test@test.com");
		userDTO.setName("username");
		userDTO.setPassword("pass");
		userDTO.setPhones(getPhoneDTO());
		return userDTO;
	}

	private List<PhoneDTO> getPhoneDTO() {
		List<PhoneDTO> phoneList = new ArrayList<>();
		PhoneDTO phone1 = new PhoneDTO();
		phone1.setNumber("testNumber");
		phone1.setContryCode("contryCodeTest");
		phone1.setCityCode("cityCodeTest");
		phoneList.add(phone1);
		return phoneList;
	}
	
	private User getUser() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setName("username");
		user.setPassword("pass");
		user.setPhones(getPhone());
		return user;
	}

	private List<Phone> getPhone() {
		List<Phone> phoneList = new ArrayList<>();
		Phone phone1 = new Phone();
		phone1.setNumber("testNumber");
		phone1.setContryCode("contryCodeTest");
		phone1.setCityCode("cityCodeTest");
		phoneList.add(phone1);
		return phoneList;
	}
}
