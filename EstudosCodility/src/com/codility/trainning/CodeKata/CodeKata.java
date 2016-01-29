package com.codility.trainning.CodeKata;

/**
 * Created by rafael.alves on 29/01/2016.
 */
public class CodeKata extends PosicaoTO implements IEncontrarSequencia {
    public PosicaoTO encontrar(final String p, final String t) {
	PosicaoTO pto = new PosicaoTO();
	char[] cadeiaPequena = p.toCharArray();
	char[] cadeiaPrincipal = t.toCharArray();
	int j = 0;
	int guardarPosicao = 0;
	for (int i = 0; i < cadeiaPrincipal.length; i++) {
	    if (cadeiaPequena[j] == cadeiaPrincipal[i]) {
		if (j == 0) {
		    guardarPosicao = i;
		    j++;
		} else {
		    j++;
		    i--;
		}
	    } else {
		guardarPosicao = 0;
		j = 0;
	    }
	}
	return pto;
    }
}
