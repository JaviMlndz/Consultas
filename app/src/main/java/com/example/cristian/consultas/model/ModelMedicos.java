package com.example.cristian.consultas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelMedicos {



    @SerializedName("dui")
    @Expose
    private String dui;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("clave")
    @Expose
    private String clave;

    @SerializedName("correo")
    @Expose
    private String correo;

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
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
