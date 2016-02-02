package com.codility.trainning.CodeKata;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by rafael.alves on 29/01/2016.
 */
public class CodeKataTest extends TestCase {
    @Test
    public void testeBasico() {
        PosicaoTO pTO = new PosicaoTO();
        pTO.addPosicaoDireta(4);
        pTO.addPosicaoDireta(10);
        CodeKata ck = new CodeKata();
        //teste
        assertEquals(pTO.getListaPosicoesDireta(), ck.encontrar("BYX", "ABCFBYXELMBYXYYYYYYYJKJGDKGSHGDHGDHSGDHSGDHSGDHJSGHJDGSHJGDHJDSGHJBYJX").getListaPosicoesDireta());
    }
}
