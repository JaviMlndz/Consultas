package com.example.cristian.consultas.Enfermeras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristian.consultas.Pacientes.Paciente;
import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ver_consultas extends Fragment {

//    Button ver;

    private TextView tvConsultas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_ver_consultas,container,false);

//        ver=view.findViewById(R.id.btnVeractivityes);

//        ver.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getContext(),Expediente.class);
//                startActivity(intent);
//            }
//        });

        tvConsultas = view.findViewById(R.id.tv_consultas);

//        Call<List<Consultas>> call = RetrofitClient.getInstance().getApi().getAllConsultas();
//
//        call.enqueue(new Callback<List<Consultas>>() {
//            @Override
//            public void onResponse(Call<List<Consultas>> call, Response<List<Consultas>> response) {
//
//                if (response.code() == 200) {
//
//                    if (response.body() != null){
//
//                        List<Consultas> consultas =  response.body();
//
//                        if ( !consultas.isEmpty() ){
//
//                            StringBuilder sb = new StringBuilder();
//
//                            for (Consultas consulta : consultas) {
//
//                                sb.append("idConsulta: " +  consulta.getId());
//                                sb.append("\n");
//                                sb.append("duiPaciente: " +  consulta.getDuiPaciente());
//                                sb.append("\n");
//                                sb.append("duiMedico: " +  consulta.getDuiMedico());
//                                sb.append("\n");
//                                sb.append("fecha: " +  consulta.getFecha());
//                                sb.append("\n");
//                                sb.append("sintomas: " +  consulta.getSintomas());
//                                sb.append("\n");
//                                sb.append("hora: " +  consulta.getHora());
//                                sb.append("\n\n");
//
//                            }
//
//                            tvConsultas.setText(sb.toString());
//                        }
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Consultas>> call, Throwable t) {
//
//            }
//        });


        /**
         * haciendo un post a consultar (insertar consulta)
         */

        Consultas consulta = new Consultas();
        consulta.setDuiMedico("00000001");
        consulta.setDuiPaciente("22222223");
        consulta.setEstadoConsulta(1);
        consulta.setFecha("2018-12-05");
        consulta.setHora("8:00am a 10:30am");
        consulta.setRazonConsulta("dolor de pelo");
        consulta.setSintomas("le cayo lejia");

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
                        sb.append("razonConsulta: " + c.getRazonConsulta() );
                        sb.append("sintomas: " + c.getSintomas() );
                        sb.append("fecha: " + c.getFecha() );

                        tvConsultas.setText(sb.toString());

                    }
                }
            }

            @Override
            public void onFailure(Call<Consultas> call, Throwable t) {

            }
        });


        return view;
    }
}
