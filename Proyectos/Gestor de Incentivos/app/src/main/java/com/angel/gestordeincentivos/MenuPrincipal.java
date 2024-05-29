package com.angel.gestordeincentivos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {
    private Inicio inicio;
    private CuentaActivity cuentaActivity;
    private IngresosActivity ingresosActivity;
    Button bModificarMeta;

    Button bInicio, bIngresos, bCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        Context context = this;
        bModificarMeta = findViewById(R.id.bModificar);
        bInicio = findViewById(R.id.inicio);
        bCuenta = findViewById(R.id.cuenta);
        bIngresos = findViewById(R.id.ingresos);

        bModificarMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Intent intent = new Intent(this, MenuPrincipal.class);//ir a boton modificar Meta
                // startActivity(intent);
            }
        });


        ViewGroup include_menu_principal = findViewById(R.id.layout_secundario);//Esta variable de ViewGroup toma el include agregado dentro del menu principal
        View inicioInflater = LayoutInflater.from(this).inflate(R.layout.layout_inicio, include_menu_principal, false);
        include_menu_principal.removeAllViews();

        include_menu_principal.addView(inicioInflater);


        View rootView = findViewById(R.id.layout_secundario);

         inicio =new Inicio( this,rootView);
        final boolean[] n = {true, false, false};//n[0]inicio, n[1]Ingesos, n[2]Cuenta
        bInicio.setOnClickListener(new View.OnClickListener() {//Clic de boton inicio
            // View rootView= findViewById(R.id.layout_secundario);
            @Override
            public void onClick(View v) {

                if (!n[0]) {
                    n[0] = true;
                    n[1] = false;
                    n[2] = false;
                    View inicioInflater = LayoutInflater.from(MenuPrincipal.this).inflate(R.layout.layout_inicio, include_menu_principal, false);
                    include_menu_principal.removeAllViews();

                    include_menu_principal.addView(inicioInflater);

                      inicio =new Inicio(context,rootView);

                }
            }
        });

        bIngresos.setOnClickListener(new View.OnClickListener() {//clic boton ingresos
            @Override
            public void onClick(View v) {
                if (!n[1]) {
                    n[0] = false;
                    n[1] = true;
                    n[2] = false;



                    View ingresoInflater = LayoutInflater.from(MenuPrincipal.this).inflate(R.layout.layout_ingresos, include_menu_principal, false);
                    include_menu_principal.removeAllViews();

                    include_menu_principal.addView(ingresoInflater);

                }
            }
        });

        bCuenta.setOnClickListener(new View.OnClickListener() {//clic boton Cuenta
            @Override
            public void onClick(View v) {
                if (!n[2]) {
                    n[0] = false;
                    n[1] = false;
                    n[2] = true;
                    LinearLayout linearLayout=findViewById(R.id.rlGananciasR2);
                    View cuentaInflater = LayoutInflater.from(MenuPrincipal.this).inflate(R.layout.layout_cuenta, include_menu_principal, false);
                    include_menu_principal.removeAllViews();

                    include_menu_principal.addView(cuentaInflater);

                }
            }
        });


    }
}
