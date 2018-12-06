package com.example.cristian.consultas.Enfermeras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cristian.consultas.R;

public class Expediente extends AppCompatActivity {

    EditText numero_expediente,edad,nombre,apellidos,genero,ocupacion,telefono,correo,fecha_nacimiento,lugar_nacimiento,domicilio,dui,alergico,observaciones;
    Button cancelar,guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expediente);
        numero_expediente=findViewById(R.id.edtNum_expediente);
                edad=findViewById(R.id.edtEdadexpediente);
        nombre=findViewById(R.id.edtNombre);
                apellidos=findViewById(R.id.edtApellidoexpediente);
        genero=findViewById(R.id.edtGenero);
                ocupacion=findViewById(R.id.edtOcupacionexpediente);
        telefono=findViewById(R.id.edtTelefono);
                correo=findViewById(R.id.edtCorreo);
        fecha_nacimiento=findViewById(R.id.edtFechaNacimiento);
                lugar_nacimiento=findViewById(R.id.edtLugarNacimiento);
        domicilio=findViewById(R.id.edtDomicilio);
                dui=findViewById(R.id.edtDui);
        alergico=findViewById(R.id.edtAlergia);
                observaciones=findViewById(R.id.edtObservaciones);

                cancelar=findViewById(R.id.btnCancelarExpediente);
                guardar=findViewById(R.id.btnGuardarExpediente);

                Bundle Datos=getIntent().getExtras();
                numero_expediente.setText(Datos.getString("numero_expe"));
                nombre.setText(Datos.getString("nombre"));
                apellidos.setText(Datos.getString("apellido"));
                edad.setText(String.valueOf(Datos.getInt("edad")));
                telefono.setText(Datos.getString("telefono"));
                genero.setText(Datos.getString("genero"));
                ocupacion.setText(Datos.getString("ocupacion"));
                dui.setText(Datos.getString("dui"));
                fecha_nacimiento.setText(Datos.getString("fecha_nac"));
                lugar_nacimiento.setText(Datos.getString("lugar_nac"));
                domicilio.setText(Datos.getString("domicilio"));
                alergico.setText(Datos.getString("alergia"));
                observaciones.setText(Datos.getString("observa"));
                correo.setText(Datos.getString("correo"));




                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),Enfermeras.class);
                        startActivity(intent);
                    }
                });
    }
}
