package com.codility.trainning.CodeKata2;

import java.math.BigDecimal;

/**
 * Created by rafael.alves on 15/02/2016.
 * Um caixa eletrônico opera com alguns tipos de notas disponíveis (R$ 50,00, R$ 20,00, R$ 10,00, R$ 5,00 e R$2,00),
 * mantendo um estoque de cédulas para cada valor. Os clientes do banco, podem efetuar saques de um certo valor.
 * Escreva um programa que, dado o valor solicitado (v) pelo cliente, determine o número de cada uma das notas necessário
 * para totalizar esse valor, de modo a minimizar a quantidade de cédulas entregues.
 * Exemplo 1: Se o cliente deseja retirar R$ 50,00, basta entregar uma única nota de cinquenta reais.
 * Exemplo 2: Se o cliente deseja retirar R$ 92,00, é necessário entregar uma nota de R$50,00, duas de R$ 20,00 e uma de R$2,00.
 * Restrições
 * 0 < v = 10000.
 * Estoque de notas: deverá se informado pelo QuantidadeNotaTO.
 */
public class CodeKata2 implements ICaixaEletronicoService {
    QuantidadeNotaTO numerNotaTO;

    public void contarNotas(QuantidadeNotaTO pQuantidadeNotas) {
	this.numerNotaTO = pQuantidadeNotas;
    }

    public QuantidadeNotaTO sacar(BigDecimal pValor) throws ImpossivelSacarException {
	BigDecimal restoDivisao = pValor;
	BigDecimal valorDividido = new BigDecimal(0);
	BigDecimal[] vetRetorno = new BigDecimal[2];
	int notasCinquenta = 0;
	int notasVinte = 0;
	int notasDez = 0;
	int notasCinco = 0;
	int notasDois = 0;
	if (restoDivisao.doubleValue() >= 50) {
	    vetRetorno = restoDivisao.divideAndRemainder(new BigDecimal(50));
	    valorDividido = vetRetorno[0];
	    if (valorDividido.intValue() <= numerNotaTO.getNotas50()) {
		restoDivisao = vetRetorno[1];
		notasCinquenta = notasCinquenta + valorDividido.intValue();
	    } else {
		restoDivisao.subtract(BigDecimal.valueOf((50 * numerNotaTO.getNotas50())));
	    }
	}
	if (restoDivisao.doubleValue() >= 20) {
	    vetRetorno = restoDivisao.divideAndRemainder(new BigDecimal(20));
	    valorDividido = vetRetorno[0];
	    if (valorDividido.intValue() <= numerNotaTO.getNotas20()) {
		restoDivisao = vetRetorno[1];
		notasVinte = notasCinquenta + valorDividido.intValue();
	    } else {
		restoDivisao.subtract(BigDecimal.valueOf((20 * numerNotaTO.getNotas20())));
	    }
	}
	if (restoDivisao.doubleValue() >= 10) {
	    vetRetorno = restoDivisao.divideAndRemainder(new BigDecimal(10));
	    valorDividido = vetRetorno[0];
	    if (valorDividido.intValue() <= numerNotaTO.getNotas10()) {
		restoDivisao = vetRetorno[1];
		notasDez = notasDez + valorDividido.intValue();
	    } else {
		restoDivisao.subtract(BigDecimal.valueOf((10 * numerNotaTO.getNotas10())));
	    }
	}
	if (restoDivisao.doubleValue() >= 5) {
	    vetRetorno = restoDivisao.divideAndRemainder(new BigDecimal(5));
	    valorDividido = vetRetorno[0];
	    if (valorDividido.intValue() <= numerNotaTO.getNotas5()) {
		restoDivisao = vetRetorno[1];
		notasCinco = notasCinco + valorDividido.intValue();
	    } else {
		restoDivisao.subtract(BigDecimal.valueOf((5 * numerNotaTO.getNotas5())));
	    }
	}
	if (restoDivisao.doubleValue() >= 2) {
	    vetRetorno = restoDivisao.divideAndRemainder(new BigDecimal(2));
	    valorDividido = vetRetorno[0];
	    if (valorDividido.intValue() <= numerNotaTO.getNotas2()) {
		restoDivisao = vetRetorno[1];
		notasDois = notasDois + valorDividido.intValue();
	    } else {
		restoDivisao.subtract(BigDecimal.valueOf((2 * numerNotaTO.getNotas2())));
	    }
	}
	if (restoDivisao.intValue() != 0) {
	    throw new ImpossivelSacarException("Não foi possível efetuar o saque!");

	}
	QuantidadeNotaTO resultado = new QuantidadeNotaTO(notasDois, notasCinco, notasDez, notasVinte, notasCinquenta);
	return resultado;
    }

}
