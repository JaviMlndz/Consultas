package com.example.cristian.consultas.Pacientes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cristian.consultas.R;

public class Ayuda_Paciente extends Fragment {

    TextView txtayuda;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ayuda_paciente, container, false);

        txtayuda = view.findViewById(R.id.txtInfo);

        txtayuda.setText("\n"+"\n"+"Para realizar modificaciones en sus datos es necesario acercarse a las clínica para que una enfermera le realize la actualización"+"\n"+
        "\n"+"\n"+"\n"+"Si usted realiza una reservación recuerde estar atento y acudir a ella"+"\n"+"\n"+"\n"+"\n"+"Universidad Tecnologica de El Salvador"+"\n"+"Todos los derechos reservados - 2018");

        return view;
    }
}
