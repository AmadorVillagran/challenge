package cl.semaluc.model.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

	private UUID id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	private List<PhoneDTO> phones;
}
