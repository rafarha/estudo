package com.codility.trainning.CodeKata5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.alves on 19/05/2016.
 */
public class CodeKata5 implements INumeroErdosService {
    @Override public Integer descobrirNumeroErdosDoAutor(final String pNomeAutor, final List<String> pAutoresArtigos)
		    throws IllegalArgumentException {
	List<String> listaAutoresClassificados = new ArrayList<String>();
	String delemiters = "\\,";
	int resultado = 0;
	/*
	for (int i = 0; i < pAutoresArtigos.size(); i++) {
	    String autoresPorArtigo = pAutoresArtigos.get(i).toString();
	    if (autoresPorArtigo.contains("P. Erdos")) {
		String linha[] = autoresPorArtigo.split(delemiters);
		if (linha != null) {
		    Integer aux = 0;
		    while (aux < linha.length) {
			if (linha[aux].toString().equalsIgnoreCase("P. Erdos")) {
			    listaAutoresClassificados.add(linha[aux] + "0");
			} else {
			    listaAutoresClassificados.add(linha[aux] + "1");
			}
			aux++;
		    }
		}
	    }
	    System.out.println("Teste");
	} */
	for (int i = 0; i < pAutoresArtigos.size(); i++) {
	    String autoresPorArtigo = pAutoresArtigos.get(i).toString();
	    if (autoresPorArtigo.contains(pNomeAutor)) {
		if (autoresPorArtigo.contains("P. Erdos")) {
		    resultado = 1;
		    break;
		}
	    }
	}
	return resultado;
    }
}
