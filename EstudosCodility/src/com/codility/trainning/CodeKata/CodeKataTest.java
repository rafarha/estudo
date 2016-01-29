package com.codility.trainning.CodeKata;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by rafael.alves on 29/01/2016.
 */
public class CodeKataTest extends TestCase {
    @Test
    public void testeBasico() {
	CodeKata ck = new CodeKata();
	ck.encontrar("BYX", "ABCFBYXELMBYX");
    }
}
