package com.example.cristian.consultas.Enfermeras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Expedientes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                        if(!ValidarCampos(nombre)&&!ValidarCampos(apellidos)&&!ValidarCampos(edad)&&!ValidarCampos(correo)&&!ValidarCampos(genero)&&!ValidarCampos(ocupacion)&&!ValidarCampos(fecha_nacimiento)&&!ValidarCampos(lugar_nacimiento)&&!ValidarCampos(domicilio)&&!ValidarCampos(alergico)&&!ValidarCampos(observaciones)&&!ValidarCampos(dui)&&!ValidarCampos(telefono)) {

                        if(ValidarCorreo(correo)){
                            Expedientes expedientes=new Expedientes();
                            expedientes.setNombres("cristian");
                            expedientes.setApellidos("castro monotya");
                            expedientes.setDomicilio("al infinito y mas alla");
                            expedientes.setCorreo("cristian@gmail.com");
                            expedientes.setTelefono("4578-1265");
                            expedientes.setGenero("masculino");
                            expedientes.setFecha_nacimiento("2018-11-05");
                            expedientes.setLugar_nacimiento("santa tecla");
                            expedientes.setEdad(52);
                            expedientes.setOcupacion("programador");
                            expedientes.setObservaciones("en las ultimas");
                            expedientes.setAlergias("N/A");
                            expedientes.setDui_paciente("22222227");

                            String duiPaciente="22222227";

                            Call<Expedientes> call=RetrofitClient.getInstance().getApi().updateExpedienteDui(expedientes,duiPaciente);

                            call.enqueue(new Callback<Expedientes>() {
                                @Override
                                public void onResponse(Call<Expedientes> call, Response<Expedientes> response) {
                                    if(response.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Registro Insertado Correctamente",Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"Registro No Insertado Correctamente",Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Expedientes> call, Throwable t) {

                                }
                            });



                        } else {
                            Toast.makeText(getApplicationContext(),"Formato de Correo Incorreto!!!",Toast.LENGTH_SHORT).show();
                        }


                        }

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
    public boolean ValidarCampos(EditText edtCampo)
    {
        if(TextUtils.isEmpty(edtCampo.getText().toString())){
            edtCampo.setError("Campo Requerido!!");
            edtCampo.requestFocus();
            return true;
        }


        else {return  false;}
    }

    public boolean ValidarCorreo(EditText edtCorreo){

        return Patterns.EMAIL_ADDRESS.matcher(edtCorreo.getText().toString()).matches();
    }
}
