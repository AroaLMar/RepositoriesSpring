package com.example.VendedoresReservas.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name="reservas")
public class Reserva {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotBlank(message = "El codigo de cliente está vacio.")
    @NotNull(message = "El codigo de cliente es nulo.")
    private String codcli;
    @NotBlank(message = "La matricula está vacia.")
    @NotNull(message = "La matricula es nula.")

    private String matricula;

    public Reserva() {
    }

    public Reserva(String codcli, String matricula) {
        this.codcli = codcli;
        this.matricula = matricula;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codcli='" + codcli + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
