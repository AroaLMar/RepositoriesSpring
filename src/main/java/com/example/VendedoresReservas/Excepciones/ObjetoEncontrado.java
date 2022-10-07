package com.example.VendedoresReservas.Excepciones;

public class ObjetoEncontrado extends Exception{

    public ObjetoEncontrado(String message) {
        super("ERROR " + message);
    }

}
