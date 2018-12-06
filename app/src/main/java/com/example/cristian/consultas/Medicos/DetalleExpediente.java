package com.example.cristian.consultas.Medicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristian.consultas.Enfermeras.Expediente;
import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Expedientes;
import com.example.cristian.consultas.model.ModelPaciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleExpediente extends AppCompatActivity {

    TextView txtDetalle;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_expediente);

        txtDetalle = findViewById(R.id.txtDetalle);
        btnVolver = findViewById(R.id.btnVolver);

        final Bundle datos=getIntent().getExtras();
        final String duiPac=datos.getString("duiPaciente");

        Call<Expedientes> call =RetrofitClient.getInstance().getApi().getExpedientesDUI(duiPac);

        call.enqueue(new Callback<Expedientes>() {
            @Override
            public void onResponse(Call<Expedientes> call, Response<Expedientes> response) {

                if (response.code() == 200) {

                    if (response.body() != null) {

                        Expedientes exped = response.body();

                        StringBuilder ex = new StringBuilder();
                        ex.append("DATOS GENERALES DEL PACIENTE"+"\n"+"\n");
                        ex.append("DUI: " + exped.getDui_paciente());
                        ex.append("\n");
                        ex.append("Nombre: "+exped.getNombres());
                        ex.append("\n");
                        ex.append("Apellido: "+exped.getApellidos());
                        ex.append("\n");
                        ex.append("Fecha de Nacimiento: "+exped.getFecha_nacimiento());
                        ex.append("\n");
                        ex.append("Lugar de Nacimiento: "+exped.getLugar_nacimiento());
                        ex.append("\n");
                        ex.append("Genero: "+exped.getGenero());
                        ex.append("\n");
                        ex.append("\n");
                        ex.append("DATOS DE CONTACTO DEL PACIENTE"+"\n"+"\n");
                        ex.append("Correo Electronico: "+exped.getCorreo());
                        ex.append("\n");
                        ex.append("Telefono: "+exped.getTelefono());
                        ex.append("\n");
                        ex.append("Domicilio: "+exped.getDomicilio());
                        ex.append("\n");
                        ex.append("Ocupacion: "+exped.getOcupacion());
                        ex.append("\n");
                        ex.append("\n");
                        ex.append("DETALLES MEDICOS DEL PACIENTE"+"\n"+"\n");
                        ex.append("Observaciones: "+exped.getObservaciones());
                        ex.append("\n");
                        ex.append("Alergias: "+exped.getAlergias());
                        ex.append("\n");




                        txtDetalle.setText(ex.toString());
                    }
                }
            }


            @Override
            public void onFailure(Call<Expedientes> call, Throwable t) {

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
