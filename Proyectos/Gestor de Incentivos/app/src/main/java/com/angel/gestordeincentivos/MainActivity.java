package com.angel.gestordeincentivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.context=this;
        DataBaseIncentiveWeek dbWeek = new DataBaseIncentiveWeek(this);
        dbWeek.insertRowOnceAWeek();
        //Toast.makeText(this,"Week: "+dbWeek.readLastRowData("benefit_u"), Toast.LENGTH_LONG).show();
        Toast.makeText(this,"Creado por Alexis Antonio", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, MenuPrincipal.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);


    }



    public Context getContext(){
        return context;
    }
}