package com.example.cristian.consultas.Medicos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cristian.consultas.Enfermeras.Expediente;
import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;
import com.example.cristian.consultas.model.Expedientes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ver_expediente_medico extends Fragment {


    private ListView lista;

    List<Expedientes> lista_expedientes=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_ver_expediente_medico,container,false);

        lista = (ListView)view.findViewById(R.id.lv_prueba);

        Call<List<Expedientes>> call = RetrofitClient.getInstance().getApi().getExpedientes();

        call.enqueue(new Callback<List<Expedientes>>() {
            @Override
            public void onResponse(Call<List<Expedientes>> call, Response<List<Expedientes>> response) {

                if (response.code() == 200) {

                    if (response.body() != null){

                        lista_expedientes.addAll(response.body());

                        List<String> lst_expedientes = new ArrayList<String>();

                        if ( !lista_expedientes.isEmpty() ){

                            for (Expedientes exp : lista_expedientes) {
                                lst_expedientes.add("DUI paciente: "+exp.getDui_paciente()+"\n"+"Nombre: "+exp.getNombres()+"\n"+"Apellido: "+exp.getApellidos()
                                        +"\n"+"Correo: "+exp.getCorreo()+"\n"+"Domicilio: "+exp.getDomicilio()+"\n"+"Fecha de Nacimiento: "+exp.getFecha_nacimiento()
                                        +"\n"+"Lugar de Nacimiento: "+exp.getLugar_nacimiento()+"\n"+"Genero: "+exp.getGenero()+"\n"+"Ocupacion: "+exp.getOcupacion()
                                        +"\n"+"Edad: "+exp.getEdad()+"\n"+"Observaciones: "+exp.getObservaciones()+"\n"+"Alergias: "+exp.getAlergias());
                            }

                            ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,lst_expedientes);
                            lista.setAdapter(adapter);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Expedientes>> call, Throwable t) {

            }
        });


        return view;
    }
}
