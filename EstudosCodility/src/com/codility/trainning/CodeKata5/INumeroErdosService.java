package com.codility.trainning.CodeKata5;

import java.util.List;

/**
 * Created by rafael.alves on 19/05/2016.
 */
public interface INumeroErdosService {
    /**
     * Método responsável por descobrir o número de Erdos de um dado autor.
     * Esse número deverá ser descoberto, considerando a lista de
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
     * @return é esperado um número inteiro representando o Número de Erdos do autor.
     */
    public Integer descobrirNumeroErdosDoAutor(String pNomeAutor,
		    List<String> pAutoresArtigos) throws IllegalArgumentException;
}
