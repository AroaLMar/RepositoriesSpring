package com.example.VendedoresReservas.Controllers;


import com.example.VendedoresReservas.Entities.vendedor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VendedorInput{

    //ATRIBUTOS
    @NotBlank(message = "El codigo de vendedor está vacio.")
    @NotNull(message = "El codigo de vendedor es nulo.")
    private String codven;
    @NotBlank(message = "El nombre del vendedor está vacio.")
    @NotNull(message = "El nombre del vendedor es nulo.")
    private String nombre;
    @NotBlank(message =" El domicilio de vendedor está vacio.")
    @NotNull(message = " El domicilio de vendedor es nulo")
    private String domicilio;
    @NotBlank(message =" El telefono de vendedor está vacio.")
    @NotNull(message = " El telefono de vendedor es nulo")
    private int telefono;


    //CONSTRUCTORES

    public VendedorInput() {
    }

    public VendedorInput(String codven, String nombre, String domicilio, int telefono) {
        this.codven = codven;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    //GETTERS Y SETTERS

    public String getCodven() {


        return codven;
    }

    public void setCodven(String codcli) {

        this.codven= codven;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getDomicilio() {

        return domicilio;
    }

    public void setDomicilio(String domicilio) {

        this.domicilio = domicilio;
    }

    public int getTelefono() {

        return telefono;
    }

    public void setTelefono(int telefono) {

        this.telefono = telefono;
    }


    public vendedor toDomain(){

        return new vendedor(this.getCodven(),this.getNombre(),this.getDomicilio(),this.getTelefono());

    }


    //MÉTODO TOSTRING
    @Override
    public String toString() {
        return "VendedorInput{" +
                "codven='" + codven + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
