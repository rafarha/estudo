package com.codility.trainning.CodeKata4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.alves on 31/03/2016.
 */
public class CodeKata4Test {
    @Test
    public void firstTest() {
	CodeKata4 ck = new CodeKata4();
	List<PecaDomino> pecaDominos = new ArrayList<PecaDomino>();
	PecaDomino objDomino = new PecaDomino(0, 1);
	pecaDominos.add(objDomino);
	PecaDomino objDomino1 = new PecaDomino(3, 3);
	pecaDominos.add(objDomino1);
	PecaDomino objDomino2 = new PecaDomino(3, 1);
	pecaDominos.add(objDomino2);
	ck.jogar(pecaDominos);

    }
}
