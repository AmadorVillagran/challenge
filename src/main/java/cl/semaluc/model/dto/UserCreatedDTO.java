package cl.semaluc.model.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class UserCreatedDTO {
		private UUID id;
		private String name;
		private String token;
		private boolean isactive;
		private Date created;
		private Date modified;
		private Date lastLogin;
}
