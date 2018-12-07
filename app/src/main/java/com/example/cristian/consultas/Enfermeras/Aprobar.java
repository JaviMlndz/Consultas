package com.example.cristian.consultas.Enfermeras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;

public class Aprobar extends AppCompatActivity {
    EditText fecha,hora,dui,razzon;
    Spinner doctores,estado;
    Button cancelar,confirmar;
    ArrayList estado_consulta=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprobar);

        fecha=findViewById(R.id.edtFechaEstado);
        hora=findViewById(R.id.edtHoraEstado);
        dui=findViewById(R.id.edtDuiEstado);
        razzon=findViewById(R.id.edtRazonEstado);

        doctores=findViewById(R.id.spinerDoctor);
        estado=findViewById(R.id.spinerEstado);

        cancelar=findViewById(R.id.btnCancelarEstado);
        confirmar=findViewById(R.id.btnConfirmarEstado);
        estado_consulta.add("--Seleccione--");
        estado_consulta.add("Aprobado");
        estado_consulta.add("Denegado");
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,estado_consulta);
        estado.setAdapter(adapter);
        Bundle LosDatos=getIntent().getExtras();
        fecha.setText(LosDatos.getString("fecha"));
        hora.setText(LosDatos.getString("hora"));
        dui.setText(LosDatos.getString("dui"));
        razzon.setText(LosDatos.getString("razon"));




        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Consultas consultas=new Consultas();
                        /*"id":1,
                        "razonConsulta":"migraña",
                        "sintomas":"dolor de cabeza",
                        "fecha":"2018-11-04",
                        "hora":"8:00am a 9:30am",
                        "estadoConsulta":1,
                        "duiMedico":"00000001",
                        "duiPaciente":"22222223"*/

                //datos nuevos
                consultas.setDuiMedico("00000003");
                consultas.setEstadoConsulta(8);

                String dui="22222223";
                int estado=2;
                String fecha="2018-11-04";

               retrofit2.Call<Consultas> call=RetrofitClient.getInstance().getApi().modificarConsulta(consultas,dui,estado,fecha );//datos actuale
                call.enqueue(new Callback<Consultas>() {
                    @Override
                    public void onResponse(retrofit2.Call<Consultas> call, Response<Consultas> response) {

                        Toast.makeText(Aprobar.this, "HTTP: " + response.code(), Toast.LENGTH_SHORT).show();

                        if(response.code()==200){

                            if (response.body()!= null){

                                Toast.makeText(getApplicationContext(),"holo",Toast.LENGTH_SHORT).show();
                            }else{

                                Toast.makeText(Aprobar.this, "BODY is NULL", Toast.LENGTH_SHORT).show();
                            }


                        }else{

                            Toast.makeText(Aprobar.this, "HTTP CODE: " + response.code(), Toast.LENGTH_SHORT).show();
                        }

                        //Log.v("Aprobar: " , "body: " +  response.body().getDuiMedico());
                    }

                    @Override
                    public void onFailure(retrofit2.Call<Consultas> call, Throwable t) {

                    }
                });



            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
