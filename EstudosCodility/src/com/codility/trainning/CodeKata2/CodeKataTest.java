package com.codility.trainning.CodeKata2;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by rafael.alves on 15/02/2016.
 */
public class CodeKataTest extends TestCase {
    @Test
    public void testePrimeiro() throws ImpossivelSacarException {
	CodeKata2 cK2 = new CodeKata2();
	QuantidadeNotaTO qtdNotas = new QuantidadeNotaTO(10, 10, 10, 10, 0);
	cK2.contarNotas(qtdNotas);
	QuantidadeNotaTO resultado = cK2.sacar(BigDecimal.valueOf(1));
	assertEquals("Não foi possível Efetuar o saque", 0, resultado.getNotas50().intValue());
    }
}
