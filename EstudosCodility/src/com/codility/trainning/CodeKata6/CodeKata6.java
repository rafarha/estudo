package com.codility.trainning.CodeKata6;

/**
 * Created by rafael.alves on 30/06/2016.
 */
public class CodeKata6 implements IConversorNumericoService {
    public final String numeroCem = "C";

    public final String numeroCinco = "V";

    public final String numeroCinquenta = "L";

    public final String numeroDez = "X";

    public final String numeroMil = "M";

    public final String numeroQuinhentos = "D";

    public final String numeroUm = "I";

    @Override
    public String converterParaIndoArabico(final String pNumeroRomano) throws IllegalArgumentException {
	return null;
    }

    @Override
    public String converterParaRomano(final String pIndoArabico) throws IllegalArgumentException {
	Integer numeroParaConverter = Integer.parseInt(pIndoArabico);
	converterMilhares(numeroParaConverter);
	return null;
    }

    private String converterMilhares(Integer pMilhares) {
	Integer resultado = pMilhares / 1000;
	String milharesConvertida = "";
	//Efetuar um laço até o número chegar a 0
	while (resultado > 0) {
	    if (verificaSeExisteRepresentacao(resultado)) {

	    }
	    if (resultado > 10) {
		milharesConvertida = milharesConvertida + "(" + numeroDez + ")";
		resultado = resultado - 10;
	    }
	    if (ehMultiploDeCinco(resultado)) {
		milharesConvertida = milharesConvertida + "(" + numeroCinco + ")";
		resultado = resultado - 5;
	    }
	    if (resultado == 1) {
		milharesConvertida = numeroMil;
		resultado = resultado - 1;
	    }
	}

	return "";
    }

    private boolean ehMultiploDeCinco(Integer pNumero) {
	boolean ehMultiplo = false;
	if (pNumero % 5 == 0) {
	    ehMultiplo = true;
	}
	return ehMultiplo;
    }

    private boolean verificaSeExisteRepresentacao(Integer pNumero) {
	boolean existeRepresentacao = false;
	switch (pNumero) {
	    case 1:
		existeRepresentacao = true;
	    case 5:
		existeRepresentacao = true;
	    case 10:
		existeRepresentacao = true;
	    case 50:
		existeRepresentacao = true;
	    case 100:
		existeRepresentacao = true;
	    case 500:
		existeRepresentacao = true;
	    case 1000:
		existeRepresentacao = true;
	}
	return existeRepresentacao;
    }

    private boolean ehMultiploDeDez(Integer pNumero) {
	boolean ehMultiplo = false;
	if (pNumero % 10 == 0) {
	    ehMultiplo = true;
	}
	return ehMultiplo;
    }


}
