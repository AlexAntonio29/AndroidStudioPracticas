package com.angel.calculadoraNew;

import android.content.Context;
import android.widget.TextView;

public class Delete extends DiscreteMaths{


    public Delete(Context context){

        super(context);


    }

    public String delete(TextView n){
        String numbers= ( String) n.getText().toString();
        String r="";

        for (int i=0;i<numbers.length()-1;i++)
        {
            char caracter=numbers.charAt(i);
            r+=caracter;
        }

        System.out.println(r);

        return r;
    }
}
