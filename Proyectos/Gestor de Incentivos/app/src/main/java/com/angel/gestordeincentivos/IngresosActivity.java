package com.angel.gestordeincentivos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IngresosActivity {


   LinearLayout mparent;

    public IngresosActivity(Context context, View rootView){


        mparent=rootView.findViewById(R.id.llcontenedorIngreso);//hago el llamado del linear layout de ingresos
        LayoutInflater inflater=LayoutInflater.from(context);

        String[] lista = {"Plus", "Benefit", "Clasica", "Garantia Extendida",
                "Chip Bait", "Chip Bait Renovacion", "Membresia de Salud"};





        for (int i=0; i<lista.length;i++){

            View myview = inflater.inflate(R.layout.item_objeto_ingreso,null,false);


            TextView mnameIngreso = myview.findViewById(R.id.nameIngreso);
            TextView mCantidadProducto = myview.findViewById(R.id.cantidadProducto);
            TextView mPrecioUnitario = myview.findViewById(R.id.precioUnitario);
            TextView mPrecioTotal = myview.findViewById(R.id.precioTotal);


            mnameIngreso.setText(lista[i]);
            mCantidadProducto.setText("0");
            mPrecioUnitario.setText("0");
            mPrecioTotal.setText("0");


            mparent.addView(myview);


        }

    }
}
