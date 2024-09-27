package com.angel.gestordeincentivos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Inicio {
    LinearLayout mperent;
    LayoutInflater LayoutInflater;

    // TextView Mtext=findViewById(R.id.textViewItem);

    public Inicio(Context context, View rootView, TextView tvGAcumulada, TextView tvMetaUsuario) {
            //BASE DE DATOS LLAMADO
        //tvGAcumulada = rootView.findViewById(R.id.tvGanancia_acumulada);
        DataBaseIncentiveWeek dbWeek = new DataBaseIncentiveWeek(context);
        dbWeek.insertRowOnceAWeek();




        DataBaseIncentiveDay dbDay = new DataBaseIncentiveDay(context);
        dbDay.insertRowOnceADay();

       // Toast.makeText(context,dbDay.readLastRowData("plus_u"), Toast.LENGTH_LONG).show();

        //  DataBaseIncentiveWeek dbWeek = new DataBaseIncentiveWeek(context);
      //  dbWeek.insertRowOnceAWeek();







        String[] lista = {"Plus", "Benefit", "Clasica", "Upgrade" ,"Garantia Extendida", "Chip Bait", "Chip Bait Renovacion", "Membresia de Salud"};
        mperent = rootView.findViewById(R.id.llContenedor);//llamo al layout de inicio que aparecera como layout secundario


        LayoutInflater inflater = LayoutInflater.from(context);//inflo el contexto para utilizarlo para manipular el item objeto inicio



        //Toast.makeText(context,tvGAcumulada.getText(), Toast.LENGTH_LONG).show();

       // Toast.makeText(context,tvGAcumulada.getText(), Toast.LENGTH_LONG).show();
        for (int i = 0; i < lista.length; i++) {
            View myview = inflater.inflate(R.layout.item_objeto_inicio, null, false);//genero un objeo vista para item objeto utilizando infater

            TextView Mtext = myview.findViewById(R.id.textViewItem);
            ImageView Mimage = myview.findViewById(R.id.imageView);
            String texto = lista[i];
            Mtext.setText(texto);
            ImageButton bNext = myview.findViewById(R.id.bNext);
            ImageButton bAfter = myview.findViewById(R.id.bAfter);
            TextView tvCount = myview.findViewById(R.id.tvCount);

            switch (texto) {
                case "Plus":
                    Mimage.setImageResource(R.drawable.plus);
                    tvCount.setText(dbDay.readLastRowData("plus"));
                    break;
                case "Benefit":
                    Mimage.setImageResource(R.drawable.benefit);
                    tvCount.setText(dbDay.readLastRowData("benefit"));
                    break;
                case "Clasica":
                    Mimage.setImageResource(R.drawable.clasica);
                    tvCount.setText(dbDay.readLastRowData("clasica"));
                    break;
                case "Upgrade":
                    Mimage.setImageResource(R.drawable.upgrade);
                    tvCount.setText(dbDay.readLastRowData("upgrade"));
                    break;
                case "Garantia Extendida":
                    Mimage.setImageResource(R.drawable.garantia_extendida);
                    tvCount.setText(dbDay.readLastRowData("ge"));
                    break;
                case "Chip Bait Renovacion":
                    Mimage.setImageResource(R.drawable.bait);
                    tvCount.setText(dbDay.readLastRowData("bait_b"));
                    break;
                case "Chip Bait":
                    Mimage.setImageResource(R.drawable.bazul);
                    tvCount.setText(dbDay.readLastRowData("bait"));
                    break;
                case "Membresia de Salud":
                    Mimage.setImageResource(R.drawable.salud);
                    tvCount.setText(dbDay.readLastRowData("salud"));
                    break;
                default:

                    break;

            }

            mperent.addView(myview);



            int finalI = i;
            bNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String update= String.valueOf(Integer.parseInt((String) tvCount.getText()) + 1);
                    dbDay.updateLastRow(lista[finalI], update);
                    dbDay.updateLastRow(lista[finalI]+"_total", update);
                    int acumulador= Integer.parseInt(dbWeek.readLastRowData(lista[finalI]))+1;
                    dbWeek.updateLastRow(lista[finalI], String.valueOf(acumulador));
                    dbWeek.updateLastRow(lista[finalI]+"_total",String.valueOf(acumulador));
                    dbWeek.updateLastRow("total", "" );
                    dbWeek.updateLastRow("meta_usuario","");

                    String acumulate=dbWeek.readLastRowData("total");
                    String totalAmount= dbWeek.readLastRowData("meta_usuario");
                    tvGAcumulada.setText(acumulate);
                    tvMetaUsuario.setText(totalAmount);
                    tvCount.setText(update);
                }
            });

            bAfter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Integer.parseInt((String) tvCount.getText())>0){
                        String update= String.valueOf(Integer.parseInt((String) tvCount.getText()) - 1);
                        dbDay.updateLastRow(lista[finalI], update);
                        dbDay.updateLastRow(lista[finalI]+"_total", update);
                        int acumulador= Integer.parseInt(dbWeek.readLastRowData(lista[finalI]))-1;
                        dbWeek.updateLastRow(lista[finalI], String.valueOf(acumulador));
                        dbWeek.updateLastRow(lista[finalI]+"_total",String.valueOf(acumulador));
                        dbWeek.updateLastRow("total", "" );
                        dbWeek.updateLastRow("meta_usuario","");

                        String acumulate=dbWeek.readLastRowData("total");
                        String totalAmount= dbWeek.readLastRowData("meta_usuario");
                        tvGAcumulada.setText(acumulate);
                        tvMetaUsuario.setText(totalAmount);
                        tvCount.setText(update);
                    }



                }
            });


        }


    }
}
