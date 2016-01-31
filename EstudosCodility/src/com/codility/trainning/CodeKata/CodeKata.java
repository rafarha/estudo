package com.codility.trainning.CodeKata;

/**
 * Created by rafael.alves on 29/01/2016.
 */
public class CodeKata extends PosicaoTO implements IEncontrarSequencia {
    public PosicaoTO encontrar(final String p, final String t) {
        PosicaoTO pto = new PosicaoTO();
        char[] cadeiaPequena = p.toCharArray();
        char[] cadeiaPrincipal = t.toCharArray();
        int guardarPosicao = 0;
        for (int i = 0; i < cadeiaPrincipal.length; i++) {
                if (cadeiaPequena[0] == cadeiaPrincipal[i]) {
                guardarPosicao = i;
                for (int j = 1; j < cadeiaPequena.length; j++) {
                    if (cadeiaPequena[j] == cadeiaPrincipal[i + j]) {
                        if ((j+1) == cadeiaPequena.length) {
                            pto.addPosicaoDireta(guardarPosicao);
                        }
                        continue;
                    } else {
                        guardarPosicao = 0;
                        break;
                    }
                }
            }
        }
        return pto;
    }
}
