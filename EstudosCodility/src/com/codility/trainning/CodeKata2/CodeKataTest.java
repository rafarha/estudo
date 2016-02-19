package com.codility.trainning.CodeKata2;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by rafael.alves on 15/02/2016.
 */
public class CodeKataTest {

    @Test
    public void testeDarian() throws ImpossivelSacarException {
	CodeKata2 cK2 = new CodeKata2();
	QuantidadeNotaTO qtdNotas = new QuantidadeNotaTO(3, 2, 0, 0, 0);
	cK2.contarNotas(qtdNotas);
	QuantidadeNotaTO resultado = cK2.sacar(BigDecimal.valueOf(11));
	Assert.assertEquals("3,1,0,0,0", resultado.toString());
    }

    @Test(expected = ImpossivelSacarException.class)
    public void testeExcecao() throws Exception {
	CodeKata2 cK2 = new CodeKata2();
	QuantidadeNotaTO qtdNotas = new QuantidadeNotaTO(0, 0, 0, 0, 50);
	cK2.contarNotas(qtdNotas);
	cK2.sacar(BigDecimal.TEN);
    }

    @Test
    public void testeMaximo() throws ImpossivelSacarException {
	CodeKata2 cK2 = new CodeKata2();
	QuantidadeNotaTO qtdNotas = new QuantidadeNotaTO(750, 100, 100, 100, 100);
	cK2.contarNotas(qtdNotas);
	QuantidadeNotaTO resultado = cK2.sacar(BigDecimal.valueOf(10000));
	Assert.assertEquals("750,100,100,100,100", resultado.toString());
    }

    @Test
    public void testeNotaImpar() throws ImpossivelSacarException {
	CodeKata2 cK2 = new CodeKata2();
	QuantidadeNotaTO qtdNotas = new QuantidadeNotaTO(3, 1, 0, 0, 0);
	cK2.contarNotas(qtdNotas);
	QuantidadeNotaTO resultado = cK2.sacar(BigDecimal.valueOf(6));
	Assert.assertEquals("3,0,0,0,0", resultado.toString());
    }
}
