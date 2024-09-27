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

}
