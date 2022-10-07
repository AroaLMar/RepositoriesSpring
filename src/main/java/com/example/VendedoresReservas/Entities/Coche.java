package com.example.VendedoresReservas.Entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Coche {

    @NotBlank(message =" La matricula del coche está vacia.")
    @NotNull(message = " El matricula del coche es nula")
    private String matricula;
    @NotBlank(message =" La marca del coche está vacia.")
    @NotNull(message = " El marca del coche es nula")
    private String marca;
    @NotBlank(message =" El modelo del coche está vacio.")
    @NotNull(message = " El modelo del coche es nulo.")
    private String modelo;
    @NotBlank(message =" El estado del coche está vacio.")
    @NotNull(message = " El estado del coche es nulo")
    private static Estado estado;

    enum Estado {
        enReparacion, Reservado, enVenta, Vendido
    }

    public Coche() {
    }


    public Coche(String matricula, String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }


    public String getMatricula() {

        return matricula;
    }

    public void setMatricula(String matricula) {

        this.matricula = matricula;
    }


    public String getMarca() {

        return marca;
    }

    public void setMarca(String marca) {

        this.marca = marca;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public static Estado getEstado() {

        return estado;
    }

    public static void setEstado(Estado estado) {
        Coche.estado = estado;
    }

    @Override
    public String toString() {
        return "Coche{" +
                ", matricula='" + matricula +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }


}
