package com.example.cristian.consultas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Receta {

//            "fechaPrescripcion":"2018-11-03",
//            "farmaco":"Ibuprufeno",
//            "unidades":45,
//            "pauta":"2 cada 4 horas",
//            "indicacionesFarmaco":"consumir hasta acabar con el tratamiento",
//            "duiPaciente":"22222223",
//            "duiEnfermera":"11111111"


    @SerializedName("fechaPrescripcion")
    @Expose
    private String fechaPrescripcion;

    @SerializedName("farmaco")
    @Expose
    private String farmaco;

    @SerializedName("unidades")
    @Expose
    private int unidades;

    @SerializedName("pauta")
    @Expose
    private String pauta;

    @SerializedName("indicacionesFarmaco")
    @Expose
    private String indicacionesFarmaco;

    @SerializedName("duiPaciente")
    @Expose
    private String duiPaciente;

    @SerializedName("duiEnfermera")
    @Expose
    private String duiEnfermera;

    public String getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    public void setFechaPrescripcion(String fechaPrescripcion) {
        this.fechaPrescripcion = fechaPrescripcion;
    }

    public String getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(String farmaco) {
        this.farmaco = farmaco;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getIndicacionesFarmaco() {
        return indicacionesFarmaco;
    }

    public void setIndicacionesFarmaco(String indicacionesFarmaco) {
        this.indicacionesFarmaco = indicacionesFarmaco;
    }

    public String getDuiPaciente() {
        return duiPaciente;
    }

    public void setDuiPaciente(String duiPaciente) {
        this.duiPaciente = duiPaciente;
    }

    public String getDuiEnfermera() {
        return duiEnfermera;
    }

    public void setDuiEnfermera(String duiEnfermera) {
        this.duiEnfermera = duiEnfermera;
    }
}
