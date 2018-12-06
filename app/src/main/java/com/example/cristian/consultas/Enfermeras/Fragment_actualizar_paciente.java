package com.example.cristian.consultas.Enfermeras;

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

public class Fragment_actualizar_paciente extends Fragment {

    ListView listado_expedientes;
    List<Expedientes> array_listado_expedientes=new ArrayList<>();
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
                        final List<String> nombrea=new ArrayList<String>();
                        final List<String> apellidoa=new ArrayList<String>();
                        final List<Integer> edada=new ArrayList<Integer>();
                        final List<String> correoa=new ArrayList<String>();
                        final List<String> generoa=new ArrayList<String>();
                        final List<String> numeroexpe=new ArrayList<String>();
                        final List<String> ocupaciona=new ArrayList<String>();
                        final List<String> telefonoa=new ArrayList<String>();
                        final List<String> fechanacia=new ArrayList<String>();
                        final List<String> lugarnacia=new ArrayList<String>();
                        final List<String> domicilioa=new ArrayList<String>();
                        final List<String> duia=new ArrayList<String>();
                        final List<String> alergicoa=new ArrayList<String>();
                        final List<String> observacionesa=new ArrayList<String>();

                        if(!array_listado_expedientes.isEmpty()){

                            for (Expedientes e:array_listado_expedientes){
                                lsExpedientes.add("N° Expediente:"+e.getId()+" "+"Dui: "+e.getDui_paciente()+" Paciente: "+e.getNombres());
                                nombrea.add(e.getNombres());
                                apellidoa.add(e.getApellidos());
                                edada.add(e.getEdad());
                                correoa.add(e.getCorreo());
                                generoa.add(e.getGenero());
                                numeroexpe.add(e.getId());
                                ocupaciona.add(e.getOcupacion());
                                telefonoa.add(e.getTelefono());
                                fechanacia.add(e.getFecha_nacimiento());
                                lugarnacia.add(e.getLugar_nacimiento());
                                domicilioa.add(e.getDomicilio());
                                duia.add(e.getDui_paciente());
                                alergicoa.add(e.getAlergias());
                                observacionesa.add(e.getObservaciones());
                            }

                        }
                        ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,lsExpedientes);
                        listado_expedientes.setAdapter(adapter);

                        listado_expedientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                Intent intent =new Intent(getContext(),Expediente.class);
                                intent.putExtra("nombre",nombrea.get(position));
                                intent.putExtra("apellido",apellidoa.get(position));
                                intent.putExtra("edad",edada.get(position));
                                intent.putExtra("correo",correoa.get(position));
                                intent.putExtra("genero",generoa.get(position));
                                intent.putExtra("numero_expe",numeroexpe.get(position));
                                intent.putExtra("ocupacion",ocupaciona.get(position));
                                intent.putExtra("telefono",telefonoa.get(position));
                                intent.putExtra("fecha_nac",fechanacia.get(position));
                                intent.putExtra("lugar_nac",lugarnacia.get(position));
                                intent.putExtra("domicilio",domicilioa.get(position));
                                intent.putExtra("dui",duia.get(position));
                                intent.putExtra("alergia",alergicoa.get(position));
                                intent.putExtra("observa",observacionesa.get(position));
                                startActivity(intent);

                            }
                        });





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
