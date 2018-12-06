package com.example.cristian.consultas.Medicos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;
import com.example.cristian.consultas.model.Expedientes;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ver_consulta_medico extends Fragment {

    ListView lv_consultaMedico;

    List<Consultas> lista_consultas=new ArrayList<>();
    List<String> lst_consultas = new ArrayList<String>();
    List<String> lst_seleccion = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_ver_consultas_medico,container,false);

        lv_consultaMedico = view.findViewById(R.id.lv_consultaMedico);

        Call<List<Consultas>> call = RetrofitClient.getInstance().getApi().getAllConsultas();

        call.enqueue(new Callback<List<Consultas>>() {
            @Override
            public void onResponse(Call<List<Consultas>> call, Response<List<Consultas>> response) {
                if (response.code() == 200) {

                    if (response.body() != null){

                        lista_consultas.addAll(response.body());



                        if ( !lista_consultas.isEmpty() ){

                            for (Consultas cons : lista_consultas) {
                                lst_consultas.add("DUI paciente: "+cons.getDuiPaciente()+"\n"+"Fecha: "+cons.getFecha()+"\n"+"Hora: "+cons.getHora());
                                lst_seleccion.add(cons.getDuiPaciente());
                            }

                            ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,lst_consultas);
                            lv_consultaMedico.setAdapter(adapter);

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Consultas>> call, Throwable t) {

            }
        });

        lv_consultaMedico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dui=lst_seleccion.get(position);
                Intent objexp = new Intent(getContext(), DetalleConsultas.class);
                objexp.putExtra("duiPaciente",dui);
                startActivity(objexp);
            }
        });


        return view;
    }
}
