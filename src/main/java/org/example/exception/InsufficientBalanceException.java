package org.example.exception;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message, int saldo, int apuesta){
        super(message);
    }

}
