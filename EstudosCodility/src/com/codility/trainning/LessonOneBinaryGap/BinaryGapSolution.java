package com.codility.trainning.LessonOneBinaryGap;

/**
 * Created by rafael.alves on 25/01/2016.
 */
public class BinaryGapSolution {
    public int binaryGapSolution(int n) {
	String numeroBinario = "";
	Integer resultado = 0;
	Integer procuraResultado = 0;
	while (n > 0) {
	    numeroBinario = (n % 2 == 0 ? "0" : "1") + numeroBinario;
	    n = n / 2;
	}
	char[] arrayNumeroBinario = numeroBinario.toCharArray();
	for (int i = 0; i < arrayNumeroBinario.length; i++) {
	    if (arrayNumeroBinario[i] == "0".charAt(0)) {
		procuraResultado = procuraResultado + 1;
	    } else if (procuraResultado > resultado) {
		resultado = procuraResultado;
		procuraResultado = 0;
	    }
	}
	return resultado;
    }
}
