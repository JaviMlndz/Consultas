package com.example.cristian.consultas.api;

import com.example.cristian.consultas.Medicos.Medicos;
import com.example.cristian.consultas.Pacientes.Paciente;
import com.example.cristian.consultas.model.Consultas;
import com.example.cristian.consultas.model.Expedientes;
import com.example.cristian.consultas.model.ModelEnfermera;
import com.example.cristian.consultas.model.ModelExpediente;
import com.example.cristian.consultas.model.ModelMedicos;
import com.example.cristian.consultas.model.ModelPaciente;
import com.example.cristian.consultas.model.Receta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IApi {


    @PUT ("consulta/{duiCliente}/{estadoConsulta}/{fechaConsulta}")
    Call<Consultas> modificarConsulta(@Body Consultas consultas,@Path("duiCliente") String duiCliente,
                                      @Path("estadoConsulta") int estadoConsulta,
                                      @Path("fechaConsulta") String fechaConsulta);


    @POST("paciente")
    Call<ModelPaciente> addPaciente(@Body ModelPaciente paciente);

   @GET("paciente")
    Call<List<ModelPaciente>> getAllPacientes();

    @GET("paciente/{dui}")
    Call<Integer> getPacienteByDui(@Path("dui") String dui);


    @GET("consulta")
    Call<List<Consultas>> getAllConsultas();

    @GET("consulta/paciente/{duiPaciente}")
    Call<List<Consultas>> getConsultasByPaciente(@Path("duiPaciente") String duiPaciente);

    @GET("consulta/medico/{duiMedico}")
    Call<List<Consultas>> getConsultasByMedico(@Path("duiMedico") String duiMedico);

    @POST("expediente")
    Call<Expedientes> addmodelExpediente(@Body Expedientes modelExpediente);

    @POST("consulta")
    Call<Consultas> addConsulta(@Body Consultas consulta);

    @POST("recetas")
    Call<Receta> addReceta(@Body Receta receta);

    @GET("expediente")
    Call<List<Expedientes>> getExpedientes();

    @GET("medico/{duiMedico}/{clave}")
    Call<ModelMedicos> getMedicoUserPassword(@Path("duiMedico")String dui, @Path("clave") String clave  );

    @GET("paciente/{duiPaciente}/{clave}")
    Call<ModelPaciente> getPacienteUserPassword(@Path("duiPaciente")String dui, @Path("clave") String clave  );

    @GET("enfermera/{duiPaciente}/{clave}")
    Call<ModelEnfermera> getEnfermeraUserPassword(@Path("duiPaciente")String dui, @Path("clave") String clave  );

    @GET("expediente/{duiPaciente}")
    Call<Expedientes> getExpedientesDUI(@Path("duiPaciente") String duiPaciente);

    @PUT("expediente/{duiPaciente}")
     Call<Expedientes>  updateExpedienteDui(@Body Expedientes expedientes,@Path("duiPaciente") String duiPaciente);


}
