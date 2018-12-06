package com.example.cristian.consultas.Enfermeras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cristian.consultas.R;

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
