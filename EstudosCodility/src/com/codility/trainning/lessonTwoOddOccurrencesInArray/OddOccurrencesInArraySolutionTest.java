package com.codility.trainning.lessonTwoOddOccurrencesInArray;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by rafael.alves on 26/01/2016.
 */
public class OddOccurrencesInArraySolutionTest extends TestCase {
    @Test
    public void testeCenarioArrayValido() {
	OddOccurrencesInArraySolution s = new OddOccurrencesInArraySolution();
	int[] A = { 4, 7, 5, 4, 7, 10, 10, 0, 1, 5, 1 };
	assertEquals(0, s.solution(A));
    }

    @Test
    public void testeCenarioArrayNull() {
	OddOccurrencesInArraySolution s = new OddOccurrencesInArraySolution();
	int[] A = {};
	assertNull(s.solution(A));
    }
}
