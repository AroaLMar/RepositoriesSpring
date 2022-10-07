package com.example.VendedoresReservas.Controllers;


import com.example.VendedoresReservas.Entities.Reserva;
import com.example.VendedoresReservas.Excepciones.ObjetoNoEncontrado;
import com.example.VendedoresReservas.Excepciones.ObjetoEncontrado;
import com.example.VendedoresReservas.Repositories.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservasController {

    @Autowired

    private ReservasRepository ReservaRepository;

    //Reservar un coche
    @PostMapping("/api/reservas/clientes/{codcli}/coches/{matricula}")
    public ResponseEntity<String> reservarCoche(@PathVariable String codcli, @PathVariable String matricula) {

        try{
            if(ReservaRepository.existsByMatricula(matricula)) {

                throw new ObjetoEncontrado("El coche indicado ya está reservado");

            }else {

                ReservaRepository.save(new Reserva(codcli, matricula));

            }

        }catch(ObjetoEncontrado e){

            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();

    }


    //Cancelar una reserva
    @DeleteMapping("/api/reservas/clientes/{codcli}/coches/{matricula}")
    public ResponseEntity<String> cancelarReserva(@PathVariable String codcli, @PathVariable String matricula) throws Exception {

        try{

            if(!ReservaRepository.existsByClienteAndMatricula(codcli,matricula)) {

                throw new ObjetoNoEncontrado("No existe reserva para el cliente y el coche introducido");

            }else {

                ReservaRepository.deleteByMatricula(matricula);


            }

        }catch(ObjetoNoEncontrado e){

            return ResponseEntity.notFound().build();
        }

       return ResponseEntity.ok().build();

    }

}

