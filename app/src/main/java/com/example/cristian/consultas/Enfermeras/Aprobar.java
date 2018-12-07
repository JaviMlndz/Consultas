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
import android.widget.TextView;
import android.widget.Toast;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;

public class Aprobar extends AppCompatActivity {
    TextView fecha,hora,dui,razzon;
   EditText estado,dui_doctor;
    Button cancelar,confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprobar);

        fecha=findViewById(R.id.txtFecha);
        hora=findViewById(R.id.txtHora);
        dui=findViewById(R.id.txtDuiPaciente);
        razzon=findViewById(R.id.txtRazon);
        estado=findViewById(R.id.edtEstado);
        dui_doctor=findViewById(R.id.edtDuiDoctor);



        cancelar=findViewById(R.id.btnCancelarEstado);
        confirmar=findViewById(R.id.btnConfirmarEstado);


        final Bundle LosDatos=getIntent().getExtras();
        fecha.setText(LosDatos.getString("fecha"));
        hora.setText(LosDatos.getString("hora"));
        dui.setText(LosDatos.getString("dui"));
        razzon.setText(LosDatos.getString("razon"));




        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int estado_actual=0;
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

                if(estado.equals("Aprobado")||estado.equals("aprobado")||estado.equals("APROBADO")){estado_actual=1;}
                if(estado.equals("Desaprobado")||estado.equals("desaprobado")||estado.equals("DESAPROBADO")){estado_actual=0;}

                //consultas.setDuiMedico(dui.getText().toString());
                //consultas.setEstadoConsulta(estado_nuevo);
                consultas.setDuiMedico(dui_doctor.getText().toString());
                consultas.setEstadoConsulta(estado_actual);


                String dui_paciente=LosDatos.getString("dui");
                int estado=LosDatos.getInt("est");
                String fecha_actual=LosDatos.getString("fecha");

               retrofit2.Call<Consultas> call=RetrofitClient.getInstance().getApi().modificarConsulta(consultas,dui_paciente,estado,fecha_actual );//datos actuale
                call.enqueue(new Callback<Consultas>() {
                    @Override
                    public void onResponse(retrofit2.Call<Consultas> call, Response<Consultas> response) {

                       // Toast.makeText(Aprobar.this, "HTTP: " + response.code(), Toast.LENGTH_SHORT).show();

                        if(response.code()==200){

                            if (response.body()!= null){

                                Toast.makeText(getApplicationContext(),"Estado de Consulta Modificado",Toast.LENGTH_SHORT).show();
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
