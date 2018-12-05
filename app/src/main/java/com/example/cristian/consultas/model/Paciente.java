package com.example.cristian.consultas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paciente {


    @SerializedName("dui")
    @Expose
    private long dui;


    @SerializedName("nombre")
    @Expose
    private String nombre;


    @SerializedName("clave")
    @Expose
    private String clave;


    @SerializedName("correo")
    @Expose
    private String correo;


    public long getDui() {
        return dui;
    }

    public void setDui(long dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
