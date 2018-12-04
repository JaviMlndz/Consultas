package com.example.cristian.consultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cristian.consultas.Enfermeras.Enfermeras;
import com.example.cristian.consultas.Medicos.Medicos;

public class Login extends AppCompatActivity {
Button ver, btnDoctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ver=findViewById(R.id.btnver);
        btnDoctor = findViewById(R.id.btnDoctor);


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
