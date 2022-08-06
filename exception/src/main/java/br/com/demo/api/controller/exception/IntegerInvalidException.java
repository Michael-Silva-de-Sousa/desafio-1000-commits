package br.com.demo.api.controller.exception;

public class IntegerInvalidException extends RuntimeException {

    private String message;

    public IntegerInvalidException(String msg) {
        super(msg);
        this.message = msg;
    }

    public IntegerInvalidException(String msg, IntegerInvalidException e) {
        super(msg, e);
        this.message = msg;
    }
}
