package com.codility.trainning.lessonTwo;

import java.util.Arrays;

/**
 * Created by rafael.alves on 26/01/2016.
 * A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements,
 * and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * For example, in array A such that:
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * For example, given array A such that:
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * Assume that:
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class OddOccurrencesInArraySolution {
    public int solution(int[] A) {
	Arrays.sort(A);
	int resultado = 0;
	int anterior = 0;
	int atual = 0;
	int proximo = 0;
	for (int i = 0; i < A.length; i++) {
	    atual = A[i];
	    if (i > 0) {
		anterior = A[i - 1];
	    }
	    if (i < (A.length) - 1) {
		proximo = A[i + 1];
	    } else {
		proximo = 0;
	    }
	    if ((atual != anterior) && (atual != proximo)) {
		resultado = atual;
		break;
	    }
	}
	return resultado;
    }
}
