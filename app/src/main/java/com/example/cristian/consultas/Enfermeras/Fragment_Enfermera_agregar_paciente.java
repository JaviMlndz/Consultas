package com.example.cristian.consultas.Enfermeras;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cristian.consultas.R;

public class Fragment_Enfermera_agregar_paciente extends Fragment {



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_agregar_paciente,container,false);



        return view;
    }
}
