package com.example.cristian.consultas.Enfermeras;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Expedientes;
import com.example.cristian.consultas.model.ModelExpediente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Fragment_nuevo_expediente extends Fragment {


    EditText nombre,apellidos,edad,correo,telefono,ocupacion,fecha_nacimiento,lugar_nacimiento,genero,dui,domicilio,alergias,observaciones;
    Button agregar_expediente;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_nuevo_expediente,container,false);
        nombre=view.findViewById(R.id.edtNombreExpe);
                apellidos=view.findViewById(R.id.edtApellidosExpe);
        edad=view.findViewById(R.id.edtEdadExpe);
                correo=view.findViewById(R.id.edtCorreoExpe);
        telefono=view.findViewById(R.id.edtTelefonoExpe);
                ocupacion=view.findViewById(R.id.edtOcupacionExpe);
        fecha_nacimiento=view.findViewById(R.id.edtLugarNacExpe);
                lugar_nacimiento=view.findViewById(R.id.edtLugarNacExpe);
        genero=view.findViewById(R.id.edtGeneroExpe);
                dui=view.findViewById(R.id.edtDuiExpe);

        domicilio=view.findViewById(R.id.edtDomicilioExpe);
                alergias=view.findViewById(R.id.edtAlergiasExpe);
        observaciones=view.findViewById(R.id.edtObservacionesExpe);
                agregar_expediente=view.findViewById(R.id.btnAgregarExpediente);


                agregar_expediente.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    if(!ValidarCampos(nombre)&&!ValidarCampos(apellidos)&&!ValidarCampos(edad)&&!ValidarCampos(correo)&&!ValidarCampos(genero)&&!ValidarCampos(ocupacion)&&!ValidarCampos(fecha_nacimiento)&&!ValidarCampos(lugar_nacimiento)&&!ValidarCampos(domicilio)&&!ValidarCampos(alergias)&&!ValidarCampos(observaciones)&&!ValidarCampos(dui)&&!ValidarCampos(telefono)){

                        if(ValidarCorreo(correo)){

                            Expedientes expedientes=new Expedientes();

                            expedientes.setNombres(nombre.getText().toString());
                            expedientes.setApellidos(apellidos.getText().toString());
                            expedientes.setEdad(Integer.parseInt(edad.getText().toString()));
                            expedientes.setCorreo(correo.getText().toString());
                            expedientes.setTelefono(telefono.getText().toString());
                            expedientes.setGenero(genero.getText().toString());
                            expedientes.setOcupacion(ocupacion.getText().toString());
                            expedientes.setLugar_nacimiento(lugar_nacimiento.getText().toString());
                            expedientes.setFecha_nacimiento(fecha_nacimiento.getText().toString());
                            expedientes.setDui_paciente(dui.getText().toString());
                            expedientes.setDomicilio(domicilio.getText().toString());
                            expedientes.setAlergias(alergias.getText().toString());
                            expedientes.setObservaciones(observaciones.getText().toString());

                            /*expedientes.setNombres("miguel");
                            expedientes.setApellidos("lopez");
                            expedientes.setDomicilio("al infinito y mas alla");
                            expedientes.setCorreo("miguel@gmail.com");
                            expedientes.setTelefono("4578-1265");
                            expedientes.setGenero("masculino");
                            expedientes.setFecha_nacimiento("2018-11-05");
                            expedientes.setLugar_nacimiento("santa tecla");
                            expedientes.setEdad(52);
                            expedientes.setOcupacion("programador");
                            expedientes.setObservaciones("en las ultimas");
                            expedientes.setAlergias("N/A");
                            expedientes.setDui_paciente("11111111");*/


                            Call<Expedientes> call=RetrofitClient.getInstance().getApi().addmodelExpediente(expedientes);
                            call.enqueue(new Callback<Expedientes>() {
                                @Override
                                public void onResponse(Call<Expedientes> call, Response<Expedientes> response) {

                                    if(response.code()==201){

                                        if(response.body()!=null){

                                            Toast.makeText(getContext(),"Registro Insertado Satisfactoriamente",Toast.LENGTH_SHORT).show();

                                        }




                                    }else { Toast.makeText(getContext(),"Insercion de Registro  Fallido!!",Toast.LENGTH_SHORT).show();}


                                }

                                @Override
                                public void onFailure(Call<Expedientes> call, Throwable t) {

                                    Toast.makeText(getContext(),"Insercion Fallida!!!",Toast.LENGTH_SHORT).show();

                                }
                            });



                        }
                        else {
                            Toast.makeText(getContext(),"Formato de Correo Incorreto!!!",Toast.LENGTH_SHORT).show();
                        }

                    }
                    }
                });


        return view;
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
