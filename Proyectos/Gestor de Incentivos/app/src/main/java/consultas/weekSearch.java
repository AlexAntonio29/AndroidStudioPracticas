

package consultas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.angel.gestordeincentivos.DataBaseIncentiveWeek;
import com.angel.gestordeincentivos.DataBaseIncentiveDay;

public class weekSearch {

    DataBaseIncentiveWeek dbWeek;
    DataBaseIncentiveDay dbDay;
    Context context ;//declaracion de variable contexto;

    weekSearch(){}//constructor vacio

    public weekSearch(Context context, DataBaseIncentiveDay dbDay, DataBaseIncentiveWeek dbWeek){
        this.context=context;
        this.dbDay=dbDay;
        this.dbWeek=dbWeek;
    }

    public void updateData(SQLiteDatabase db, int id){

        ContentValues values =new ContentValues();

        //values.put();



    }

    public String getWeek(){

        return dbWeek.readLastRowData("no_semana");
    }

    public void cambiarMetas(){
        SQLiteDatabase db=dbDay.getWritableDatabase();
        Cursor cursor=null;

        String TABLE_INCENTIVE_DAY= dbDay.getTableIncentiveDayString();
        String weekNumber= dbDay.getWeekNumberString();
        String week= this.getWeek();


        //crear Query
        String query= "SELECT * FROM  "+TABLE_INCENTIVE_DAY+" WHERE "+weekNumber+" = ?";


        cursor= db.rawQuery(query, new String[]{week});

        if (cursor!=null && cursor.moveToFirst()){


            do{
            //Obtengo id principal de la fila

                int id =cursor.getColumnIndex("id");
                int lastId = cursor.getInt(id);
            updateData(db, lastId);

            }while (cursor.moveToNext());
        }

        if (cursor!=null) cursor.close();

    }
}
