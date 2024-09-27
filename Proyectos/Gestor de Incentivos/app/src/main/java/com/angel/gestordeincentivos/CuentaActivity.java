package com.angel.gestordeincentivos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CuentaActivity {

    public CuentaActivity(){

    }

    LinearLayout mparent;
    LayoutInflater layoutInflater;
    public CuentaActivity(Context context, View rootview){
        mparent=rootview.findViewById(R.id.llContenedorCuenta);
        LayoutInflater inflater= LayoutInflater.from(context);

        String[] lista={"opcion1","opcion2","opcion3","opcion4","opcion5","opcion6","opcion7"};

        for (int i=0;i<lista.length;i++){

            View myview = inflater.inflate(R.layout.item_cuenta,null,false);
            ImageView view= myview.findViewById(R.id.itemImageView);
            TextView text = myview.findViewById(R.id.itemTextCuenta);

            text.setText(lista[i]);

            mparent.addView(myview);




        }


    }
}
