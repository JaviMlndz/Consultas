package com.example.cristian.consultas.Medicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;
import com.example.cristian.consultas.model.Expedientes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleConsultas extends AppCompatActivity {

    TextView txtdetalleconsultas;
    Button btnRegresar;

    List<Consultas> lista_consultas=new ArrayList<Consultas>();
    List<String> lst_consultas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_consultas);

        txtdetalleconsultas = findViewById(R.id.txtdetalleconsulta);
        btnRegresar = findViewById(R.id.btnRegresar);

        final Bundle datos=getIntent().getExtras();
        final String duiPac=datos.getString("duiPaciente");

        Call<List<Consultas>> call =RetrofitClient.getInstance().getApi().getConsultasByPaciente(duiPac);

        call.enqueue(new Callback<List<Consultas>>() {
            @Override
            public void onResponse(Call<List<Consultas>> call, Response<List<Consultas>> response) {

                if (response.code() == 200) {

                    if (response.body() != null){

                        lista_consultas.addAll(response.body());



                        if ( !lista_consultas.isEmpty() ){

                            for (Consultas cons : lista_consultas) {
                                lst_consultas.add("\n"+"ID Consulta: "+cons.getId()+"\n"+"DUI paciente: "+cons.getDuiPaciente()+"\n"+"Fecha: "+cons.getFecha()+"\n"+"Hora: "+cons.getHora()+
                                        "DUI Medico: "+cons.getDuiMedico()+"\n"+"Estado Consulta: "+cons.getEstadoConsulta()+"\n"+"Razon de Consulta: "+cons.getRazonConsulta()+"\n"+
                                        "Sintomas: "+cons.getSintomas()+"\n");
                            }

                            txtdetalleconsultas.setText(lst_consultas.toString());

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Consultas>> call, Throwable t) {

            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
