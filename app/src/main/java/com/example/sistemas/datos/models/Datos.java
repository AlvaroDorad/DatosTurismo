package com.example.sistemas.datos.models;

/**
 * Created by sistemas on 23/04/18.
 */

public class Datos {


    private String correo_electronico;

    private String direcci_n;

    private String nombre_del_operador;

    private String prestador_del_servicio_turistico;

    private String servicio_que_presta;

    private String telefono;

    public String getCorreoElectronico() {
        return correo_electronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correo_electronico = correoElectronico;
    }

    public String getDirecciN() {
        return direcci_n;
    }

    public void setDirecciN(String direcciN) {
        this.direcci_n = direcciN;
    }

    public String getNombreDelOperador() {
        return nombre_del_operador;
    }

    public void setNombreDelOperador(String nombreDelOperador) {
        this.nombre_del_operador = nombreDelOperador;
    }

    public String getPrestadorDelServicioTuristico() {
        return prestador_del_servicio_turistico;
    }

    public void setPrestadorDelServicioTuristico(String prestadorDelServicioTuristico) {
        this.prestador_del_servicio_turistico = prestadorDelServicioTuristico;
    }

    public String getServicioQuePresta() {
        return servicio_que_presta;
    }

    public void setServicioQuePresta(String servicioQuePresta) {
        this.servicio_que_presta = servicioQuePresta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}