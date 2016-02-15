package com.codility.trainning.CodeKata2;

/**
 * Created by rafael.alves on 15/02/2016.
 */
public class QuantidadeNotaTO {
    private Integer notas10;

    private Integer notas2;

    private Integer notas20;

    private Integer notas5;

    private Integer notas50;

    public QuantidadeNotaTO() {
    }

    public QuantidadeNotaTO(final Integer pQuantidadeNotas2,
		    final Integer pQuantidadeNotas5, final Integer pQuantidadeNotas10,
		    final Integer pQuantidadeNotas20, final Integer pQuantidadeNotas50) {
	notas2 = pQuantidadeNotas2;
	notas5 = pQuantidadeNotas5;
	notas10 = pQuantidadeNotas10;
	notas20 = pQuantidadeNotas20;
	notas50 = pQuantidadeNotas50;
    }

    public Integer getNotas10() {
	return notas10;
    }

    public Integer getNotas2() {
	return notas2;
    }

    public Integer getNotas20() {
	return notas20;
    }

    public Integer getNotas5() {
	return notas5;
    }

    public Integer getNotas50() {
	return notas50;
    }

    @Override public String toString() {
	return notas2 + "," + notas5 + "," + notas10 + "," + notas20 + "," + notas50;
    }

}
