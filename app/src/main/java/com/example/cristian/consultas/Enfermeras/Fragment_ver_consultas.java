package com.example.cristian.consultas.Enfermeras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cristian.consultas.Pacientes.Paciente;
import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ver_consultas extends Fragment {




    private ListView lista;

    List<Consultas> lista_consultas=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_ver_consultas,container,false);
        lista=view.findViewById(R.id.lista_Consultas);


        Call<List<Consultas>> call = RetrofitClient.getInstance().getApi().getAllConsultas();

        call.enqueue(new Callback<List<Consultas>>() {
            @Override
            public void onResponse(Call<List<Consultas>> call, Response<List<Consultas>> response) {

                if (response.code() == 200) {

                    if (response.body() != null){


                        lista_consultas.addAll(response.body());

                        List<String> lsRecetaNombre = new ArrayList<String>();
                        if(!lista_consultas.isEmpty()){
                            for(Consultas c:lista_consultas){
                                lsRecetaNombre.add("Dui: "+c.getDuiMedico()+" "+"Fecha: "+c.getFecha()+" "+"Razon : "+c.getRazonConsulta());
                            }

                            ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,lsRecetaNombre);
                            lista.setAdapter(adapter);

                        }


                    }
                }

            }

            @Override
            public void onFailure(Call<List<Consultas>> call, Throwable t) {

            }
        });
        return view;
    }
}
