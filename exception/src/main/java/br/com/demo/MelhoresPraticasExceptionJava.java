package br.com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * A seguinte implementeção objetiva demonstrar através de exemplos práticos,
 * as melhores práticas para o lançamento de Exceções.
 *
 * <p>A instrução try-with-resource permite implementar a interface AutoCloseable.
 * A maioria dos recursos padrão do Java implementam. Sendo assim toda tentativa que abrir
 * um recurso automaticamente será fechado.</p>
 *
 * Esse recuro subitui a implementação:
 *
 * <p>
 * finally {
 *      if (inputStream != null) {
 *          try {
 *              inputStream.close();
 *          } catch (IOException e) {
 *              log.error(e);
 *          }
 *      }
 * }</p>
 *
 * @author Michael Sousa
 */
public class MelhoresPraticasExceptionJava {

    /* Simula o lançamento de uma Exceção */
    public static void fechaRecursoAutomaticamente() throws NegocioException { //Ser especifico ao lançar as exception.

        //Busca o arquivo no pc.
        File file = new File("./tmp/arq.txt");

        // Tenta abri o recurso de leitura e fecha automaticamente após uso.
        try (FileInputStream inputStream = new FileInputStream(file);) {

            //Alguma implementação.

        } catch (IOException e) { // Dê preferência para Exceptions mais genéricas.
            // Empacote a exceção integral em uma Exceção especifíca.
            throw new NegocioException("Mensagem que descreve o erro", e);
        }
    }

    public static void main(String[] args) throws NegocioException {
        fechaRecursoAutomaticamente();
    }
}
