package br.com.demo;

public class NegocioException extends Exception {

    private static final String DESCRICAO = "Essa Exceção é especifica para erros de negócio.";

    public NegocioException(String mensagem){
        super(mensagem);
    }

    public NegocioException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }

    public String getAviso() {
        return DESCRICAO;
    }
}
