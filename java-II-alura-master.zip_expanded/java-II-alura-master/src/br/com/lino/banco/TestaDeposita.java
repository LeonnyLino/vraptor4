package br.com.lino.banco;

import br.com.lino.banco.conta.Conta;
import br.com.lino.banco.conta.ContaCorrente;
import br.com.lino.banco.conta.ValorInvalidoException;

public class TestaDeposita {
	public static void main(String[] args) {
		
		Conta conta = new ContaCorrente();
		try {
			conta.deposita(-100);
		} catch (ValorInvalidoException e) {
			System.err.println("Erro");
			System.err.println(e.getMessage());
		}
	}
}
