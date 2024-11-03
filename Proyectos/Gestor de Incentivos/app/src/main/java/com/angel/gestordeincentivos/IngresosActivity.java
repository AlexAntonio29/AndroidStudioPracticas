package com.angel.gestordeincentivos;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IngresosActivity {



   LinearLayout mparent;
   TextView date;

    public Button bNext,bPrevius;
    public DataBaseIncentiveDay dbDay;
    public Cursor cursor;
    public  Context context;
    public View rootView;
    public TextView tvDay,tvCantidadT,tvDineroRenovacionDia, tvMont;
    int sumCantidadTotal=0,sumDineroRenovacion=0;



    public IngresosActivity(Context context, View rootView){
            this.context=context;
            this.rootView=rootView;
            this.dbDay=new DataBaseIncentiveDay(context);
            this.cursor= dbDay.getLastRow();

      }

    public void updateTextView(String[] lista,LayoutInflater inflater, int n, Cursor cursor){
        if (n==0)mparent.removeAllViews();
        mparent=rootView.findViewById(R.id.llcontenedorIngreso);//hago el llamado del linear layout de ingresos



        for (int i=0; i<lista.length;i++){

            View myview = inflater.inflate(R.layout.item_objeto_ingreso,null,false);


            TextView mnameIngreso = myview.findViewById(R.id.nameIngreso);
            TextView mCantidadProducto = myview.findViewById(R.id.cantidadProducto);

            TextView mPrecioTotal = myview.findViewById(R.id.precioTotal);


            TextView simbol2=myview.findViewById(R.id.simbolo2);


            if (i == 0) {
                mnameIngreso.setText("Nombre");
                mCantidadProducto.setText("Cantidad");
                mPrecioTotal.setText("Total");
                simbol2.setText("");

                mnameIngreso.setBackgroundColor(Color.parseColor("#082F5E"));
                mCantidadProducto.setBackgroundColor(Color.parseColor("#082F5E"));
                mPrecioTotal.setBackgroundColor(Color.parseColor("#082F5E"));
                simbol2.setBackgroundColor(Color.parseColor("#082F5E"));

                mnameIngreso.setTextColor(Color.parseColor("#FFFFFFFF"));
                mPrecioTotal.setTextColor(Color.parseColor("#FFFFFFFF"));
            }else {
                mnameIngreso.setText(lista[i]);

                updateData(i, cursor, mCantidadProducto,mPrecioTotal);



            }



            mparent.addView(myview);




        }

    }
    public void updateData(int i, Cursor cursor , TextView  mCantidadProducto, TextView mPrecioTotal){
        //DataBaseIncentiveDay dbDay=new DataBaseIncentiveDay(context);

        String res="";
        int val=0, resInt=0;

        String COLUMN_ID = "id";//"T"+date + (new getCurrentDate().getDayDate());
        String COLUMN_DATE = "fecha";
        // private static final String COLUMN_META = "meta";
        String COLUMN_PLUS = "plus";
        String COLUMN_BENEFIT = "benefit";
        String COLUMN_CLASICA = "clasica";
        String COLUMN_UPGRADE = "upgrade";
        String COLUMN_GE = "ge";
        String COLUMN_BAIT = "bait";
        String COLUMN_BAIT_B = "bait_b";
        String COLUMN_SALUD = "salud";


        String COLUMN_PLUS_GANANCIA_TOTAL = "plus_ganancia_total";
        String COLUMN_BENEFIT_GANANCIA_TOTAL = "benefit_ganancia_total";
        String COLUMN_CLASICA_GANANCIA_TOTAL = "clasica_ganancia_total";
        String COLUMN_UPGRADE_GANANCIA_TOTAL = "upgrade_ganancia_total";
         String COLUMN_GE_GANANCIA_TOTAL = "ge_ganancia_total";
            String COLUMN_NO_SEMANA = "no_semana";
        // private static final String COLUMN_ID_SEMANA = "id_semana";
         String COLUMN_TOTAL = "total";


        String cantidad="0";
        String total="0";

        switch (i){

            case 1:

                val= (cursor.getColumnIndex(COLUMN_PLUS));
                resInt = cursor.getInt(val);
                sumCantidadTotal+=resInt;
                res=String.valueOf(resInt);
                cantidad=res;

                val= (cursor.getColumnIndex(COLUMN_PLUS_GANANCIA_TOTAL));
                resInt = cursor.getInt(val);
                sumDineroRenovacion+=resInt;
                res=String.valueOf(resInt);
                total=res;


                break;
            case 2:
                val= (cursor.getColumnIndex(COLUMN_BENEFIT));
                resInt = cursor.getInt(val);
                sumCantidadTotal+=resInt;
                res=String.valueOf(resInt);
                cantidad=res;

                val= (cursor.getColumnIndex(COLUMN_BENEFIT_GANANCIA_TOTAL));
                resInt = cursor.getInt(val);
                sumDineroRenovacion+=resInt;
                res=String.valueOf(resInt);
                total=res;
                break;
            case 3:
                val= (cursor.getColumnIndex(COLUMN_CLASICA));
                resInt = cursor.getInt(val);
                sumCantidadTotal+=resInt;
                res=String.valueOf(resInt);
                cantidad=res;

                val= (cursor.getColumnIndex(COLUMN_CLASICA_GANANCIA_TOTAL));
                resInt = cursor.getInt(val);
                sumDineroRenovacion+=resInt;
                res=String.valueOf(resInt);
                total=res;
                break;
            case 4:
                val= (cursor.getColumnIndex(COLUMN_UPGRADE));
                resInt = cursor.getInt(val);
                res=String.valueOf(resInt);
                cantidad=res;

                val= (cursor.getColumnIndex(COLUMN_UPGRADE_GANANCIA_TOTAL));
                resInt = cursor.getInt(val);
                res=String.valueOf(resInt);
                total=res;
                break;
            case 5:
                val= (cursor.getColumnIndex(COLUMN_GE));
                resInt = cursor.getInt(val);
                res=String.valueOf(resInt);
                cantidad=res;

                val= (cursor.getColumnIndex(COLUMN_GE_GANANCIA_TOTAL));
                resInt = cursor.getInt(val);
                res=String.valueOf(resInt);
                total=res;
                break;
            case 6:
                val= (cursor.getColumnIndex(COLUMN_BAIT));
                resInt = cursor.getInt(val);
                res=String.valueOf(resInt);
                cantidad=res;


                total="0";
                break;
            case 7:
                val= (cursor.getColumnIndex(COLUMN_BAIT_B));
                resInt = cursor.getInt(val);
                res=String.valueOf(resInt);
                cantidad=res;


                total="0";
                break;
            case 8:




                val= (cursor.getColumnIndex(COLUMN_SALUD));
                resInt = cursor.getInt(val);
                res=String.valueOf(resInt);
                cantidad=res;


                total="0";
                break;




        }

        mCantidadProducto.setText(cantidad);
        mPrecioTotal.setText(total);

    }

    public IngresosActivity(){

    }

    public void initIngresosActivity(){



      LayoutInflater inflater=LayoutInflater.from(context);
        bNext=rootView.findViewById(R.id.bDiaPos);
        bPrevius=rootView.findViewById(R.id.bDiaAnt);
        date= rootView.findViewById(R.id.tvFechaIngreso);
        tvDay= rootView.findViewById(R.id.tvDay);
        tvMont=rootView.findViewById(R.id.tvMonth);
        tvCantidadT=rootView.findViewById(R.id.tvCantidadTotalDia);
        tvDineroRenovacionDia=rootView.findViewById(R.id.tvDineroTotalRenovacion);
        String[] lista = {"","Plus", "Benefit", "Clasica","Upgrade", "Garantia Extendida",
                "Chip Bait", "Chip Bait Renovacion", "Membresia de Salud"};
        tvMont.setText(new getCurrentDate().getMonthDateString());
        tvDay.setText(new getCurrentDate().getDayDateString());



        //creacion del cursor para navegar entre filas
        String fecha=dbDay.readLastRowData("date");
        date.setText(fecha);


        updateTextView(lista, inflater, 1, cursor);
        tvCantidadT.setText(String.valueOf(sumCantidadTotal));
        tvDineroRenovacionDia.setText(String.valueOf(sumDineroRenovacion));



        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String COLUMN_ID = "id";
                String COLUMN_DATE ="fecha";
                String res="";
                int val=0, resInt=0;
                val= (cursor.getColumnIndex(COLUMN_ID));
                resInt = (cursor.getInt(val))+1;
                res=String.valueOf(resInt);

                Cursor cursorSustituto=dbDay.getRowChange(res);;




                if (cursorSustituto != null){
                    cursor = cursorSustituto;
                    val= (cursor.getColumnIndex(COLUMN_DATE));
                    String fecha=(cursor.getString(val));
                    date.setText(fecha);
                    tvDay.setText(dayNext((String) tvDay.getText()));

                    sumCantidadTotal=0;
                    sumDineroRenovacion=0;
                    updateTextView(lista, inflater, 0, cursor);

                    tvCantidadT.setText(String.valueOf(sumCantidadTotal));
                    tvDineroRenovacionDia.setText(String.valueOf(sumDineroRenovacion));
                    tvMont.setText(getMonthActually((String) date.getText()));
                }


                //  updateData();

            }
        });

        bPrevius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String COLUMN_ID = "id";
                String COLUMN_DATE ="fecha";
                String res="";
                int val=0, resInt=0;
                val= (cursor.getColumnIndex(COLUMN_ID));
                resInt = (cursor.getInt(val))-1;
                res=String.valueOf(resInt);

                Cursor cursorSustituto=dbDay.getRowChange(res);;



                if (cursorSustituto != null){
                    cursor = cursorSustituto;
                    val= (cursor.getColumnIndex(COLUMN_DATE));
                    String fecha=(cursor.getString(val));
                    date.setText(fecha);
                    sumCantidadTotal=0;
                    sumDineroRenovacion=0;
                    tvDay.setText(dayPrevius((String) tvDay.getText()));
                    updateTextView(lista, inflater, 0, cursor);
                    tvMont.setText(getMonthActually((String) date.getText()));
                    tvCantidadT.setText(String.valueOf(sumCantidadTotal));
                    tvDineroRenovacionDia.setText(String.valueOf(sumDineroRenovacion));
                }

            }
        });

    }

    public String dayNext(String dayOfWeek){

        String n="";

        switch (dayOfWeek){

            case "Domingo":
                n="Lunes";
                break;
            case "Lunes":
                n="Martes";
                break;
            case "Martes":
                n="Miercoles";
                break;
            case "Miercoles":
                n="Jueves";
                break;
            case "Jueves":
                n="Viernes";
                break;
            case "Viernes":
                n="Sabado";
                break;
            case "Sabado":
                n="Domingo";
                break;
            default:
                n="null";
                break;
        }

        return n;
    }

    public String dayPrevius(String dayOfWeek){

        String n="";

        switch (dayOfWeek){

            case "Domingo":
                n="Sabado";
                break;
            case "Sabado":
                n="Viernes";
                break;
            case "Viernes":
                n="Jueves";
                break;
            case "Jueves":
                n="Miercoles";
                break;
            case "Miercoles":
                n="Martes";
                break;
            case "Martes":
                n="Lunes";
                break;
            case "Lunes":
                n="Domingo";
                break;
            default:
                n="null";
                break;
        }

        return n;
    }

    public String getMonth(String month){
        int condition=0;
        String monthActually="";
        for (int i=0;i<month.length();i++){
            char letra=month.charAt(i);

            if (letra=='_' && condition==1) return monthActually;
            if (condition==1)  monthActually+= String.valueOf(letra);

            if (letra=='_') condition=1;

        }

        return monthActually;

    }

    public String getMonthActually(String month){

            switch (Integer.parseInt(getMonth(month))){
                case 1:
                    return "Enero";


                case 2:
                    return "Febrero";

                case 3:
                    return "Marzo";

                case 4:
                    return "Abril";

                case 5:
                    return "Mayo";

                case 6:
                    return "Junio";

                case 7:
                    return "Julio";

                case 8:
                    return "Agosto";

                case 9:
                    return "Septiembre";

                case 10:
                    return "Octubre";

                case 11:
                    return "Noviembre";

                case 12:
                    return "Diciembre";


            }

            return null;

    }




}
