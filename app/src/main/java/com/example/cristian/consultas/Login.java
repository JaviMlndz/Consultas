package com.example.cristian.consultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.cristian.consultas.Enfermeras.Enfermeras;
import com.example.cristian.consultas.Medicos.Medicos;
import com.example.cristian.consultas.Pacientes.Paciente;

public class Login extends AppCompatActivity {
Button btnIngresar;
EditText edtDui, edtClave;
RadioButton rbtPaciente, rbtMedico, rbtEnfermera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIngresar = findViewById(R.id.btnIngresar);
        edtDui = findViewById(R.id.edtDui);
        edtClave = findViewById(R.id.edtClave);
        rbtEnfermera = findViewById(R.id.rbtEnfermera);
        rbtMedico = findViewById(R.id.rbtMedico);
        rbtPaciente = findViewById(R.id.rbtPaciente);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbtEnfermera.isChecked()){
                    Intent objEnfermera=new Intent(getApplicationContext(), Enfermeras.class);
                    startActivity(objEnfermera);
                }if(rbtMedico.isChecked()){
                    Intent objMedico=new Intent(getApplicationContext(), Medicos.class);
                    startActivity(objMedico);
                }if(rbtPaciente.isChecked()){
                    Intent objPaciente=new Intent(getApplicationContext(), Paciente.class);
                    startActivity(objPaciente);
                }
            }
        });





    }
}
