package com.codility.trainning.LessonThree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by rafael.alves on 03/02/2016.
 */
public class TapeEquilibriumTest extends TestCase {
    @Test
    public void testarRetorno() {
	TapeEquilibrium tEq = new TapeEquilibrium();
	int[] A = { 3, 1, 2, 4, 3 };
	tEq.solution(A);
	assertEquals(1, tEq.solution(A));
    }
}
