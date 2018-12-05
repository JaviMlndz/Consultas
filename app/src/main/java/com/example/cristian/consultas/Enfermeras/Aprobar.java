package com.example.cristian.consultas.Enfermeras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cristian.consultas.R;

public class Aprobar extends AppCompatActivity {
    EditText fecha,hora,dui,paciente;
    Spinner doctores,estado;
    Button cancelar,confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprobar);

        fecha=findViewById(R.id.edtFechaEstado);
        hora=findViewById(R.id.edtHoraEstado);
        dui=findViewById(R.id.edtDuiEstado);
        paciente=findViewById(R.id.edtPacienteEstado);

        doctores=findViewById(R.id.spinerDoctor);
        estado=findViewById(R.id.spinerEstado);

        cancelar=findViewById(R.id.btnCancelarEstado);
        confirmar=findViewById(R.id.btnConfirmarEstado);


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
