package model.exceptions;

public class DomainException extends Exception { 
	private static final long serialVersionUID = 1L;
	//Posso utilizar também o RunTimeExeption, que me trás a possibilidade de não tratar as exceções (try/catch)
	// no meu código fonte
	// Porém se der alguma exceção que não foi tratada (try/catch) 
	// ou propagada (throws DomainException) o programa quebra.
	
	public DomainException(String msg) {
		super(msg);
	}

}
