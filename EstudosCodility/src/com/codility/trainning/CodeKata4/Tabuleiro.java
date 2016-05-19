package com.codility.trainning.CodeKata4;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.alves on 29/03/2016.
 */
public class Tabuleiro {
    private List<PecaDomino> pecasEncaixadas = new ArrayList<PecaDomino>();

    private List<PecaDomino> pecasSobraram = new ArrayList<PecaDomino>();

    public void adicionarSobra(final PecaDomino pPeca) {
	pecasSobraram.add(pPeca);
    }

    public void encaixarPeca(final PecaDomino pPeca) {
	pecasEncaixadas.add(pPeca);
    }

    public List<PecaDomino> getPecasEncaixadas() {
	return pecasEncaixadas;
    }

    public List<PecaDomino> getPecasSobraram() {
	return pecasSobraram;
    }

    public void setPecasEncaixadas(final List<PecaDomino> pPecasEncaixadas) {
	pecasEncaixadas = pPecasEncaixadas;
    }

    public void setPecasSobraram(final List<PecaDomino> pPecasSobraram) {
	pecasSobraram = pPecasSobraram;
    }

    @Override public String toString() {
	return "Peças encaixadas: " + StringUtils.join(pecasEncaixadas, "") +
			"\nSobra de peças=" + StringUtils.join(pecasSobraram, "");
    }
}