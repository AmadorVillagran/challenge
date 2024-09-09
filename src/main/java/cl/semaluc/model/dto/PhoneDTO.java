package cl.semaluc.model.dto;

import lombok.Data;

@Data
public class PhoneDTO {
	private String number;
	private String cityCode;
	private String contryCode;
}
