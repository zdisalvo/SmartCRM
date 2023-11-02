package com.amazon.ata.crm.service.exceptions;

public class ClientNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 678433914898803276L;

    public ClientNotFoundException() {super();}

    public ClientNotFoundException(String message) {super(message);}

    public ClientNotFoundException(Throwable cause) {super(cause);}

    public ClientNotFoundException(String message, Throwable cause) {super(message, cause);}
}
