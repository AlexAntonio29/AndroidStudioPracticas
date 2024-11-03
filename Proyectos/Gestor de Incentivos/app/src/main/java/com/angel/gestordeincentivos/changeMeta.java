package com.angel.gestordeincentivos;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class changeMeta extends AppCompatActivity {

    //CREACION VARIABLES
    Button bSave ;
    EditText etChange;


    public void changeAllMetas(){

        int proMeta=20;




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_meta);

        //ASIGNACION VARIABLES
        Context context= this;
        bSave= findViewById(R.id.bGuardar);
        etChange=findViewById(R.id.etModficarMeta);

        //LLAMADA DE BASE DE DATOS

        DataBaseIncentiveWeek dbWeek= new DataBaseIncentiveWeek(this);

        String textTvMetafinal="";
        if(!Objects.equals(dbWeek.readLastRowData("meta"), "0"))
            textTvMetafinal = dbWeek.readLastRowData("meta");


        etChange.setText(textTvMetafinal);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textModificado= String.valueOf(etChange.getText());
                if (!textModificado.equals("0")){
                    dbWeek.updateLastRow("meta", textModificado);
                    //SE MODIFICARA TODAS LAS RENOVACIONES QUE NO PASEN DE ESA FECHA
                     changeAllMetas();
                    //TOAST META MODIFICADA
                    Toast.makeText(context, "Meta modificada", Toast.LENGTH_SHORT).show();

                    Intent intent= new Intent(context,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);
                }else  Toast.makeText(context, "La meta no puede ser 0", Toast.LENGTH_LONG).show();

            }
        });


    }



}
