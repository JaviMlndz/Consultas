package com.example.cristian.consultas.Enfermeras;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Fragment_actualizar_paciente extends Fragment {

    ListView listado_expedientes;
    List<Expedientes> array_listado_expedientes=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_actualizar_paciente,container,false);
        listado_expedientes=view.findViewById(R.id.lista_expedientes);

        Call<List<Expedientes>> call =RetrofitClient.getInstance().getApi().getExpedientes();
        call.enqueue(new Callback<List<Expedientes>>() {
            @Override
            public void onResponse(Call<List<Expedientes>> call, Response<List<Expedientes>> response) {

                if(response.code()==200){
                    if(response.body()!=null){

                        array_listado_expedientes.addAll(response.body());

                        List<String> lsExpedientes=new ArrayList<String>();
                        if(!array_listado_expedientes.isEmpty()){

                            for (Expedientes e:array_listado_expedientes){

                                lsExpedientes.add("N° Expediente:"+e.getId()+" "+"Dui: "+e.getDui_paciente()+" Paciente: "+e.getNombres());
                            }

                        }
                        ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,lsExpedientes);
                        listado_expedientes.setAdapter(adapter);





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
