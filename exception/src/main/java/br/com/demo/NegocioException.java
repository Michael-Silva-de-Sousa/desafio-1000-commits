package br.com.demo;

public class NegocioException extends Exception {

    public NegocioException(String mensagem){
        super(mensagem);
    }

    public NegocioException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
