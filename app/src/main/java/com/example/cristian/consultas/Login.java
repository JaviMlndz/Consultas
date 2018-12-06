package com.example.cristian.consultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cristian.consultas.Enfermeras.Enfermeras;
import com.example.cristian.consultas.Medicos.Medicos;
import com.example.cristian.consultas.Pacientes.Paciente;
import com.example.cristian.consultas.api.RetrofitClient;
import com.example.cristian.consultas.model.Consultas;
import com.example.cristian.consultas.model.ModelEnfermera;
import com.example.cristian.consultas.model.ModelMedicos;
import com.example.cristian.consultas.model.ModelPaciente;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
Button btnIngresar;
EditText edtDui, edtClave;
RadioButton rbtPaciente, rbtMedico, rbtEnfermera;
RadioGroup grupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIngresar = findViewById(R.id.btnIngresar);
        edtDui = findViewById(R.id.edtDui);
        edtClave = findViewById(R.id.edtClave);
        rbtEnfermera = findViewById(R.id.rbtEnfermera);
        rbtMedico = findViewById(R.id.rbtMedico);
        rbtPaciente = findViewById(R.id.rbtPaciente);
        grupo=findViewById(R.id.rdbGrupo);






        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ValidarCampos(edtDui)&&!ValidarCampos(edtClave)){

                 if(rbtPaciente.isChecked()||rbtEnfermera.isChecked()||rbtMedico.isChecked()){
                String parametro1=edtDui.getText().toString();
                String parametro2=edtClave.getText().toString();


                if(rbtEnfermera.isChecked()){


                    Call<ModelEnfermera> call =RetrofitClient.getInstance().getApi().getEnfermeraUserPassword(parametro1,parametro2);
                    call.enqueue(new Callback<ModelEnfermera>() {
                        @Override
                        public void onResponse(Call<ModelEnfermera> call, Response<ModelEnfermera> response) {

                            if(response.code()==200){

                                if(response.body()!=null){

                                    Intent objMedico=new Intent(getApplicationContext(), Enfermeras.class);
                                    edtDui.setText("");
                                    edtClave.setText("");
                                    rbtEnfermera.setChecked(false);
                                    startActivity(objMedico);
                                }}}




                        @Override
                        public void onFailure(Call<ModelEnfermera> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Credenciales Invalidas!!! Intente de Nuevo...",Toast.LENGTH_SHORT).show();
                        }
                    });
                }if(rbtMedico.isChecked()){


                    Call<ModelMedicos> call =RetrofitClient.getInstance().getApi().getMedicoUserPassword(parametro1,parametro2);
                    call.enqueue(new Callback<ModelMedicos>() {
                        @Override
                        public void onResponse(Call<ModelMedicos> call, Response<ModelMedicos> response) {

                            if(response.code()==200){

                                if(response.body()!=null){

                                    Intent objMedico=new Intent(getApplicationContext(), Medicos.class);
                                    edtDui.setText("");
                                    edtClave.setText("");
                                    rbtMedico.setChecked(false);
                                    startActivity(objMedico);
                                }}}




                        @Override
                        public void onFailure(Call<ModelMedicos> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Credenciales Invalidas!!! Intente de Nuevo...",Toast.LENGTH_SHORT).show();
                        }
                    });

                }if(rbtPaciente.isChecked()){
                         Call<ModelPaciente> call =RetrofitClient.getInstance().getApi().getPacienteUserPassword(parametro1,parametro2);
                         call.enqueue(new Callback<ModelPaciente>() {
                             @Override
                             public void onResponse(Call<ModelPaciente> call, Response<ModelPaciente> response) {

                                 if(response.code()==200){

                                     if(response.body()!=null){

                                         Intent objMedico=new Intent(getApplicationContext(), Paciente.class);
                                         edtDui.setText("");
                                         edtClave.setText("");
                                         rbtPaciente.setChecked(false);
                                         startActivity(objMedico);
                                     }}}




                             @Override
                             public void onFailure(Call<ModelPaciente> call, Throwable t) {
                                 Toast.makeText(getApplicationContext(),"Credenciales Invalidas!!! Intente de Nuevo...",Toast.LENGTH_SHORT).show();
                             }
                         });
                }
            }else {Toast.makeText(getApplicationContext(),"Debe Seleccionar Tipo Usuario",Toast.LENGTH_SHORT).show();}

                }}
        });





    }



    public boolean ValidarCampos(EditText edtCampo) {
        if (TextUtils.isEmpty(edtCampo.getText().toString())) {
            edtCampo.setError("Campos Requeridos!!!");
            edtCampo.requestFocus();
            return true;
        } else {//Toast.makeText(getApplicationContext(),"Nada",Toast.LENGTH_LONG).show();
            return false;
        }

    }




}
