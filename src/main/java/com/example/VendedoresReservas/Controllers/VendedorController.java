package com.example.VendedoresReservas.Controllers;

import com.example.VendedoresReservas.Entities.concesionario;
import com.example.VendedoresReservas.Entities.vendedor;
import com.example.VendedoresReservas.Excepciones.ObjetoEncontrado;
import com.example.VendedoresReservas.Excepciones.ObjetoNoEncontrado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
public class VendedorController {



    @PostMapping("/api/vendedores")
    public ResponseEntity<String> aniadirVendedor(@Valid @RequestBody VendedorInput vend) {

        try {

            concesionario.aniadirVendedor(vend.toDomain());

        } catch (ObjetoEncontrado e2) {

            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok().build();

    }





    @PutMapping("/api/vendedores/{codven}")
    public ResponseEntity<String> modificarVendedor(@PathVariable String codven, @Valid @RequestBody VendedorUpdate vend) {

        try{
            concesionario.modificarVendedor(codven,vend.getNombre(),vend.getDomicilio(),vend.getTelefono());

        }catch(ObjetoEncontrado ob){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }


    @DeleteMapping("/api/vendedores/{codven}")
    public ResponseEntity<String> borrarVendedor(@PathVariable String codven) {

        try{
            concesionario.borrarVendedor(codven);
        }catch(ObjetoNoEncontrado ob){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }


    @GetMapping("/api/vendedores")
    public ResponseEntity<ArrayList<VendedorOutput>> getVendedores() {

        if(concesionario.getListaVendedores().isEmpty()){

            return ResponseEntity.notFound().build();
        }

        ArrayList<VendedorOutput> listaSalida=new ArrayList<>();

        for(vendedor ven: concesionario.getListaVendedores().values()){
            listaSalida.add(new VendedorOutput(ven.getCodven(), ven.getNombre(), ven.getTelefono()));
        }

        return ResponseEntity.ok(listaSalida);
    }
}