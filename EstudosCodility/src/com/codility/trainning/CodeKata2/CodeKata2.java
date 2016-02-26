package com.codility.trainning.CodeKata2;

import java.math.BigDecimal;

/**
 * Created by rafael.alves on 15/02/2016.
 * Um caixa eletr?nico opera com alguns tipos de notas dispon?veis (R$ 50,00, R$ 20,00, R$ 10,00, R$ 5,00 e R$2,00),
 * mantendo um estoque de c?dulas para cada valor. Os clientes do banco, podem efetuar saques de um certo valor.
 * Escreva um programa que, dado o valor solicitado (v) pelo cliente, determine o n?mero de cada uma das notas necess?rio
 * para totalizar esse valor, de modo a minimizar a quantidade de c?dulas entregues.
 * Exemplo 1: Se o cliente deseja retirar R$ 50,00, basta entregar uma ?nica nota de cinquenta reais.
 * Exemplo 2: Se o cliente deseja retirar R$ 92,00, ? necess?rio entregar uma nota de R$50,00, duas de R$ 20,00 e uma de R$2,00.
 * Restri??es
 * 0 < v = 10000.
 * Estoque de notas: dever? se informado pelo QuantidadeNotaTO.
 */
public class CodeKata2 implements ICaixaEletronicoService {
    int notasCinco = 0;

    int notasCinquenta = 0;

    int notasDez = 0;

    int notasDois = 0;

    int notasVinte = 0;

    QuantidadeNotaTO numerNotaTO;

    public void contarNotas(QuantidadeNotaTO pQuantidadeNotas) {
	numerNotaTO = pQuantidadeNotas;
    }

    public boolean ehInteiro(BigDecimal pValor) {
	boolean ehInteiro = true;
	if (pValor.doubleValue() != pValor.intValue()) {
	    ehInteiro = false;
	}

	return ehInteiro;
    }

    public boolean possoProcessarNotasCinco(BigDecimal pValor) {
	boolean ehPermitidoNotasCinco;
	final boolean possuiNotaCinco = notasCinco > 0;
	notasCinco = pValor.intValue() / 5 <= numerNotaTO.getNotas5() ?
			pValor.intValue() / 5 :
			numerNotaTO.getNotas5();
	final boolean numeroNotasCincoEhImpar = verificarSeValorSaqueEhImpar(new BigDecimal(notasCinco));
	notasCinco = notasCinco > 1 && numeroNotasCincoEhImpar ? notasCinco - 1 : notasCinco;
	if ((pValor.intValue() - (notasCinco * 5)) % 2 == 0 && pValor.intValue() >= 5) {
	    ehPermitidoNotasCinco = true;
	} else {
	    ehPermitidoNotasCinco = false;
	}
	notasCinco = possuiNotaCinco ? 1 : 0;
	return ehPermitidoNotasCinco;
    }

    public QuantidadeNotaTO sacar(BigDecimal pValor) throws ImpossivelSacarException {
	notasDois = 0;
	notasCinco = 0;
	notasDez = 0;
	notasVinte = 0;
	notasCinquenta = 0;
	if (ehInteiro(pValor) && pValor.intValue() > 0) {
	    if (verificarSeValorSaqueEhImpar(pValor) && pValor.intValue() > 5) {
		if (numerNotaTO.getNotas5() > 0) {
		    pValor = pValor.subtract(BigDecimal.valueOf(5));
		    notasCinco = 1;
		}
	    }
	    pValor = sacarNotas50(pValor);
	    pValor = sacarNotas20(pValor);
	    pValor = sacarNotas10(pValor);
	    pValor = sacarNotas5(pValor);
	    pValor = sacarNotas2(pValor);
	} else {
	    throw new ImpossivelSacarException("Não foi possível efetuar o saque!!!");
	}

	if (pValor.intValue() != 0) {
	    throw new ImpossivelSacarException("Não foi possível efetuar o saque!!!");

	}
	QuantidadeNotaTO resultado = new QuantidadeNotaTO(notasDois, notasCinco, notasDez, notasVinte, notasCinquenta);
	return resultado;
    }

    public BigDecimal sacarNotas10(BigDecimal pValor) {
	notasDez = pValor.intValue() / 10 <= numerNotaTO.getNotas10() ? pValor.intValue() / 10 : numerNotaTO.getNotas10();
	pValor = BigDecimal.valueOf((pValor.intValue() - (notasDez * 10)));
	return pValor;
    }

    public BigDecimal sacarNotas2(BigDecimal pValor) {
	notasDois = pValor.intValue() / 2 <= numerNotaTO.getNotas2() ?
			(pValor.intValue() / 2) + notasDois :
			numerNotaTO.getNotas2();
	pValor = BigDecimal.valueOf((pValor.intValue() - (notasDois * 2)));
	return pValor;
    }

    public BigDecimal sacarNotas20(BigDecimal pValor) {
	notasVinte = pValor.intValue() / 20 <= numerNotaTO.getNotas20() ? pValor.intValue() / 20 : numerNotaTO.getNotas20();
	pValor = BigDecimal.valueOf((pValor.intValue() - (notasVinte * 20)));
	return pValor;
    }

    public BigDecimal sacarNotas5(BigDecimal pValor) {
	if (possoProcessarNotasCinco(pValor) && pValor.intValue() > 0) {
	    notasCinco = pValor.intValue() / 5 <= numerNotaTO.getNotas5() ?
			    notasCinco + pValor.intValue() / 5 :
			    numerNotaTO.getNotas5();
	    notasCinco = notasCinco > 1 && verificarSeValorSaqueEhImpar(new BigDecimal(notasCinco)) ? notasCinco - 1 : notasCinco;
	    pValor = BigDecimal.valueOf((pValor.intValue() - (notasCinco * 5)));
	}
	return pValor;
    }

    public BigDecimal sacarNotas50(BigDecimal pValor) {
	notasCinquenta = pValor.intValue() / 50 <= numerNotaTO.getNotas50() ? pValor.intValue() / 50 : numerNotaTO.getNotas50();
	final boolean ehMultiploVinte = pValor.subtract(BigDecimal.valueOf(notasCinquenta * 50)).intValue() % 20 == 0
			&& numerNotaTO.getNotas20() > 0;
	final boolean ehMultiploDez = pValor.subtract(BigDecimal.valueOf(notasCinquenta * 50)).intValue() % 10 == 0
			&& numerNotaTO.getNotas10() > 0;
	final boolean ehMultiploDois = pValor.subtract(BigDecimal.valueOf(notasCinquenta * 50)).intValue() % 2 == 0 && numerNotaTO.getNotas2()>0;
	if (ehMultiploDez || ehMultiploVinte || ehMultiploDois) {
	    pValor = BigDecimal.valueOf((pValor.intValue() - (notasCinquenta * 50)));
	} else {
	    notasCinquenta = 0;
	}
	return pValor;
    }

    public boolean verificarSeValorSaqueEhImpar(BigDecimal pValor) {
	boolean ehImpar = false;
	if (pValor.intValue() % 2 != 0) {
	    ehImpar = true;

	} else {
	    ehImpar = false;
	}
	return ehImpar;
    }

    public int verificarUltimoDigitoEhImpar(BigDecimal pValor) {
	String numero = Integer.toString(pValor.intValue());
	int ultimoNumero = Integer.parseInt(numero.substring(numero.length() - 1));
	return ultimoNumero;
    }
}