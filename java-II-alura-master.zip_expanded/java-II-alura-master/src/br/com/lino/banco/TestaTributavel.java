package br.com.lino.banco;

import br.com.alura.java2.modelos.Tributavel;
import br.com.lino.banco.conta.ContaCorrente;
import br.com.lino.banco.conta.ValorInvalidoException;

public class TestaTributavel {
	public static void main(String[] args) {

		ContaCorrente cc = new ContaCorrente();
        try {
			cc.deposita(100);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
        System.out.println(cc.calculaTributos());

        // testando polimorfismo:
        Tributavel t = cc;
        System.out.println(t.calculaTributos());
	}
}
