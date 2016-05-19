package com.codility.trainning.CodeKata4;

import java.util.List;

public interface IJogoDominoService {
    /**
     * CodeKata #4: Jogo de Domin�
     * M�todo respons�vel resolver a sequ�ncia das pe�as de Domino.
     * Ser� informado uma lista de pe�as de domin�, e o retorno esperado � uma inst�ncia de tabuleiro,
     * contendo uma lista ordenada de pe�as devidamente encaixadas e uma lista de pe�as que sobraram,
     * ou seja, n�o foi poss�vel o uso.
     * Caso a alguma regra de restri��o seja infringida ent�o lan�ar IllegalArgumentException.
     *
     * @param pPecas
     * @throws IllegalArgumentException
     */
    public Tabuleiro jogar(List<PecaDomino> pPecas)
		    throws IllegalArgumentException;
}
