package br.com.demo;

/**
 * Classe que representa a Exception customizada.
 */
public class MinhaException extends Exception{

    public MinhaException(String mensagem) {
        super(mensagem);
    }

    public MinhaException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}