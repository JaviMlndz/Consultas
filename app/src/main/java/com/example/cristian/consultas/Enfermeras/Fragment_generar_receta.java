package com.example.cristian.consultas.Enfermeras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.ModelPaciente;
//import com.example.cristian.consultas.model.Recetas;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Fragment_generar_receta extends Fragment {

    Button btnGenerar;
    EditText edtFecha, edtFarmaco, edtUnidades, edtPauta, edtIndicaciones, edtDuiEnfermera;
    Spinner spinnerDui;
    List<ModelPaciente> pacientes = new ArrayList<>();
    List<String> duis = new ArrayList<>();
    static int id_receta = 1;
    ArrayAdapter<String> adapter;
   // String dui_paciente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_generar_receta,container,false);

        edtFecha = view.findViewById(R.id.edtFecha);
        edtFarmaco = view.findViewById(R.id.edtFarmaco);
        edtUnidades = view.findViewById(R.id.edtUnidades);
        edtPauta = view.findViewById(R.id.edtPauta);
        edtIndicaciones = view.findViewById(R.id.edtIndicaciones);
        spinnerDui = view.findViewById(R.id.spinnerDui);
        btnGenerar = view.findViewById(R.id.btnGenerar);
        edtDuiEnfermera = view.findViewById(R.id.edtDuiEnfermera);




        Calendar calendar = Calendar.getInstance();

        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = formatter.format(calendar.getTime());


        edtFecha.setEnabled(false);
        edtFecha.setText(fechaActual.toString());

        Call<List<ModelPaciente>> call = RetrofitClient.getInstance().getApi().getAllPacientes();
        call.enqueue(new Callback<List<ModelPaciente>>() {
            @Override
            public void onResponse(Call<List<ModelPaciente>> call, Response<List<ModelPaciente>> response) {

                if(response.code()==200){

                    if (response.body()!=null){
                        pacientes.addAll(response.body());


                        if (!pacientes.isEmpty()){
                            for (ModelPaciente paciente: pacientes){

                                duis.add(paciente.getDui());
                            }

                            adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, duis);
                            spinnerDui.setAdapter(adapter);





                        }


                    }
                }

            }

            @Override
            public void onFailure(Call<List<ModelPaciente>> call, Throwable t) {

            }
        });






        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!ValidarCampos(edtDuiEnfermera) && !ValidarCampos(edtFarmaco) && !ValidarCampos(edtUnidades) && !ValidarCampos(edtPauta)
                        && !ValidarCampos(edtIndicaciones)){

                    String  dui_enfermera = edtDuiEnfermera.getText().toString().trim();
                    String farmaco = edtFarmaco.getText().toString().trim();
                    String fecha = edtFecha.getText().toString().trim();
                    String indicacione = edtIndicaciones.toString().trim();
                    String pauta = edtPauta.toString().trim();
                    String unidades = edtUnidades.toString().trim();
                    //Recetas receta = new Recetas();


             /*       receta.setDuiEnfermera(dui_enfermera);
                    //receta.setDuiPaciente(dui_paciente);
                    receta.setFarmaco(farmaco);
                    receta.setUnidades(Integer.parseInt(unidades));
                    receta.setIndicacionesFarmaco(indicacione);
                    receta.setFechaPrescripcion(fecha);
                    receta.setId(id_receta);*/

                    edtIndicaciones.setText("");
                    edtDuiEnfermera.setText("");
                    edtFarmaco.setText("");
                    edtPauta.setText("");
                    edtUnidades.setText("");

                    Toast.makeText(getContext(), "Receta Generada con exito", Toast.LENGTH_SHORT).show();


                    //  Call<Recetas> callAddReceta = RetrofitClient.getInstance().getApi().addConsulta()




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

