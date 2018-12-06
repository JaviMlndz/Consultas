package com.example.cristian.consultas.Enfermeras;

import android.content.Intent;
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
import com.example.cristian.consultas.model.ModelPaciente;
import com.example.cristian.consultas.model.Paciente;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Enfermera_agregar_paciente extends Fragment {
    EditText edtNombre, edtClave, edtClave2, edtDui, edtCorreo;
    Button btnAgregar, btnRegresar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main_agregar_paciente, container, false);


        edtNombre = view.findViewById(R.id.edtNombre);
        edtClave = view.findViewById(R.id.edtClave);
        edtClave2 = view.findViewById(R.id.edtClave2);
        edtCorreo = view.findViewById(R.id.edtCorreo);
        edtDui = view.findViewById(R.id.edtDui);
        btnAgregar = view.findViewById(R.id.btnAgregar);
       btnRegresar=view.findViewById(R.id.btnRegresar);


btnRegresar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(),Enfermeras.class);
        startActivity(intent);

    }
});
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!ValidarCampos(edtNombre) && !ValidarCampos(edtClave) && !ValidarCampos(edtClave2) && !ValidarCampos(edtDui) && !ValidarCampos(edtCorreo)) {

                    if (validarFormatoCorreo(edtCorreo)) {
                        String nombre = edtNombre.getText().toString().trim();
                        String clave = edtClave.getText().toString().trim();
                        String clave2 = edtClave2.getText().toString().trim();
                        String correo = edtCorreo.getText().toString().trim();
                        String dui = edtDui.getText().toString().trim();

                        if (clave.equals(clave2)) {

                            ModelPaciente paciente = new ModelPaciente();

                            paciente.setClave(clave);
                            paciente.setCorreo(correo);
                            paciente.setDui(dui);
                            paciente.setNombre(nombre);

                            Call<ModelPaciente> callAddPaciente = RetrofitClient
                                    .getInstance().getApi().addPaciente(paciente);

                            callAddPaciente.enqueue(new Callback<ModelPaciente>() {

                                @Override
                                public void onResponse(Call<ModelPaciente> call, Response<ModelPaciente> response) {
                                    if (response.code() == 201) {
                                        if (response.body() != null) {
                                            ModelPaciente p = response.body();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Dui: " + p.getDui());
                                            Toast.makeText(getContext(), "El paciente con " + sb.toString() + " se añadio con exito", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<ModelPaciente> call, Throwable t) {

                                }

                            });
                        } else {
                            Toast.makeText(getContext(), "por favor escriba la misma clave", Toast.LENGTH_SHORT).show();
                            edtClave.setText("");
                            edtClave2.setText("");
                            edtClave.requestFocus();

                        }

                    }else{
                        edtCorreo.setText("");
                        edtCorreo.requestFocus();

                    }

                }else{
                    edtNombre.setText("");
                    edtDui.setText("");
                    edtClave.setText("");
                    edtClave2.setText("");
                    edtCorreo.setText("");

                    edtDui.requestFocus();
                }
            }
        });



        return view;


    }


    public boolean ValidarCampos(EditText edtCampo) {
        if (TextUtils.isEmpty(edtCampo.getText().toString())) {
            edtCampo.setError("Campos Requeridos!!!");
            edtDui.requestFocus();
            return true;
        } else {
            return false;
        }

    }


    public boolean validarFormatoCorreo(EditText campo) {
        String valor = campo.getText().toString().trim();
        if (Patterns.EMAIL_ADDRESS.matcher(valor).matches()) {
            return true;
        } else {
            campo.setError("Formato de correo no válido...");
            campo.requestFocus();
            return false;
        }
    }
}
