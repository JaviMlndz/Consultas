package com.example.cristian.consultas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Expedientes {


    @SerializedName("nombres")
    @Expose
    private String nombres;

    @SerializedName("apellidos")
    @Expose
    private String apellidos;

    @SerializedName("domicilio")
    @Expose
    private String domicilio;

    @SerializedName("correo")
    @Expose
    private String correo;

    @SerializedName("telefono")
    @Expose
    private String telefono;

    @SerializedName("genero")
    @Expose
    private String genero;

    @SerializedName("fecha_nacimiento")
    @Expose
    private String fecha_nacimiento;

    @SerializedName("lugar_nacimiento")
    @Expose
    private String lugar_nacimiento;

    @SerializedName("edad")
    @Expose
    private int edad;

    @SerializedName("ocupacion")
    @Expose
    private String ocupacion;

    @SerializedName("observaciones")
    @Expose
    private String observaciones;

    @SerializedName("alergias")
    @Expose
    private String alergias;

    @SerializedName("dui_paciente")
    @Expose
    private String dui_paciente;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getDui_paciente() {
        return dui_paciente;
    }

    public void setDui_paciente(String dui_paciente) {
        this.dui_paciente = dui_paciente;
    }




}
