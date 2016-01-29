package com.codility.trainning.CodeKata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.alves on 29/01/2016.
 */
public class PosicaoTO {
    public List<Integer> listaPosicoesDireta = new ArrayList<Integer>();

    public List<Integer> listaPosicoesReversa = new ArrayList<Integer>();

    public void addPosicaoDireta(Integer pPosicao) {
	listaPosicoesDireta.add(pPosicao);
    }

    public void addPosicaoReversa(Integer pPosicao) {
	listaPosicoesReversa.add(pPosicao);
    }

    List<Integer> getListaPosicoesDireta() {
	return listaPosicoesDireta;
    }

    List<Integer> getListaPosicoesReversa() {
	return listaPosicoesReversa;
    }
}
