package com.codility.trainning.CodeKata6;

/**
 * Created by rafael.alves on 30/06/2016.
 */
public interface IConversorNumericoService {
    /**
     * M�todo respons�vel por receber um n�mero romano e converte-lo para indo-ar�bico .
     * Exemplos:
     * - Entrada: II; sa�da: 2;
     * - Entrada: M; sa�da: 1000.
     *
     * @param pNumeroRomano
     * @return n�mero indo-ar�bico
     */
    public String converterParaIndoArabico(String pNumeroRomano) throws IllegalArgumentException;

    /**
     * M�todo respons�vel por receber um n�mero indo-ar�bico e converte-lo para romano.
     * Exemplos:
     * - Entrada: 10; sa�da: X;
     * - Entrada: 1000; sa�da: M.
     *
     * @param pIndoArabico
     * @return n�mero romano
     */
    public String converterParaRomano(String pIndoArabico) throws IllegalArgumentException;
}
