package com.example.cristian.consultas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Consultas {

    /**
     * "id":1,
     "razonConsulta":"migraña",
     "sintomas":"dolor de cabeza",
     "fecha":"2018-11-04",
     "hora":"8:00am a 9:30am",
     "estadoConsulta":2,
     "duiMedico":"00000001",
     "duiPaciente":"22222223"
     */


    @SerializedName("id")
    @Expose
    private long id;


    @SerializedName("razonConsulta")
    @Expose
    private String razonConsulta;


    @SerializedName("sintomas")
    @Expose
    private String sintomas;


    @SerializedName("fecha")
    @Expose
    private String fecha;


    @SerializedName("hora")
    @Expose
    private String hora;


    @SerializedName("estadoConsulta")
    @Expose
    private int estadoConsulta;


    @SerializedName("duiMedico")
    @Expose
    private String duiMedico;


    @SerializedName("duiPaciente")
    @Expose
    private String duiPaciente;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRazonConsulta() {
        return razonConsulta;
    }

    public void setRazonConsulta(String razonConsulta) {
        this.razonConsulta = razonConsulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getEstadoConsulta() {
        return estadoConsulta;
    }

    public void setEstadoConsulta(int estadoConsulta) {
        this.estadoConsulta = estadoConsulta;
    }

    public String getDuiMedico() {
        return duiMedico;
    }

    public void setDuiMedico(String duiMedico) {
        this.duiMedico = duiMedico;
    }

    public String getDuiPaciente() {
        return duiPaciente;
    }

    public void setDuiPaciente(String duiPaciente) {
        this.duiPaciente = duiPaciente;
    }
}
