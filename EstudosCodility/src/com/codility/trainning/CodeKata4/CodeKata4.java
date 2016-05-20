package com.codility.trainning.CodeKata4;

import java.util.Iterator;
import java.util.List;

/**
 * Created by rafael.alves on 29/03/2016.
 */
public class CodeKata4 implements IJogoDominoService {

    public Tabuleiro jogar(List<PecaDomino> pPecas)
		    throws IllegalArgumentException {
	Iterator<PecaDomino> pecaDominoAsIterator = pPecas.iterator();
	while (pecaDominoAsIterator.hasNext()) {
	    PecaDomino it = pecaDominoAsIterator.next();
	    System.out.println(it.getPontaA() + "|" + it.getPontaB());

	}
	return null;
    }
}