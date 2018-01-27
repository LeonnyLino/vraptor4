package br.com.lino.banco.conta;

@SuppressWarnings("serial")
public class ValorInvalidoException extends RuntimeException{

	public ValorInvalidoException(double valor) {
		super("Valor inválido: " + valor);
	}

}
