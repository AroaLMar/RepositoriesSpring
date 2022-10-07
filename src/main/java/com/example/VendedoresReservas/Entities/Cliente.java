package com.example.VendedoresReservas.Entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class Cliente {

    @NotBlank(message = "El codigo de cliente está vacio.")
    @NotNull(message = "El codigo de cliente es nulo.")
    private String codcli;
    @NotBlank(message = "El nombre del cliente está vacio.")
    @NotNull(message = "El nombre del cliente es nulo.")
    private String nombre;
    @NotBlank(message =" El domicilio de cliente está vacio.")
    @NotNull(message = " El domicilio de cliente es nulo")
    private String domicilio;
    @NotBlank(message =" El telefono de cliente está vacio.")
    @NotNull(message = " El telefono de cliente es nulo")
    private int telefono;
    private HashMap<String, Coche> listaReservas = new HashMap<>();

    public Cliente() {
    }

    public Cliente(String codcli, String nombre, String domicilio, int telefono) {
        this.codcli = codcli;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;

    }

    public HashMap<String, Coche> getListaReservas() {

        return listaReservas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codcli='" + codcli + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono=" + telefono +
                ", listaReservas=" + listaReservas +
                '}';
    }
}
