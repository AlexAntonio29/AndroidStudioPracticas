package com.angel.gestordeincentivos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainCafeteria extends AppCompatActivity {


    LinearLayout mparent;
    android.view.LayoutInflater LayoutInflater;

    public MainCafeteria (){



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria);

        Context context= this;

        //asignacion de variables
        mparent = findViewById(R.id.llContenedorCafeteria);//llamo al layout de inicio que aparecera como layout secundario
        LayoutInflater inflater = LayoutInflater.from(context);//inflo el contexto para utilizarlo para manipular el item objeto inicio





        String menu[]={"Hotdog+Refresco"};

        for (int i=0;i<menu.length;i++){

            View myView= inflater.inflate(R.layout.item_cafeteria,null,false);

            ImageView ivImage= findViewById(R.id.imageViewProduct);
            TextView tvTitle= findViewById(R.id.tvTitleCafeteria);
            TextView tvCode= findViewById(R.id.tvCodeItem);
            ImageView ivCode= findViewById(R.id.imageViewCode);


            switch (i){
                case 0:

                    break;


            }




        }



    }

}
