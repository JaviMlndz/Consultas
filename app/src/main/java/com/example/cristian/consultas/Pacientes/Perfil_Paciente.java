package com.example.cristian.consultas.Pacientes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cristian.consultas.R;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Expedientes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Perfil_Paciente extends Fragment {

    EditText edtDuiPerfil;
    Button btnVerificarPerfil;
    TextView txtDatosperfil, txtEncabezado;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_perfil_paciente, container, false);

        edtDuiPerfil = view.findViewById(R.id.edtDuiPerfil);
        btnVerificarPerfil = view.findViewById(R.id.btnVerificarPerfil);
        txtDatosperfil = view.findViewById(R.id.txtDatosperfil);
        txtEncabezado = view.findViewById(R.id.txtEncabezado);

        btnVerificarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dui=edtDuiPerfil.getText().toString().trim();

                Call<Expedientes> call =RetrofitClient.getInstance().getApi().getExpedientesDUI(dui);

                call.enqueue(new Callback<Expedientes>() {
                    @Override
                    public void onResponse(Call<Expedientes> call, Response<Expedientes> response) {
                        if (response.code() == 200) {

                            if (response.body() != null) {

                                Expedientes exped = response.body();

                                StringBuilder ex = new StringBuilder();
                                ex.append("DATOS GENERALES"+"\n"+"\n");
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
                                ex.append("DATOS DE CONTACTO"+"\n"+"\n");
                                ex.append("Correo Electronico: "+exped.getCorreo());
                                ex.append("\n");
                                ex.append("Telefono: "+exped.getTelefono());
                                ex.append("\n");
                                ex.append("Domicilio: "+exped.getDomicilio());
                                ex.append("\n");
                                ex.append("Ocupacion: "+exped.getOcupacion());
                                ex.append("\n");
                                ex.append("\n");
                                ex.append("DETALLES MEDICOS"+"\n"+"\n");
                                ex.append("Observaciones: "+exped.getObservaciones());
                                ex.append("\n");
                                ex.append("Alergias: "+exped.getAlergias());
                                ex.append("\n");



                                txtEncabezado.setVisibility(View.VISIBLE);
                                txtDatosperfil.setText(ex.toString());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Expedientes> call, Throwable t) {

                    }
                });
            }
        });

        return view;
    }
}
