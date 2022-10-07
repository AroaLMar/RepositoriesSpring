package com.example.VendedoresReservas.Controllers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VendedorOutput {

    //ATRIBUTOS
    @NotBlank(message = "El codigo de vendedor está vacio.")
    @NotNull(message = "El codigo de vendedor es nulo.")
    private String codven;
    @NotBlank(message = "El nombre del vendedor está vacio.")
    @NotNull(message = "El nombre del vendedor es nulo.")
    private String nombre;
    @NotBlank(message =" El telefono de vendedor está vacio.")
    @NotNull(message = " El telefono de vendedor es nulo")
    private int telefono;

    //CONSTRUCTORES


    public VendedorOutput() {
    }

    public VendedorOutput(String codven, String nombre, int telefono) {
        this.codven = codven;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //GETTERS Y SETTERS(solo queremos los getters que son los que nos devuelven los datos)


    public String getCodven() {
        return codven;
    }

    public String getNombre() {

        return nombre;
    }

    public int getTelefono() {

        return telefono;
    }
}
