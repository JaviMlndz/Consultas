package com.example.cristian.consultas.Pacientes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_nueva_cita extends Fragment {

    RadioButton rbthora1, rbthora2, rbthora3, rbthora4, rbthora5, rbthora6;
    EditText edtFecha, edtMotivo, edtSintoma, edtDui;
    Button btnConfirmar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_nueva_cita_consulta, container, false);

        rbthora1 = view.findViewById(R.id.rbthora1);
        rbthora2 = view.findViewById(R.id.rbthora2);
        rbthora3 = view.findViewById(R.id.rbthora3);
        rbthora4 = view.findViewById(R.id.rbthora4);
        rbthora5 = view.findViewById(R.id.rbthora5);
        rbthora6 = view.findViewById(R.id.rbthora6);
        edtFecha = view.findViewById(R.id.edtFecha);
        edtSintoma = view.findViewById(R.id.edtSintoma);
        edtMotivo = view.findViewById(R.id.edtMotivo);
        edtDui = view.findViewById(R.id.edtDui);
        btnConfirmar = view.findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ValidarCampos(edtDui)&&!ValidarCampos(edtFecha)&&!ValidarCampos(edtMotivo)&&!ValidarCampos(edtSintoma)){
                    if(rbthora1.isChecked()||rbthora2.isChecked()||rbthora3.isChecked()||rbthora4.isChecked()||rbthora5.isChecked()||rbthora6.isChecked()){
                        String dui=edtDui.getText().toString().trim();
                        String fecha=edtFecha.getText().toString().trim();
                        String motivo=edtMotivo.getText().toString().trim();
                        String sintoma=edtSintoma.getText().toString().trim();
                        if(rbthora1.isChecked()){
                            String hora="8:30 a 9:30";
                            String duiDoc="00000001";

                            Consultas consulta = new Consultas();
                            consulta.setDuiMedico(duiDoc);
                            consulta.setDuiPaciente(dui);
                            consulta.setEstadoConsulta(1);
                            consulta.setFecha(fecha);
                            consulta.setHora(hora);
                            consulta.setRazonConsulta(motivo);
                            consulta.setSintomas(sintoma);
                            Call<Consultas> callAddConsulta = RetrofitClient
                                    .getInstance()
                                    .getApi().addConsulta(consulta);
                            callAddConsulta.enqueue(new Callback<Consultas>() {
                                @Override
                                public void onResponse(Call<Consultas> call, Response<Consultas> response) {
                                    if (response.code() == 201) {
                                        if (response.body() != null) {
                                        Consultas c = response.body();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("id: " + c.getId() );
                                        Toast.makeText(getContext(),"Cita Registrada con exito!"+sb.toString(),Toast.LENGTH_SHORT).show();
                                    } }
                                }

                                @Override
                                public void onFailure(Call<Consultas> call, Throwable t) {

                                }
                            });

                        }if(rbthora2.isChecked()){
                            String hora="9:30 a 10:30";
                            String duiDoc="00000001";

                            Consultas consulta = new Consultas();
                            consulta.setDuiMedico(duiDoc);
                            consulta.setDuiPaciente(dui);
                            consulta.setEstadoConsulta(1);
                            consulta.setFecha(fecha);
                            consulta.setHora(hora);
                            consulta.setRazonConsulta(motivo);
                            consulta.setSintomas(sintoma);
                            Call<Consultas> callAddConsulta = RetrofitClient
                                    .getInstance()
                                    .getApi().addConsulta(consulta);
                            callAddConsulta.enqueue(new Callback<Consultas>() {
                                @Override
                                public void onResponse(Call<Consultas> call, Response<Consultas> response) {
                                    if (response.code() == 201) {
                                        if (response.body() != null) {
                                            Consultas c = response.body();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("id: " + c.getId() );
                                            Toast.makeText(getContext(),"Cita Registrada con exito!"+sb.toString(),Toast.LENGTH_SHORT).show();
                                        } }
                                }

                                @Override
                                public void onFailure(Call<Consultas> call, Throwable t) {

                                }
                            });


                        }if(rbthora3.isChecked()){
                            String hora="10:30 a 11:30";
                            String duiDoc="00000002";

                            Consultas consulta = new Consultas();
                            consulta.setDuiMedico(duiDoc);
                            consulta.setDuiPaciente(dui);
                            consulta.setEstadoConsulta(1);
                            consulta.setFecha(fecha);
                            consulta.setHora(hora);
                            consulta.setRazonConsulta(motivo);
                            consulta.setSintomas(sintoma);
                            Call<Consultas> callAddConsulta = RetrofitClient
                                    .getInstance()
                                    .getApi().addConsulta(consulta);
                            callAddConsulta.enqueue(new Callback<Consultas>() {
                                @Override
                                public void onResponse(Call<Consultas> call, Response<Consultas> response) {
                                    if (response.code() == 201) {
                                        if (response.body() != null) {
                                            Consultas c = response.body();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("id: " + c.getId() );
                                            Toast.makeText(getContext(),"Cita Registrada con exito!"+sb.toString(),Toast.LENGTH_SHORT).show();
                                        } }
                                }

                                @Override
                                public void onFailure(Call<Consultas> call, Throwable t) {

                                }
                            });


                        }if(rbthora4.isChecked()){
                            String hora="1:30 a 2:30";
                            String duiDoc="00000002";

                            Consultas consulta = new Consultas();
                            consulta.setDuiMedico(duiDoc);
                            consulta.setDuiPaciente(dui);
                            consulta.setEstadoConsulta(1);
                            consulta.setFecha(fecha);
                            consulta.setHora(hora);
                            consulta.setRazonConsulta(motivo);
                            consulta.setSintomas(sintoma);
                            Call<Consultas> callAddConsulta = RetrofitClient
                                    .getInstance()
                                    .getApi().addConsulta(consulta);
                            callAddConsulta.enqueue(new Callback<Consultas>() {
                                @Override
                                public void onResponse(Call<Consultas> call, Response<Consultas> response) {
                                    if (response.code() == 201) {
                                        if (response.body() != null) {
                                            Consultas c = response.body();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("id: " + c.getId() );
                                            Toast.makeText(getContext(),"Cita Registrada con exito!"+sb.toString(),Toast.LENGTH_SHORT).show();
                                        } }
                                }

                                @Override
                                public void onFailure(Call<Consultas> call, Throwable t) {

                                }
                            });


                        }if(rbthora5.isChecked()){
                            String hora="2:30 a 3:30";
                            String duiDoc="00000003";

                            Consultas consulta = new Consultas();
                            consulta.setDuiMedico(duiDoc);
                            consulta.setDuiPaciente(dui);
                            consulta.setEstadoConsulta(1);
                            consulta.setFecha(fecha);
                            consulta.setHora(hora);
                            consulta.setRazonConsulta(motivo);
                            consulta.setSintomas(sintoma);
                            Call<Consultas> callAddConsulta = RetrofitClient
                                    .getInstance()
                                    .getApi().addConsulta(consulta);
                            callAddConsulta.enqueue(new Callback<Consultas>() {
                                @Override
                                public void onResponse(Call<Consultas> call, Response<Consultas> response) {
                                    if (response.code() == 201) {
                                        if (response.body() != null) {
                                            Consultas c = response.body();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("id: " + c.getId() );
                                            Toast.makeText(getContext(),"Cita Registrada con exito!"+sb.toString(),Toast.LENGTH_SHORT).show();
                                        } }
                                }

                                @Override
                                public void onFailure(Call<Consultas> call, Throwable t) {

                                }
                            });


                        }if(rbthora6.isChecked()){
                            String hora="3:30 a 4:30";
                            String duiDoc="00000003";

                            Consultas consulta = new Consultas();
                            consulta.setDuiMedico(duiDoc);
                            consulta.setDuiPaciente(dui);
                            consulta.setEstadoConsulta(1);
                            consulta.setFecha(fecha);
                            consulta.setHora(hora);
                            consulta.setRazonConsulta(motivo);
                            consulta.setSintomas(sintoma);
                            Call<Consultas> callAddConsulta = RetrofitClient
                                    .getInstance()
                                    .getApi().addConsulta(consulta);
                            callAddConsulta.enqueue(new Callback<Consultas>() {
                                @Override
                                public void onResponse(Call<Consultas> call, Response<Consultas> response) {
                                    if (response.code() == 201) {
                                        if (response.body() != null) {
                                            Consultas c = response.body();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("id: " + c.getId() );
                                            Toast.makeText(getContext(),"Cita Registrada con exito!"+sb.toString(),Toast.LENGTH_SHORT).show();
                                        } }
                                }

                                @Override
                                public void onFailure(Call<Consultas> call, Throwable t) {

                                }
                            });


                        }

                    }else {Toast.makeText(getContext(),"Debe Seleccionar un horario",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });






    return view;
    }
    public boolean ValidarCampos(EditText edtCampo) {
        if (TextUtils.isEmpty(edtCampo.getText().toString())) {
            edtCampo.setError("Campos Requeridos!!!");
            edtCampo.requestFocus();
            return true;
        } else {//Toast.makeText(getApplicationContext(),"Nada",Toast.LENGTH_LONG).show();
            return false;
        }

    }

}
