package cl.semaluc.exceptions;

public class EmailAlreadyRegisteredExpcetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegisteredExpcetion() {
		super("El correo ya está registrado");
	}

}
