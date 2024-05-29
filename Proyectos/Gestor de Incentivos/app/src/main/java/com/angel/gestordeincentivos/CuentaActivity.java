package com.angel.gestordeincentivos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class CuentaActivity {

    public CuentaActivity(){

    }

    LinearLayout mparent;
    LayoutInflater layoutInflater;
    public CuentaActivity(Context context, View rootview){
        mparent=rootview.findViewById(R.id.llCuenta);


    }
}
