package com.angel.gestordeincentivos;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class PersonalDataActivity extends AppCompatActivity {

    Context context;
    Button bGuardar, bRegresar;
    LinearLayout mparent;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        this.context=this;
        mparent=findViewById(R.id.llContenedorDatosPersonales);
        bGuardar= findViewById(R.id.bGuardarPersonalData);
        bRegresar=findViewById(R.id.bRegresarDatosPersonales);

        LayoutInflater inflater= LayoutInflater.from(context);







        String[] listaDatosPersonales={"Nombre","Apellidos","Numero Telefonico","Email"};
        String[] listaEtx={"Ingrese el Nombre", "Ingrese el apellido","Ingrese su numero telefonico", "Ingrese su correo"};


        for (int i=0;i<listaDatosPersonales.length;i++){

            View myview =inflater.inflate(R.layout.item_datos_personales,null,false);

            TextView titulo= myview.findViewById(R.id.tvTitleDatosPersonales);
            EditText getText=myview.findViewById(R.id.etText);

            titulo.setText(listaDatosPersonales[i]);
            getText.setHint(listaEtx[i]);


            mparent.addView(myview);




        }

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
