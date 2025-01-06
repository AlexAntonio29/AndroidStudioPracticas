package com.angel.calculadoraNew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public Button bc, bParentesis, bModulo, bDivision,
            b7, b8, b9, bMult, b4, b5, b6, bMenos,
            b1, b2, b3, bMas, bMasMenos, b0, bPunto, bIgual;
    public TextView tvOperation, tvR;
    public ImageButton bDelete;
    public Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    TextView textView;
    //tiempo vibracion
    public int timeVibration=3;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OTRAS VARIABLES
        //para tener el contexto o la vista en este caso el MainActivity
        Context context=this;
        //es el metodo para la obtencion de datos que se veran reflejados en la calculadora
        DataSet dataSet = new DataSet(context);
        //objeto tipo vibracion
        //BOTONES
        bc = findViewById(R.id.bC);
        // bParentesis = findViewById(R.id.bParentesis);
        bModulo = findViewById(R.id.bModulo);
        bDivision = findViewById(R.id.bDivision);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bMult = findViewById(R.id.bMult);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        bMenos = findViewById(R.id.bMenos);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        bMas = findViewById(R.id.bMas);
        bMasMenos = findViewById(R.id.bMasMenos);
        b0 = findViewById(R.id.b0);
        bPunto = findViewById(R.id.bPunto);
        bIgual = findViewById(R.id.bIgual);
        bDelete = findViewById(R.id.bDelete);

        //TEXTVIEW
        tvR = findViewById(R.id.tvResult);
        tvOperation = findViewById(R.id.tvOperation);


      /*  String n= (String) r.getText();
        SpannableString spannableString=new SpannableString(n);
        ForegroundColorSpan foregroundColorSpan= new ForegroundColorSpan(Color.GREEN);
        spannableString.setSpan(foregroundColorSpan,r.getText().length()-1,r.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/





        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete d = new Delete(context);
                tvOperation.setText(d.delete(tvOperation));
                if (tvOperation.getText() == "") tvR.setText("");
                colorearSigno(context);
                vibrator.vibrate(timeVibration);
                DiscreteMaths operacion = new DiscreteMaths(context);
                if (tvOperation.getText().toString() != "") tvR.setText(operacion.operation(tvOperation));
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(25);
                tvOperation.setText(dataSet.bC());
                tvR.setText(dataSet.bC());

            }

        });

       /* bParentesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(dataSet.bParentesis(r));
                change();
            }
        });*/


        bModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.bModulo(tvOperation));
                change(tvOperation, "modulo",context,dataSet);

            }
        });

        bDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.bDivision(tvOperation));
                change(tvOperation,"division",context,dataSet);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enviar los datos a la vista de tvOperation
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b7(tvOperation));

                change(tvOperation, "7",context,dataSet);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b8(tvOperation));
                change(tvOperation, "8",context,dataSet);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b9(tvOperation));
                change(tvOperation, "9",context,dataSet);
            }
        });
        bMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.bMult(tvOperation));
                change(tvOperation, "multiplicacion",context,dataSet);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b4(tvOperation));
                change(tvOperation, "4",context,dataSet);
            }

        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b5(tvOperation));
                change(tvOperation, "5",context,dataSet);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b6(tvOperation));
                change(tvOperation, "6",context,dataSet);
            }
        });

        bMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.bMenos(tvOperation));
                change(tvOperation, "resta",context,dataSet);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b1(tvOperation));
                change(tvOperation, "1",context,dataSet);
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b2(tvOperation));
                change(tvOperation, "2",context,dataSet);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b3(tvOperation));
                change(tvOperation, "3",context,dataSet);
            }
        });

        bMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.bMas(tvOperation));

                change(tvOperation, "suma",context,dataSet);
            }
        });
        bMasMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.bMasMenos(tvOperation));
                change(tvOperation, "masMenos",context,dataSet);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText().toString() + dataSet.b0(tvOperation));
                change(tvOperation, "0",context,dataSet);
            }
        });
        bPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                change(tvOperation, "",context,dataSet);
            }
        });

        bIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvR.getText().toString());
                vibrator.vibrate(timeVibration);
            }
        });


    }

    //Este metodo hace el cambio del TextView para actualizar el tvR
    public void change(TextView tvOperation, String string, Context context, DataSet dataSet) {

        tvOperation.setText(tvOperation.getText().toString() + dataSet.push(tvOperation, string));
        colorearSigno(context);
        vibrator.vibrate(timeVibration);
        DiscreteMaths operacion = new DiscreteMaths(context);

        if (tvOperation.getText().toString() != "") tvR.setText(operacion.operation(tvOperation));

        //Toast.makeText(this,operacion.operation(r),Toast.LENGTH_SHORT).show();
    }

    // Todos los signos van en esta parte y son coloreados
    public void colorearSigno(Context context){
        Spannable spannable;
        spannable = new SpannableString(tvOperation.getText().toString());
        int starIndex ;
        int endIndex ;




        Resources res=getResources();
        int colorVerde=res.getColor(R.color.verde);
        DiscreteMaths n= new DiscreteMaths(context);
        String sig="";
        for (int i = 0; i< tvOperation.getText().length(); i++){
            char caracter= tvOperation.getText().charAt(i);
            sig+= String.valueOf(caracter);
            if (!(n.esNumero(caracter))){
                starIndex=sig.length()-1;
                endIndex=sig.length();
                spannable.setSpan(
                        new ForegroundColorSpan(colorVerde),
                        starIndex,
                        endIndex,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                );
                tvOperation.setText((spannable));

            }
        }
    }
}

