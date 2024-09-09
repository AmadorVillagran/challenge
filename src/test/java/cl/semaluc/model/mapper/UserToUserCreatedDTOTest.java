package cl.semaluc.model.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.semaluc.model.dto.UserCreatedDTO;
import cl.semaluc.model.entity.Phone;
import cl.semaluc.model.entity.User;

@ExtendWith(MockitoExtension.class)
public class UserToUserCreatedDTOTest {

	private UserToUserCreatedDTO userCreatedDTOMapper;

	@BeforeEach
	void setUp() {
		this.userCreatedDTOMapper = new UserToUserCreatedDTO();
	}

	@Test
	void should_return_mapped_attribute_token_from_User_to_UserCreatedDTO() {
		Date today = new Date();
		final Date expectedDate = today;
		final String expectedToken = "toketTest";
		
		User userMock = getUser(today);

		UserCreatedDTO res = this.userCreatedDTOMapper.execute(userMock);
		
		assertEquals(expectedToken, res.getToken());
		assertEquals(expectedDate, res.getCreated());
		assertEquals(expectedDate, res.getModified());
		assertEquals(expectedDate, res.getLastLogin());
	}

	private User getUser(Date today) {
		User user = new User();
		user.setEmail("test@test.com");
		user.setName("username");
		user.setPassword("pass");
		user.setPhones(getPhone());
		user.setToken("toketTest");
		user.setCreated(today);
		user.setModified(today);
		user.setLastLogin(today);
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
