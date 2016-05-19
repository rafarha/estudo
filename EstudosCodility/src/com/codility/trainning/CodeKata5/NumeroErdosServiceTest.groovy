package com.codility.trainning.CodeKata5

import com.codility.trainning.util.CodeKataUtil
import org.apache.commons.lang3.StringUtils
import org.junit.Assert
import org.junit.Test

/**
 * Created by eder on 08/05/2016.
 */
public class NumeroErdosServiceTest {
    private final INumeroErdosService service = new CodeKata5();

    @Test
    public void testNumeroErdosTestTable() throws IOException {
        // leio o arquivo texto, e transformo-o em uma lista de strings
        final List<String> linhasTestTable = CodeKataUtil.obterCenariosTestTable(this.getClass());
        // os erros serão adicionados nessa lista
        final List<String> erros = new ArrayList<String>();
        for (String linhaTxt : linhasTestTable) {
            final String[] linha = StringUtils.splitPreserveAllTokens(linhaTxt.substring(1, linhaTxt.length() - 1), '|');

            //|cenario|nomeAutor|arquivoListaArtigos|retorno|ok|
            final String cenario = linha[0];
            final String nomeAutor = linha[1]
            final nomeArquivo = "${linha[2]}.artigo"
            final List<String> listaAutoresPorArtigos = CodeKataUtil.obterLinhasDoArquivo(this.class, nomeArquivo)
            final Integer esperado = linha[3] as Integer
            def resultadoEsperado = linha[4];

            final boolean erroEsperado = 'erro' == resultadoEsperado || 'ERRO' == resultadoEsperado;
            Integer numeroErdos
            def mensagemFalha = "\n - NomeAutor: $nomeAutor \n - Artigos:\n       -> ${listaAutoresPorArtigos.join("\n       -> ")}  \n - Saida: $numeroErdos\n"
            try {
                numeroErdos = service.descobrirNumeroErdosDoAutor(nomeAutor, listaAutoresPorArtigos);

                if (erroEsperado) {
                    erros.add("Cenario " + cenario + " falhou: pois um erro era esperado " + mensagemFalha);
                    continue;
                }

                if (esperado != numeroErdos) {
                    erros.add("Cenario $cenario falhou: Esperado $esperado, mas retornado $numeroErdos" + mensagemFalha);
                    continue;
                }

            } catch (Throwable e) {
                if (!erroEsperado) {
                    erros.add("Cenario $cenario falhou: pois NAO era esperado erro neste cenario: ${e.getMessage()}" + mensagemFalha);
                    continue;
                }
            }
            System.out.println("Cenario " + cenario + ": ok! ");
        }

        // se lista de erros contiver algum item, ent?o falho o teste e exibo os erros.
        if (!erros.isEmpty()) {
            Assert.fail("Os Seguintes cenarios de teste falharam: \n${StringUtils.join(erros, "\n")}");
        }
    }


}