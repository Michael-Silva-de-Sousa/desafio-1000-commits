package br.com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Tete de unidade da MinhaException.
 */
class AppTest {

    private final static Logger log = Logger.getLogger("AppTest");

    /***
     * Teste lança MinhaException com mensage customizada.
     */
    @Test
    void testMinhaException() {
        Exception thrown = Assertions.assertThrows(MinhaException.class, this::dividePorZero);
        Assertions.assertEquals("Minha excecao foi lancada!", thrown.getMessage());
    }

    /***
     * Teste lança MinhaException com mensagem customizada e o Throwable.
     */
    @Test
    void testMinhaExceptionComThrowable() {
        MinhaException thrown = Assertions.assertThrows(MinhaException.class, this::dividePorZeroComThrowable);
        Assertions.assertEquals("Minha excecao foi lancada!", thrown.getMessage());
        Assertions.assertTrue(thrown.getCause().getMessage().contains("For input string:"));

        log.log(Level.SEVERE, "MinhaException foi lançada", thrown);
    }

    void dividePorZero() throws Exception {
        throw new MinhaException("Minha excecao foi lancada!");
    }

    void dividePorZeroComThrowable() throws MinhaException {
        try {
            Integer.parseInt("A");
        } catch (NumberFormatException e) {
            throw new MinhaException("Minha excecao foi lancada!", e);
        }
    }
}
