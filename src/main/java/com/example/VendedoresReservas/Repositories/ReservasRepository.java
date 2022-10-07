package com.example.VendedoresReservas.Repositories;

import com.example.VendedoresReservas.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<Reserva, String> {


    boolean existsByMatricula(String matricula);

    boolean existsByClienteAndMatricula(String codcli, String matricula);

    void deleteByMatricula(String matricula);

}
