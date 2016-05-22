package com.codility.trainning.CodeKata5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rafael.alves on 19/05/2016.
 */
public class CodeKata5 implements INumeroErdosService {
    @Override public Integer descobrirNumeroErdosDoAutor(final String pNomeAutor, final List<String> pAutoresArtigos)
		    throws IllegalArgumentException {
	if (pAutoresArtigos.size() >= 100 || pNomeAutor.length() >= 15) {
	    throw new IllegalArgumentException(
			    "Não é permitido lista de artigo maior que 100 ou nome procurado com mais de 15 caracteres");
	} else {
	    HashMap<String, Integer> pNovaListaAutores = new HashMap<String, Integer>();
	    List<String> autoresSemRelacao = new ArrayList<String>();
	    boolean temRelacao = false;
	    Integer resultado = 0;
	    int aux = 0;
	    while (aux < pAutoresArtigos.size()) {
		String linhaListaPrincipal = pAutoresArtigos.get(aux).toString();
		if (linhaListaPrincipal.contains("P. Erdos")) {
		    adicionarLinhasErdos(linhaListaPrincipal, pNovaListaAutores);
		    pAutoresArtigos.remove(aux);
		} else {
		    temRelacao = adicionarRelacoesIndiretasComErdos(linhaListaPrincipal, pNovaListaAutores);
		    if (temRelacao) {
			pAutoresArtigos.remove(aux);
		    } else {
			autoresSemRelacao.add(pAutoresArtigos.get(aux));
			aux++;
		    }
		}
	    }

	    if (pNovaListaAutores.containsKey(pNomeAutor.trim())) {
		return pNovaListaAutores.get(pNomeAutor.toString().trim()).intValue();

	    }
	    return -1;
	}
    }

    private void adicionarLinhasErdos(String linhaListaPrincipal, HashMap<String, Integer> pNovaListaAutores) {
	String[] listaDaLinha = linhaListaPrincipal.split("\\,");
	Integer aux = 0;
	while (aux < listaDaLinha.length) {
	    if (listaDaLinha[aux].toString().equals("P. Erdos")) {
		pNovaListaAutores.put(listaDaLinha[aux].toString().trim(), 0);
	    } else {
		pNovaListaAutores.put(listaDaLinha[aux].toString().trim(), 1);

	    }
	    aux++;
	}
    }

    private boolean adicionarRelacoesIndiretasComErdos(String linhaListaPrincipal, HashMap<String, Integer> pNovaListaAutores) {
	String[] listaDaLinha = linhaListaPrincipal.split("\\,");
	boolean realacaoIndiretaErdos = false;
	Integer aux = 0;
	Integer numeroErdos = 0;
	String nomeEncontrado = "";
	while (aux < listaDaLinha.length) {
	    if (pNovaListaAutores.containsKey(listaDaLinha[aux].toString().trim())) {
		numeroErdos = pNovaListaAutores.get(listaDaLinha[aux].toString().trim()).intValue() + 1;
		realacaoIndiretaErdos = true;
	    }
	    aux++;
	}
	aux = 0;
	while (aux < listaDaLinha.length) {
	    if (!pNovaListaAutores.containsKey(listaDaLinha[aux].toString().trim()) && realacaoIndiretaErdos) {
		pNovaListaAutores.put(listaDaLinha[aux].toString().trim(), numeroErdos);
	    }
	    aux++;
	}
	return realacaoIndiretaErdos;
    }

    //Escrever um método para validar se todos os artigos possuem somente 10 autores.
}
