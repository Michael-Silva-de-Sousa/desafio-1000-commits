package br.com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {

    @Test
    void testMinhaException() {
        Exception thrown = Assertions.assertThrows(MinhaException.class, this::dividePorZero);
        Assertions.assertEquals("Minha excecao foi lancada!", thrown.getMessage());
    }

    void dividePorZero() throws Exception {
        throw new MinhaException("Minha excecao foi lancada!");
    }
}
