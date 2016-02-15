package com.codility.trainning.CodeKata2;

import java.math.BigDecimal;

/**
 * Created by rafael.alves on 15/02/2016.
 */
public interface ICaixaEletronicoService {
    /**
     * m�todo usado para informar o estoque de notas
     **/
    public void contarNotas(QuantidadeNotaTO pQuantidadeNotas);

    public QuantidadeNotaTO sacar(BigDecimal pValor) throws ImpossivelSacarException;
}
