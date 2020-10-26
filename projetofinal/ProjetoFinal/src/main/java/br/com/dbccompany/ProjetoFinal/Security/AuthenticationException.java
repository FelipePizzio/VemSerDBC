package br.com.dbccompany.ProjetoFinal.Security;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause ) {
        super(message, cause);
    }
}
