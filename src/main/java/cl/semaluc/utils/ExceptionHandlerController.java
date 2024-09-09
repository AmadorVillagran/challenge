package cl.semaluc.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.semaluc.model.dto.NotificationErrorDTO;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(EmailAlreadyRegisteredExpcetion.class)
	public ResponseEntity<NotificationErrorDTO> handlerError(EmailAlreadyRegisteredExpcetion exception){
		NotificationErrorDTO notification = new NotificationErrorDTO();
		notification.setMessage(exception.getMessage());
		ResponseEntity<NotificationErrorDTO> response = new ResponseEntity<>(notification, HttpStatus.BAD_REQUEST);
		return response;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<NotificationErrorDTO> handlerError(MethodArgumentNotValidException exception){
		NotificationErrorDTO notification = new NotificationErrorDTO();
		notification.setMessage("Bad request, request body malformed");
		ResponseEntity<NotificationErrorDTO> response = new ResponseEntity<>(notification, HttpStatus.BAD_REQUEST);
		return response;
	}
	
	@ExceptionHandler(EmailExpcetion.class)
	public ResponseEntity<NotificationErrorDTO> handlerError(EmailExpcetion exception){
		NotificationErrorDTO notification = new NotificationErrorDTO();
		notification.setMessage(exception.getMessage());
		ResponseEntity<NotificationErrorDTO> response = new ResponseEntity<>(notification, HttpStatus.BAD_REQUEST);
		return response;
	}
}
