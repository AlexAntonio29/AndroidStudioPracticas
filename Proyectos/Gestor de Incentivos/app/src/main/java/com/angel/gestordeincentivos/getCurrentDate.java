package com.angel.gestordeincentivos;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class getCurrentDate{
    public String getCurrentDate() {
        // SimpleDateFormat sigue funcionando, pero está obsoleto
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        return sdf.format(new Date());
    }

    public String getDayDate(){

        Calendar calendar = Calendar.getInstance();

        // Obtener el día de la semana (1 = Domingo, 2 = Lunes, etc.)
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return String.valueOf(dayOfWeek);

    }
    public String getDayDateString(){

        Calendar calendar = Calendar.getInstance();

        // Obtener el día de la semana (1 = Domingo, 2 = Lunes, etc.)
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String n="";

        switch (dayOfWeek){

            case 1:
                n="Domingo";
                break;
            case 2:
                n="Lunes";
                break;
            case 3:
                n="Martes";
                break;
            case 4:
                n="Miercoles";
                break;
            case 5:
                n="Jueves";
                break;
            case 6:
                n="Viernes";
                break;
            case 7:
                n="Sabado";
                break;
            default:
                n="null";
                break;
        }

        return n;

    }

    public String getMonthDate(){

        Calendar calendar = Calendar.getInstance();

        // Obtener el día de la semana (1 = Domingo, 2 = Lunes, etc.)
        int monthOfWeek = calendar.get(Calendar.MONTH);

        return String.valueOf(monthOfWeek);

    }

    public String getMonthDateString(){

        Calendar calendar = Calendar.getInstance();

        // Obtener el día de la semana (1 = Domingo, 2 = Lunes, etc.)
        int monthOfWeek = calendar.get(Calendar.MONTH);
            String n="";
        switch (monthOfWeek){

            case 0:
                n="Enero";
                break;
            case 1:
                n="Febrero";
                break;
            case 2:
                n="Marzo";
                break;
            case 3:
                n="Abril";
                break;
            case 4:
                n="Mayo";
                break;
            case 5:
                n="Junio";
                break;
            case 6:
                n="Julio";
                break;
            case 7:
                n="Agosto";
                break;
            case 8:
                n="Septiembre";
                break;
            case 9:
                n="Octubre";
                break;
            case 10:
                n="Noviembre";
                break;
            case 11:
                n="Diciembre";
                break;
            default:
                n="null";
                break;
        }

        return n;
    }

}
