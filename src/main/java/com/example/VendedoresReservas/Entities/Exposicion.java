package com.example.VendedoresReservas.Entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class Exposicion {

    @NotBlank(message =" El numero de exposicion está vacio.")
    @NotNull(message = " El numero de exposicion es nulo")
    private String numExpo;
    @NotBlank(message =" La ciudad de la exposicion está vacia.")
    @NotNull(message = " La ciudad de la exposicion es nula.")
    private String ciudad;
    private ArrayList<Coche> coches;

    public Exposicion() {
    }

    public Exposicion(String numExpo, String ciudad, ArrayList<Coche> coches) {
        this.numExpo = numExpo;
        this.ciudad = ciudad;
        this.coches = coches;
    }

    public String getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(String numExpo) {
        this.numExpo = numExpo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Exposicion{" +
                "numExpo='" + numExpo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", coches=" + coches +
                '}';
    }

}
