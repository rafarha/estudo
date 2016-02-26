package com.codility.trainning.CodeKata2;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eml on 15/02/16.
 */
public class CaixaEletronicoServiceTest {

    @Test
    public void testEncontrarTestTable() throws IOException {
	final CodeKata2 service = new CodeKata2();
	// leio o arquivo texto, e transformo-o em uma lista de strings
	final List<String> linhasTestTable = ConstantsCodekata.obterCenariosTestTable(this.getClass());
	// os erro ser�o adicionados nessa lista
	final List<String> erros = new ArrayList<String>();
	for (String linhaTxt : linhasTestTable) {
	    final String[] linha = StringUtils.splitPreserveAllTokens(linhaTxt.substring(1, linhaTxt.length() - 1), '|');

	    final String cenario = linha[0];
	    final String[] estoque = StringUtils.splitPreserveAllTokens(linha[1], ';');
	    final String valor = linha[2];
	    final String resultadoEsperado = linha[3];
	    final Integer quantNotasEsperadas = new Integer(0 + linha[4]);

	    service.contarNotas(new QuantidadeNotaTO(new Integer(estoque[4]), new Integer(estoque[3]), new Integer(estoque[2]),
			    new Integer(estoque[1]), new Integer(estoque[0])));

	    final boolean erroEsperado = "ERRO".equals(resultadoEsperado) ? true : false;
	    try {

		final BigDecimal valorInformado = new BigDecimal(valor);
		final QuantidadeNotaTO notas = service.sacar(valorInformado);

		if (erroEsperado) {
		    erros.add("Cenario " + cenario + " falhou: pois um erro era esperado (Dados no cenario: " + linhaTxt + ")");
		    System.out.println("Cen�rio " + cenario + ": falhou!");
		    continue;
		}

		if (!quantNotasEsperadas.equals(notas.getQuantidadeNotas())) {
		    erros.add("Cenario " + cenario + " falhou: quantidade de notas esperado (" + quantNotasEsperadas
				    + "), n�o corresponde a quantidade retornada (" + notas.getQuantidadeNotas()
				    + "). As notas dispensadas foram: " + notas.toString() + ". (Dados no cenario: " + linhaTxt
				    + ")");
		    System.out.println("Cen�rio " + cenario + ": falhou!");
		    continue;
		}

		if (valorInformado.compareTo(notas.getValorTotal()) != 0) {
		    erros.add("Cenario " + cenario + " falhou: Valor dispensado pelo caixa eletr�nico (" + notas.getValorTotal()
				    + ") n�o corresponde ao valor solicitado pelo usuario (" + valorInformado + ").");
		    System.out.println("Cen�rio " + cenario + ": falhou!");
		    continue;
		}
		if (!resultadoEsperado.equals(notas.toString())) {
		    erros.add("Cenario " + cenario + " falhou: Esperado (" + resultadoEsperado + "), mas retornado (" + notas
				    .toString() + ")");
		    System.out.println("Cen�rio " + cenario + ": falhou!");
		    continue;
		}
	    } catch (Throwable e) {
		if (!erroEsperado) {
		    erros.add("Cenario " + cenario + " falhou: pois NAO era esperado erro neste cenario (Dados no cenario: "
				    + linhaTxt + "). Erro lancado: " + e.getMessage());
		    System.out.println("Cen�rio " + cenario + ": falhou!");
		    continue;
		}
	    }
	    System.out.println("Cen�rio " + cenario + ": ok!");
	}

	// se lista de erros contiver algum item, ent�o falho o teste e exibo os erros.
	if (!erros.isEmpty()) {
	    Assert.fail("Os Seguintes cenarios de teste falharam: \n" + StringUtils.join(erros, "\n"));
	}
    }

    @Test
    public void testSacar() throws Exception {

	final CodeKata2 caixaEletronico = new CodeKata2();

	caixaEletronico.contarNotas(new QuantidadeNotaTO(10, 10, 10, 10, 10));

	QuantidadeNotaTO saque = caixaEletronico.sacar(new BigDecimal(50));
	Assert.assertEquals("1;0;0;0;0", saque.toString());

	saque = caixaEletronico.sacar(new BigDecimal(10));
	Assert.assertEquals("0;0;1;0;0", saque.toString());

	saque = caixaEletronico.sacar(new BigDecimal(15));
	Assert.assertEquals("0;0;1;1;0", saque.toString());

	saque = caixaEletronico.sacar(new BigDecimal(92));
	Assert.assertEquals("1;2;0;0;1", saque.toString());

	saque = caixaEletronico.sacar(new BigDecimal(35));
	Assert.assertEquals("0;1;1;1;0", saque.toString());

	saque = caixaEletronico.sacar(new BigDecimal(57));
	Assert.assertEquals("1;0;0;1;1", saque.toString());

    }

    @Test(expected = ImpossivelSacarException.class)
    public void testSacarValorInvalido_Centavos() throws Exception {

	final CodeKata2 caixaEletronico = new CodeKata2();
	caixaEletronico.contarNotas(new QuantidadeNotaTO(10, 10, 10, 10, 10));

	caixaEletronico.sacar(new BigDecimal("50.15"));
    }

    @Test(expected = ImpossivelSacarException.class)
    public void testSacarValorInvalido_ValorNaoSuportado3() throws Exception {
	CodeKata2 cK2 = new CodeKata2();
	cK2.contarNotas(new QuantidadeNotaTO(10, 10, 10, 10, 0));
	cK2.sacar(BigDecimal.ONE);
    }

}
