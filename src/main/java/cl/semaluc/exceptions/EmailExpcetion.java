package cl.semaluc.exceptions;

public class EmailExpcetion  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EmailExpcetion() {
		super("Formato de correo electrónico inválido");
	}
}
