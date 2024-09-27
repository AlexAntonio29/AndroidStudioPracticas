package com.angel.calculadora;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DataSet {
    Button b;

    public DataSet() {

    }

    DiscreteMaths operacion = new DiscreteMaths();
    MainActivity m;

    public DataSet(Button b) {
        this.b = b;
    }

    public Button getB(Button bc) {


        return b;
    }

    public MainActivity getM() {
        return m;
    }

    public void setM(MainActivity m) {
        this.m = m;
    }

    public String Acumulacion(String s) {
        String n = "";
        for (int i = 0; i < s.length(); i++) {
            char caracter = s.charAt(i);
            if (!operacion.esNumero(caracter)) n = "";
            else n += caracter;
        }
        return n;
    }


    public boolean evaluarDato(String n) {
        int sum = 0;


        String m = Acumulacion(n);


        for (int j = 0; j < m.length(); j++) {
            char caracter = m.charAt(j);
            sum++;
            if (!operacion.esNumero(caracter)) return true;
        }


        if (sum >= 9) return false;
        return true;
    }

    public void mostrarToast(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void setB(Button b) {
        this.b = b;
    }

    public String bC() {

        return "";
    }

    /*public String bParentesis(TextView tv) {
        String s = tv.getText().toString();

        String r, Data = tv.getText().toString();
        if (Data == "") return "(";
        boolean par;
        String n="";
char caracterAnterior = 0;
        for (int i = 0; i < Data.length(); i++) {
           char caracter= Data.charAt(i);

           if (i!=0) {
               caracterAnterior=Data.charAt(i-1);
           }
           if (caracter=='(')n=")";
           if (caracter==')')n="(";


        }


        if (caracterAnterior=='('||caracterAnterior==')') return "";




    };*/

    public String bModulo(TextView tv) {
        String text = (String) tv.getText().toString();

        if (text == "") return "";
        else {
            char ultimoCaracter = (text.charAt(text.length() - 1));
            if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' | ultimoCaracter == '%' || ultimoCaracter == '.')
                return "";
            else
                return "%";
        }
    }

    public String bDivision(TextView tv) {

        String text = (String) tv.getText().toString();

        if (text == "") return "";
        else {
            char ultimoCaracter = (text.charAt(text.length() - 1));
            if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' | ultimoCaracter == '%' || ultimoCaracter == '.')
                return "";
            return "/";
        }
    }

    public String b7(TextView tv) {

        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "7";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";


    }

    public String b8(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "8";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String b9(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "9";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String bMult(TextView tv) {

        String text = (String) tv.getText().toString();

        if (text == "") return "";
        else {
            char ultimoCaracter = (text.charAt(text.length() - 1));
            if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' | ultimoCaracter == '%' || ultimoCaracter == '.')
                return "";
            return "x";
        }
    }

    public String b4(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "4";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String b5(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "5";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String b6(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "6";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String bMenos(TextView tv) {
        String text = (String) tv.getText().toString();
        if (text == "") return "";
        else {
            char ultimoCaracter = (text.charAt(text.length() - 1));
            if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' | ultimoCaracter == '%' || ultimoCaracter == '.')
                return "";
            return "-";
        }
    }

    public String b1(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "1";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String b2(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "2";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String b3(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "3";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String bMas(TextView tv) {

        String text = (String) tv.getText().toString();

        if (text == "") return "";
        else {
            char ultimoCaracter = (text.charAt(text.length() - 1));
            if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' | ultimoCaracter == '%' || ultimoCaracter == '.')
                return "";
            return "+";
        }
    }

    public String bMasMenos(TextView tv) {

        String text = (String) tv.getText().toString();
        if (text != "") {
            char ultimoCaracter = (text.charAt(text.length() - 1));
            if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' | ultimoCaracter == '%' || ultimoCaracter == '.')
                return "";
        }
        return "-";

    }

    public String b0(TextView tv) {
        String text=tv.getText().toString();
        if (text!=""){

            char UltimoCaracter=text.charAt(text.length()-1);
            if (UltimoCaracter=='%') return "";
        }
        if (evaluarDato(tv.getText().toString())) return "0";
        else mostrarToast(m, "Ha superado el limite de datos");
        return "";
    }

    public String bPunto(TextView tv) {
        boolean ExistenciaPunto = false;

        String text = (String) tv.getText().toString();

        if (text == "")
            return "";
        else {
            if (evaluarDato(tv.getText().toString())) {
                char ultimoCaracter = (text.charAt(text.length() - 1));
                for (int i = 0; i < text.length(); i++) {
                    char caracter = text.charAt(i);

                    if (caracter == '.') ExistenciaPunto = true;
                    if (caracter == '+' || caracter == '-' || caracter == 'x' || caracter == '/' || caracter == '%')
                        ExistenciaPunto = false;


                }
                if ((ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' | ultimoCaracter == '%' || ultimoCaracter == '.') || ExistenciaPunto)
                    return "";
                return ".";
            } else mostrarToast(m, "Ha superado el limite de datos");
            return "";


        }
    }


}


