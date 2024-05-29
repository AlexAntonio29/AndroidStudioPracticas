package com.angel.gestordeincentivos;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Inicio {
    LinearLayout mperent;
    LayoutInflater LayoutInflater;



    // TextView Mtext=findViewById(R.id.textViewItem);

    public Inicio(Context context, View rootView) {


        String[] lista = {"Plus", "Benefit", "Clasica", "Garantia Extendida", "Chip Bait", "Chip Bait Renovacion", "Membresia de Salud"};
        mperent = rootView.findViewById(R.id.llContenedor);//llamo al layout de inicio que aparecera como layout secundario


        LayoutInflater inflater = LayoutInflater.from(context);//inflo el contexto para utilizarlo para manipular el item objeto inicio


        for (int i = 0; i < lista.length; i++) {
            View myview = inflater.inflate(R.layout.item_objeto_inicio, null, false);//genero un objeo vista para item objeto utilizando infater

            TextView Mtext = myview.findViewById(R.id.textViewItem);
            ImageView Mimage = myview.findViewById(R.id.imageView);
            String texto = lista[i];
            Mtext.setText(texto);
            ImageButton bNext = myview.findViewById(R.id.bNext);
            ImageButton bAfter = myview.findViewById(R.id.bAfter);


            switch (texto) {
                case "Plus":
                    Mimage.setImageResource(R.drawable.plus);
                    break;
                case "Benefit":
                    Mimage.setImageResource(R.drawable.benefit);
                    break;
                case "Clasica":
                    Mimage.setImageResource(R.drawable.clasica);
                    break;
                case "Garantia Extendida":
                    Mimage.setImageResource(R.drawable.garantia_extendida);
                    break;
                case "Chip Bait Renovacion":
                    Mimage.setImageResource(R.drawable.bait);
                    break;
                case "Chip Bait":
                    Mimage.setImageResource(R.drawable.bazul);
                    break;
                case "Membresia de Salud":
                    Mimage.setImageResource(R.drawable.salud);
                    break;
                default:

                    break;

            }
            TextView tvCount = myview.findViewById(R.id.tvCount);
            mperent.addView(myview);
            bNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvCount.setText(String.valueOf(Integer.parseInt((String) tvCount.getText()) + 1));
                }
            });

            bAfter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Integer.parseInt((String) tvCount.getText())>0)
                        tvCount.setText(String.valueOf(Integer.parseInt((String) tvCount.getText())-1) );
                }
            });


        }


    }
}
