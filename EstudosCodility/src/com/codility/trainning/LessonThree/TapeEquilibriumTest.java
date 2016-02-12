package com.codility.trainning.LessonThree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

/**
 * Created by rafael.alves on 03/02/2016.
 */
public class TapeEquilibriumTest extends TestCase {
    public int[] criarArray(int numeroPosicao) {
	int[] A = new int[numeroPosicao];
	Random r = new Random();
	for (int i = 0; i < A.length; i++) {
	    A[i] = r.nextInt(100000);
	}
	return A;
    }

    @Test
    public void testarRetorno() {
	TapeEquilibrium tEq = new TapeEquilibrium();
	int[] A = criarArray(1000);
	tEq.solution2(A);
    }

    @Test
    public void testarSmallNegativo() {
	TapeEquilibrium tEq = new TapeEquilibrium();
	int[] A = { -1, -5 };
	assertEquals(4, tEq.solution2(A));

    }
}
