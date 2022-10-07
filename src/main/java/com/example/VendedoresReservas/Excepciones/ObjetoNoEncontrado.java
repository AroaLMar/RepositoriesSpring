package com.example.VendedoresReservas.Excepciones;

public class ObjetoNoEncontrado extends Exception {

     public ObjetoNoEncontrado(String message) {
          super("ERROR " + message);
     }

}
