package cl.semaluc.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "phones")
public class Phone {

	@Id
	private String number;
	private String cityCode;
	private String contryCode;
	
}
