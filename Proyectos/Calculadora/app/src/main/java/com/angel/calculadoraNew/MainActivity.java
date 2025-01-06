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
    public TextView r, tvR;
    public ImageButton bDelete;
    public Vibrator vibrator;
    TextView textView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        tvR = findViewById(R.id.tvResult);
        r = findViewById(R.id.tvOperation);
        bDelete = findViewById(R.id.bDelete);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

      /*  String n= (String) r.getText();
        SpannableString spannableString=new SpannableString(n);
        ForegroundColorSpan foregroundColorSpan= new ForegroundColorSpan(Color.GREEN);
        spannableString.setSpan(foregroundColorSpan,r.getText().length()-1,r.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/
        final DataSet a = new DataSet();
        a.setM(this);

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(5);
                Delete d = new Delete();
                r.setText(d.delete(r));
                if (r.getText() == "") tvR.setText("");
                change();
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(25);
                r.setText(a.bC());
                tvR.setText(a.bC());

            }

        });

       /* bParentesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(a.bParentesis(r));
                change();
            }
        });*/


        bModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.bModulo(r));
                change();

            }
        });

        bDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.bDivision(r));
                change();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                r.setText(r.getText().toString() + a.b7(r));
                change();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b8(r));
                change();
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b9(r));
                change();
            }
        });
        bMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.bMult(r));
                change();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b4(r));
                change();
            }

        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b5(r));
                change();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b6(r));
                change();
            }
        });

        bMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.bMenos(r));
                change();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b1(r));
                change();
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b2(r));
                change();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b3(r));
                change();
            }
        });

        bMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.bMas(r));

                change();
            }
        });
        bMasMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.bMasMenos(r));
                change();
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(r.getText().toString() + a.b0(r));
                change();
            }
        });
        bPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                r.setText(r.getText().toString() + a.bPunto(r));
                change();
            }
        });

        bIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setText(tvR.getText().toString());
                vibrator.vibrate(10);
            }
        });


    }

    //Este metodo hace el cambio del TextView para actualizar el tvR
    public void change() {


        colorearSigno();
        vibrator.vibrate(10);
        DiscreteMaths operacion = new DiscreteMaths();

        if (r.getText().toString() != "") tvR.setText(operacion.operation(r, this));

        //Toast.makeText(this,operacion.operation(r),Toast.LENGTH_SHORT).show();
    }

    // Todos los signos van en esta parte y son coloreados
    public void colorearSigno(){
        Spannable spannable;
        spannable = new SpannableString(r.getText().toString());
        int starIndex ;
        int endIndex ;




        Resources res=getResources();
        int colorVerde=res.getColor(R.color.verde);
        DiscreteMaths n= new DiscreteMaths();
        String sig="";
        for (int i=0;i<r.getText().length();i++){
            char caracter= r.getText().charAt(i);
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
                r.setText((spannable));

            }
        }
    }
}

