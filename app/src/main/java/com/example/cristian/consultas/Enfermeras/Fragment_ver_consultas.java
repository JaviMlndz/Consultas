package com.example.cristian.consultas.Enfermeras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cristian.consultas.R;

public class Fragment_ver_consultas extends Fragment {

    Button ver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_ver_consultas,container,false);
        ver=view.findViewById(R.id.btnVeractivityes);

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Expediente.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
