package com.angel.gestordeincentivos;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CuentaActivity {

    public CuentaActivity(){

    }

    LinearLayout mparent;
    LayoutInflater layoutInflater;
    public CuentaActivity(Context context, View rootview){
        mparent=rootview.findViewById(R.id.llContenedorCuenta);
        LayoutInflater inflater= LayoutInflater.from(context);

        String[] lista={"Datos Personales","Codigo de Productos","Modificar Meta","Cafeteria"};

        for (int i=0;i<lista.length;i++){
            int ItemI=i;

            View myview = inflater.inflate(R.layout.item_cuenta,null,false);
            LinearLayout contentedor=myview.findViewById(R.id.llContenedorCuentaItem);

            ImageView view= myview.findViewById(R.id.itemImageView);
            TextView text = myview.findViewById(R.id.itemTextCuenta);

                switch (lista[i]){

                    case "Datos Personales":

                        view.setImageResource(R.drawable.baseline_account);

                        break;

                    case "Codigo de Productos":
                        view.setImageResource(R.drawable.baseline_productions);
                        break;

                    case "Modificar Meta":
                        view.setImageResource(R.drawable.baseline_check);

                        break;

                    case "Cafeteria":

                        view.setImageResource(R.drawable.baseline_local_cafe);
                        break;

                }


            text.setText(lista[i]);

            mparent.addView(myview);

            contentedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(lista[ItemI].equals("Modificar Meta")){
                        Intent intent = new Intent(context, changeMeta.class);
                        context.startActivity(intent);
                    }
                    if(lista[ItemI].equals("Datos Personales")){
                        Intent intent = new Intent(context, PersonalDataActivity.class);
                        context.startActivity(intent);
                    }


                }
            });





        }


    }
}
