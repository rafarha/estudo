package com.codility.trainning.CodeKata5;

import java.util.List;

/**
 * Created by rafael.alves on 19/05/2016.
 */
public interface INumeroErdosService {
    /**
     * M�todo respons�vel por descobrir o n�mero de Erdos de um dado autor.
     * Esse n�mero dever� ser descoberto, considerando a lista de
     * autores de uma dada lista de artigos.
     * Exemplo de lista de autores de artigos:
     * - P. Erdos, A. Selberg.
     * - P. Erdos, J. Silva, M. Souza.
     * - M. Souza, A. Selberg, A. Oliveira.
     * - J. Ninguem, M. Ninguem.
     * - P. Duarte, A. Oliveira.
     *
     * @param pNomeAutor      nome de um autor qualquer. Ex: "A. Selberg".
     * @param pAutoresArtigos cada item da lista corresponde a algo como isso: "P. Erdos, A. Selberg".
     * @return � esperado um n�mero inteiro representando o N�mero de Erdos do autor.
     */
    public Integer descobrirNumeroErdosDoAutor(String pNomeAutor,
		    List<String> pAutoresArtigos) throws IllegalArgumentException;
}
