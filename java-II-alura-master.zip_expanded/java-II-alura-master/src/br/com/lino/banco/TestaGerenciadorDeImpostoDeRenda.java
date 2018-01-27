package br.com.lino.banco;

import br.com.alura.java2.modelos.SeguroDeVida;
import br.com.alura.java2.sistema.GerenciadorDeImpostoDeRenda;
import br.com.lino.banco.conta.ContaCorrente;
import br.com.lino.banco.conta.ValorInvalidoException;

public class TestaGerenciadorDeImpostoDeRenda {
	public static void main(String[] args) {

		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();

		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);

		ContaCorrente cc = new ContaCorrente();
		try {
			cc.deposita(1000);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		gerenciador.adiciona(cc);

		System.out.printf("O total é: %.2f", gerenciador.getTotal());
	}
}
