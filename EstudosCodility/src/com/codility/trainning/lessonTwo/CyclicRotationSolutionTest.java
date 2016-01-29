package com.codility.trainning.lessonTwo;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rafael.alves on 28/01/2016.
 */
public class CyclicRotationSolutionTest extends TestCase {
    @Test
    public void testeArrayUmaPosicao() {
	CyclicRotationSolution s = new CyclicRotationSolution();
	int[] A = { 3 };
	int[] resultado = { 3 };
	int k = 1;
	assertEquals(true, Arrays.equals(s.solution(A, k), resultado));
    }

    @Test
    public void testeBasicoDoCodility() {
	CyclicRotationSolution s = new CyclicRotationSolution();
	int[] A = { 3, 8, 9, 7, 6 };
	int[] resultado = { 9, 7, 6, 3, 8 };
	int k = 3;
	assertEquals(true, Arrays.equals(s.solution(A, k), resultado));
    }

    @Test
    public void testeCenarioMaximo() {
	CyclicRotationSolution s = new CyclicRotationSolution();
	int[] A = { 3, 8, 9, 7, 6 };
	int[] resultado = { 3, 8, 9, 7, 6 };
	int k = 100;
	assertEquals(true, Arrays.equals(s.solution(A, k), resultado));
    }

    @Test
    public void testeIndiceMaiorQueArray() {
	CyclicRotationSolution s = new CyclicRotationSolution();
	int[] A = { 3, 8, 9, 7, 6 };
	int[] resultado = { 6, 3, 8, 9, 7 };
	int k = 11;
	assertEquals(true, Arrays.equals(s.solution(A, k), resultado));
    }
}
