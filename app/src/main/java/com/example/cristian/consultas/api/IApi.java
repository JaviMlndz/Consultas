package com.example.cristian.consultas.api;

import com.example.cristian.consultas.Pacientes.Paciente;
import com.example.cristian.consultas.model.Consultas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApi {

    @POST("paciente")
    Call<Paciente> addPaciente(@Body Paciente paciente);

    @GET("paciente")
    Call<List<Paciente>> getAllPacientes();

    @GET("paciente/{dui}")
    Call<Integer> getPacienteByDui(@Path("dui") String dui);


    @GET("consulta")
    Call<List<Consultas>> getAllConsultas();

    @GET("consulta/paciente/{duiPaciente}")
    Call<List<Consultas>> getConsultasByPaciente(@Path("duiPaciente") String duiPaciente);

    @GET("consulta/medico/{duiMedico}")
    Call<List<Consultas>> getConsultasByMedico(@Path("duiMedico") String duiMedico);

    @POST("consulta")
    Call<Consultas> addConsulta(@Body Consultas consulta);

}
