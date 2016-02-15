package com.codility.trainning.CodeKata2;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by rafael.alves on 15/02/2016.
 */
public class CodeKataTest {

    @Test(expected = ImpossivelSacarException.class)
    public void testeExcecao() throws Exception {
	CodeKata2 cK2 = new CodeKata2();
	QuantidadeNotaTO qtdNotas = new QuantidadeNotaTO(10, 10, 10, 10, 0);
	cK2.contarNotas(qtdNotas);
	cK2.sacar(BigDecimal.ONE);
    }

    @Test
    public void testePrimeiro() throws ImpossivelSacarException {
	CodeKata2 cK2 = new CodeKata2();
	QuantidadeNotaTO qtdNotas = new QuantidadeNotaTO(10, 10, 10, 10, 0);
	cK2.contarNotas(qtdNotas);
	QuantidadeNotaTO resultado = cK2.sacar(BigDecimal.valueOf(1));
	Assert.assertEquals("1,0,1,2,0", resultado.toString());
    }
}
