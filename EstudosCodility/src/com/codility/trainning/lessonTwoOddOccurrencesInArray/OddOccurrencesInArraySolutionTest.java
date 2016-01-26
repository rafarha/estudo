package com.codility.trainning.lessonTwoOddOccurrencesInArray;

import junit.framework.TestCase;
import org.junit.*;

/**
 * Created by rafael.alves on 26/01/2016.
 */
public class OddOccurrencesInArraySolutionTest extends TestCase {
    @Test
    public void testeCenarioArrayValido() {
	OddOccurrencesInArraySolution s = new OddOccurrencesInArraySolution();
	int[] A = { 4, 7, 5, 4, 7, 10, 10, 55, 55, 1, 1 };
	assertEquals(5, s.solution(A));
    }
}
