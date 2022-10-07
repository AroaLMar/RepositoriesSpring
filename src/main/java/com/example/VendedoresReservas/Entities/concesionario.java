package com.example.VendedoresReservas.Entities;

import com.example.VendedoresReservas.Excepciones.ObjetoEncontrado;
import com.example.VendedoresReservas.Excepciones.ObjetoNoEncontrado;
import com.example.VendedoresReservas.Excepciones.ParametroNoValido;

import java.util.HashMap;

public class concesionario {

    private static HashMap<String, Cliente> listaClientes = new HashMap<>();
    private static HashMap<String, Coche> listaCoches= new HashMap<>();
    private static HashMap<String, vendedor> listaVendedores = new HashMap<>();





    public static void aniadirVendedor(vendedor vendedor) throws ObjetoEncontrado {

        if(listaVendedores.containsKey(vendedor.getCodven())) throw new ObjetoEncontrado(("El vendedor ya está en la lista de vendedores"));
        listaVendedores.put(vendedor.getCodven(), vendedor);
    }


    public static void modificarVendedor(String codven, String nombre, String domicilio, int telefono) throws ObjetoEncontrado {
        if(listaVendedores.containsKey(codven)) throw  new ObjetoEncontrado("El vendedor para modificar non se encuentra en la lista de vendedores");
        vendedor vendedor = listaVendedores.get(codven);
        vendedor.modificarVendedor(nombre, domicilio, telefono);
    }


    public static void borrarVendedor(String codven) throws ObjetoNoEncontrado {

       if(!listaVendedores.containsKey(codven)) throw new ObjetoNoEncontrado(("El vendedor no está en la lista de vendedores"));
        listaVendedores.remove(codven);
    }



    public static HashMap<String, vendedor> getListaVendedores() {

        return listaVendedores;
    }



    public static void reservarCoche(String codcli, String matricula) throws Exception {
        if(!listaClientes.containsKey(codcli)) throw new ObjetoNoEncontrado("El cliente no se encuentra en la lista de clientes");
        if(!listaCoches.containsKey(matricula)) throw new ObjetoNoEncontrado("El coche no se encuentra en la lista de coches");
        Cliente cliente = listaClientes.get(codcli);
        Coche coche = listaCoches.get(matricula);
        if (coche.getEstado() != Coche.Estado.enVenta) throw new ParametroNoValido("No se puede reservar.No está en venta");
        coche.setEstado(Coche.Estado.Reservado);
        cliente.getListaReservas().put(coche.getMatricula(), coche);
    }


    public static void cancelarReserva(String codcli, String matricula) throws Exception {
        if(!listaClientes.containsKey(codcli)) throw new ObjetoNoEncontrado("El cliente no se encuentra en la lista de clientes");
        if(!listaCoches.containsKey(matricula)) throw new ObjetoNoEncontrado("El coche no se encuentra en la lista de coches");
        Cliente cliente = listaClientes.get(codcli);
        Coche coche = listaCoches.get(matricula);
        if (cliente.getListaReservas().isEmpty()) throw new ObjetoNoEncontrado("El cliente no tiene reservas disponibles");
        if (!cliente.getListaReservas().containsKey(matricula)) throw new ParametroNoValido("El cliente no tiene reservas con esa matricula");
        coche.setEstado(Coche.Estado.enVenta);
        cliente.getListaReservas().remove(matricula);
    }



}