package com.example.cristian.consultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cristian.consultas.Enfermeras.Enfermeras;
import com.example.cristian.consultas.Medicos.Medicos;
import com.example.cristian.consultas.Pacientes.Paciente;

public class Login extends AppCompatActivity {
Button ver, btnDoctor,pacientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ver=findViewById(R.id.btnver);
        btnDoctor = findViewById(R.id.btnDoctor);
        pacientes=findViewById(R.id.btnPacientes);


        pacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Paciente.class);
                startActivity(intent);
            }
        });


        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Enfermeras.class);
                startActivity(intent);
            }
        });

        btnDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Medicos.class);
                startActivity(intent);
            }
        });
    }
}
