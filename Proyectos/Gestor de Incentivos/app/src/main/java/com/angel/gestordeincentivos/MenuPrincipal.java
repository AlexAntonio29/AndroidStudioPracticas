package com.angel.gestordeincentivos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MenuPrincipal extends AppCompatActivity {
    private Inicio inicio;
    private CuentaActivity cuentaActivity;
    private IngresosActivity ingresosActivity;
    //Button bModificarMeta;
    TextView tvGAcumulada;
    TextView tvMetaFinal;
    TextView tvMetaUsuario;
    Button bInicio, bIngresos, bCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        Context context = this;


        //INICIAR BASE DE DATOS
        DataBaseIncentiveWeek dbWeek = new DataBaseIncentiveWeek(this);
        dbWeek.insertRowOnceAWeek();

//ASIGNACION DE VARIABLES QUE SE OBTIENEN DE AL BASE DE DATOS
        String textTvAcumulada = dbWeek.readLastRowData("total");
        String textTvMetafinal="";
        if(!Objects.equals(dbWeek.readLastRowData("meta"), "0"))
            textTvMetafinal = dbWeek.readLastRowData("meta");

        String textTvMetaUsuario = dbWeek.readLastRowData("meta_usuario");
//ASIGNACION DE VARIABLES
        
        bInicio = findViewById(R.id.inicio);
        bCuenta = findViewById(R.id.cuenta);
        bIngresos = findViewById(R.id.ingresos);

        tvGAcumulada = findViewById(R.id.tvGanancia_acumulada);
        View rootView = findViewById(R.id.layout_secundario);
        LinearLayout linearLayoutTop=findViewById(R.id.rlGanancias);
        //ASIGNACION DE METAS A CADA UNA
        tvMetaFinal = findViewById(R.id.tvMetaFinal);
        tvMetaUsuario = findViewById(R.id.tvMetaUsuario);
        //bModificarMeta=findViewById(R.id.bModificar);
//ASIGNACION DE LOS SETTEXT A VALORES DE LA BASE DE DATOS
        tvGAcumulada.setText(textTvAcumulada);
        tvMetaFinal.setText(textTvMetafinal);
        tvMetaUsuario.setText(textTvMetaUsuario);


        //VARIABLES BASICAS
        final boolean[] n = {true, false, false};//n[0]inicio, n[1]Ingesos, n[2]Cuenta
        int metaUsuario=Integer.parseInt(dbWeek.readLastRowData("meta_usuario"));
        int metaFinal=Integer.parseInt(dbWeek.readLastRowData("meta"));


//INICIAR VISTA GRUPAL POR DEFECTO INICIA EN LA VISTA INICIO
        //USO DE UN LAYOUT INFLADO
        ViewGroup include_menu_principal = findViewById(R.id.layout_secundario);//Esta variable de ViewGroup toma el include agregado dentro del menu principal
        View inicioInflater = LayoutInflater.from(this).inflate(R.layout.layout_inicio, include_menu_principal, false);
        include_menu_principal.removeAllViews();
        include_menu_principal.addView(inicioInflater);
         inicio =new Inicio( this,rootView, tvGAcumulada, tvMetaUsuario);
        if((metaUsuario-1)==metaFinal) tvGAcumulada.setTextColor(Color.parseColor("#FFFFFF"));


//BOTON INICIO, AL HACER CLICK!!
        bInicio.setOnClickListener(new View.OnClickListener() {//Clic de boton inicio
            // View rootView= findViewById(R.id.layout_secundario);
            @Override
            public void onClick(View v) {

                if (!n[0]) {
                    n[0] = true;//SI 0 ES CIERTO(INICIO) ENTONCES ESTE NO SE ABRE, ESTO ES PARA QUE NO SE ABRA NUEVAMENTE
                    n[1] = false;//SI NO ENTONCES SI CUMPLE LA FUNCION
                    n[2] = false;//SI NO ENTONCES SI CUMPLE LA FUNCION

                    //LAYOUT TOP ES PARA QUE DONDE SE ADMINISTRAN EL DINERO EN EL MENU INICIAL APAREZCA
                    linearLayoutTop.setVisibility(View.VISIBLE);
                    View inicioInflater = LayoutInflater.from(MenuPrincipal.this).inflate(R.layout.layout_inicio, include_menu_principal, false);
                    include_menu_principal.removeAllViews();

                    include_menu_principal.addView(inicioInflater);

                      inicio =new Inicio(context,rootView,tvGAcumulada, tvMetaUsuario);

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
                    linearLayoutTop.setVisibility(View.VISIBLE);


                    View ingresoInflater = LayoutInflater.from(MenuPrincipal.this).inflate(R.layout.layout_ingresos, include_menu_principal, false);
                    include_menu_principal.removeAllViews();

                    include_menu_principal.addView(ingresoInflater);

                    ingresosActivity = new IngresosActivity(context,rootView);
                    ingresosActivity.initIngresosActivity();

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
                    //LINEAR LAYOUT TOP DESAPARECE
                    linearLayoutTop.setVisibility(View.GONE);
                    LinearLayout linearLayout=findViewById(R.id.rlGananciasR2);

                    View cuentaInflater = LayoutInflater.from(MenuPrincipal.this).inflate(R.layout.layout_cuenta, include_menu_principal, false);
                    include_menu_principal.removeAllViews();

                    include_menu_principal.addView(cuentaInflater);
                    cuentaActivity = new CuentaActivity(context, rootView);

                }
            }
        });


    }
}
