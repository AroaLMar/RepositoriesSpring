package com.example.VendedoresReservas.Excepciones;

public class ParametroNoValido extends Exception{

    public ParametroNoValido(String message) {
        super("ERROR: " + message);
    }

}
