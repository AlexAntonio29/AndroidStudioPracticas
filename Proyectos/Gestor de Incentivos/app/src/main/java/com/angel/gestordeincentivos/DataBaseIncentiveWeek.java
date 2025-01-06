package com.angel.gestordeincentivos;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DataBaseIncentiveWeek extends SQLiteOpenHelper {


   // private SQLiteDatabase db = this.getWritableDatabase();

    private static final String date = new getCurrentDate().getCurrentDate();
    private static final String DATABASE_NAME = "my_databaseincentivo_week.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_INCENTIVE_WEEK = "table_incentive_week";

    // Definir las columnas con valores por defecto
    private static final String COLUMN_ID = "id";//"T"+date + (new getCurrentDate().getDayDate());
    private static final String COLUMN_DATE = "fecha";
    private static final String COLUMN_META_USUARIO = "metal_usuario";
    private static final String COLUMN_META_FINAL = "meta_final";
    private static final String COLUMN_PLUS = "plus";
    private static final String COLUMN_BENEFIT = "benefit";
    private static final String COLUMN_CLASICA = "clasica";
    private static final String COLUMN_UPGRADE = "upgrade";
    private static final String COLUMN_GE = "ge";
    private static final String COLUMN_BAIT = "bait";
    private static final String COLUMN_BAIT_B = "bait_b";
    private static final String COLUMN_SALUD = "salud";
    private static final String COLUMN_PLUS_GANANCIA_UNITARIA = "plus_ganancia_unitaria";
    private static final String COLUMN_BENEFIT_GANANCIA_UNITARIA = "benefit_ganancia_unitaria";
    private static final String COLUMN_CLASICA_GANANCIA_UNITARIA = "clasica_ganancia_unitaria";
    private static final String COLUMN_UPGRADE_GANANCIA_UNITARIA = "upgrade_ganancia_unitaria";
    private static final String COLUMN_GE_GANANCIA_UNITARIA = "ge_ganancia_unitaria";
    private static final String COLUMN_PLUS_GANANCIA_TOTAL = "plus_ganancia_total";
    private static final String COLUMN_BENEFIT_GANANCIA_TOTAL = "benefit_ganancia_total";
    private static final String COLUMN_CLASICA_GANANCIA_TOTAL = "clasica_ganancia_total";
    private static final String COLUMN_UPGRADE_GANANCIA_TOTAL = "upgrade_ganancia_total";
    private static final String COLUMN_GE_GANANCIA_TOTAL = "ge_ganancia_total";
    private static final String COLUMN_NO_SEMANA = "no_semana";

    // private static final String COLUMN_ID_SEMANA = "id_semana";

    //ASIGNACION DE NUEVA VARIABLE AFILIACION
    private static final String COLUMN_AFILIACION ="afiliacion";
    private static final String COLUMN_AFILIACION_GANANCIA_TOTAL = "afiliacion_ganancia_total";

    private static final String COLUMN_TOTAL = "total";

    private Context context;

    //SharedPreference

    // SharedPreferences para la última fecha de apertura
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String LAST_OPEN_DATE_KEY = "lastOpenDate";



    public DataBaseIncentiveWeek(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context=context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE = "CREATE TABLE " + TABLE_INCENTIVE_WEEK + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_META_USUARIO + " INTEGER DEFAULT 0,"    // Valor por defecto
                + COLUMN_META_FINAL + " INTEGER DEFAULT 0,"    // Valor por defecto
                + COLUMN_PLUS + " INTEGER DEFAULT 0,"    // Valor por defecto
                + COLUMN_BENEFIT + " INTEGER DEFAULT 0," // Valor por defecto
                + COLUMN_CLASICA + " INTEGER DEFAULT 0," // Valor por defecto
                + COLUMN_UPGRADE + " INTEGER DEFAULT 0," // Valor por defecto
                + COLUMN_GE + " INTEGER DEFAULT 0,"      // Valor por defecto
                + COLUMN_BAIT + " INTEGER DEFAULT 0,"    // Valor por defecto
                + COLUMN_BAIT_B + " INTEGER DEFAULT 0,"  // Valor por defecto
                + COLUMN_SALUD + " INTEGER DEFAULT 0,"   // Valor por defecto
                + COLUMN_PLUS_GANANCIA_UNITARIA + " INTEGER DEFAULT 30,"     // Valor por defecto
                + COLUMN_BENEFIT_GANANCIA_UNITARIA + " INTEGER DEFAULT 15,"  // Valor por defecto
                + COLUMN_CLASICA_GANANCIA_UNITARIA + " INTEGER DEFAULT 12,"  // Valor por defecto
                + COLUMN_UPGRADE_GANANCIA_UNITARIA + " INTEGER DEFAULT 50," // Valor por defecto
                + COLUMN_GE_GANANCIA_UNITARIA + " INTEGER DEFAULT 50,"      // Valor por defecto
                + COLUMN_PLUS_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"        // Valor por defecto
                + COLUMN_BENEFIT_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"     // Valor por defecto
                + COLUMN_CLASICA_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"     // Valor por defecto
                + COLUMN_UPGRADE_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"     // Valor por defecto
                + COLUMN_GE_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"
                + COLUMN_NO_SEMANA + " INTEGER DEFAULT 0,"  // Valor por defecto
                + COLUMN_TOTAL + " INTEGER DEFAULT 0, "
                + COLUMN_AFILIACION + " INTEGER DEFAULT 0," //ACTUALIZACION NUEVA COLUMNA
                + COLUMN_AFILIACION_GANANCIA_TOTAL + " INTEGER DEFAULT 0"

                // + COLUMN_ID_SEMANA + " INTEGER DEFAULT 0"

                // Valor por defecto
                + ")";


        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Calendar calendar = Calendar.getInstance();

        // Si es sábado, crear una nueva tabla con un nombre único (incluyendo la fecha)
       /* if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            String newTableName = TABLE_INCENTIVE + "_" + new getCurrentDate().getCurrentDate();

            // Verificar si la tabla ya existe antes de crearla
            if (!doesTableExist(db, newTableName)) {
                String CREATE_NEW_TABLE = "CREATE TABLE " + newTableName + " ("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COLUMN_META + " INTEGER DEFAULT 0,"
                        + COLUMN_PLUS + " INTEGER DEFAULT 0,"
                        + COLUMN_BENEFIT + " INTEGER DEFAULT 0,"
                        + COLUMN_CLASICA + " INTEGER DEFAULT 0,"
                        + COLUMN_UPGRADE + " INTEGER DEFAULT 0,"
                        + COLUMN_GE + " INTEGER DEFAULT 0,"
                        + COLUMN_BAIT + " INTEGER DEFAULT 0,"
                        + COLUMN_BAIT_B + " INTEGER DEFAULT 0,"
                        + COLUMN_SALUD + " INTEGER DEFAULT 0,"
                        + COLUMN_PLUS_GANANCIA_UNITARIA + " INTEGER DEFAULT 0,"
                        + COLUMN_BENEFIT_GANANCIA_UNITARIA + " INTEGER DEFAULT 0,"
                        + COLUMN_CLASICA_GANANCIA_UNITARIA + " INTEGER DEFAULT 0,"
                        + COLUMN_UPGRADE_GANANCIA_UNITARIA + " INTEGER DEFAULT 50,"
                        + COLUMN_GE_GANANCIA_UNITARIA + " INTEGER DEFAULT 50,"
                        + COLUMN_PLUS_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"
                        + COLUMN_BENEFIT_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"
                        + COLUMN_CLASICA_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"
                        + COLUMN_UPGRADE_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"
                        + COLUMN_GE_GANANCIA_TOTAL + " INTEGER DEFAULT 0,"
                        + COLUMN_TOTAL + " INTEGER DEFAULT 0"
                        + ")";
                db.execSQL(CREATE_NEW_TABLE);
            }
        } else {
            // Si la tabla principal no existe, crearla
            if (!doesTableExist(db, TABLE_INCENTIVE)) {
                onCreate(db);
            }
        }*/




        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCENTIVE_WEEK);
        onCreate(db);
    }


    public String getTableIncentiveWeekString(){
        return TABLE_INCENTIVE_WEEK;
    }

    private boolean doesTableExist(SQLiteDatabase db, String tableName) {
        Cursor cursor = db.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name=?",
                new String[]{tableName});

        boolean tableExists = cursor.getCount() > 0;
        cursor.close();
        return tableExists;
    }

    // Método para insertar una fila solo una vez a la semana
    public void insertRowOnceAWeek() {
        // Obtener la fecha actual


        SQLiteDatabase db = this.getWritableDatabase();
        boolean condicion = verificarYSincronizar();
        boolean condicion2= !isFirstRowWeek(db);

        try {

            // Si es sábado, crear una nueva tabla con un nombre único (incluyendo la fecha)
            if ((condicion && condicion2)|| isFirstTime(db)) {//Aqui agregar la funcion if para la opcion verificaYsincronizar


                String WeekDate = new getCurrentDate().getCurrentDate();
                ContentValues values = new ContentValues();
                //valores por defecto
                int num_semana= Integer.parseInt(readLastRowData("no_semana")+1);

                values.put(COLUMN_DATE , date);
                values.put(COLUMN_META_USUARIO, 0);
                values.put(COLUMN_META_FINAL,30);
                values.put(COLUMN_PLUS, 0); // Valor por defecto
                values.put(COLUMN_BENEFIT, 0); // Valor por defecto
                values.put(COLUMN_CLASICA, 0); // Valor por defecto
                values.put(COLUMN_UPGRADE, 0); // Valor por defecto
                values.put(COLUMN_GE, 0); // Valor por defecto
                values.put(COLUMN_BAIT, 0); // Valor por defecto
                values.put(COLUMN_BAIT_B, 0); // Valor por defecto
                values.put(COLUMN_SALUD, 0); // Valor por defecto
                values.put(COLUMN_PLUS_GANANCIA_UNITARIA, 30); // Valor por defecto
                values.put(COLUMN_BENEFIT_GANANCIA_UNITARIA, 15); // Valor por defecto
                values.put(COLUMN_CLASICA_GANANCIA_UNITARIA, 12); // Valor por defecto
                values.put(COLUMN_UPGRADE_GANANCIA_UNITARIA, 50); // Valor por defecto
                values.put(COLUMN_GE_GANANCIA_UNITARIA, 50); // Valor por defecto
                values.put(COLUMN_PLUS_GANANCIA_TOTAL, 0); // Valor por defecto
                values.put(COLUMN_BENEFIT_GANANCIA_TOTAL, 0); // Valor por defecto
                values.put(COLUMN_CLASICA_GANANCIA_TOTAL, 0); // Valor por defecto
                values.put(COLUMN_UPGRADE_GANANCIA_TOTAL, 0); // Valor por defecto
                values.put(COLUMN_GE_GANANCIA_TOTAL, 0); // Valor por defecto
                values.put(COLUMN_NO_SEMANA, num_semana);
                values.put(COLUMN_TOTAL, 0);
                values.put(COLUMN_AFILIACION, 0);
                values.put(COLUMN_AFILIACION_GANANCIA_TOTAL,0);


                // Insertar fila en la base de datos
                db.insert(TABLE_INCENTIVE_WEEK, null, values);



                SharedPreferences sharedPreferences = context.getSharedPreferences("IncentivePrefs", Context.MODE_PRIVATE);
                // Guardar la fecha de la inserción de esta semana en SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("last_inserted_date", WeekDate);
                editor.apply(); // Confirmar cambios
            }


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            db.close();
        }
    }

    public boolean isFirstRowWeek(SQLiteDatabase db){


        int day= Integer.parseInt(new getCurrentDate().getDayDate());

        if (day==7){
            String todayDate=new getCurrentDate().getCurrentDate();
            String query = "SELECT * FROM " + TABLE_INCENTIVE_WEEK + " WHERE " + COLUMN_DATE + " = ?";

            // Ejecutar la consulta, pasando la fecha de hoy como parámetro
            Cursor cursor = db.rawQuery(query, new String[]{todayDate});

            if (cursor != null && cursor.moveToFirst()) {
                cursor.close();
                return true;
            }


            return  false;
        }
        else return false;



    }

    public boolean isFirstTime(SQLiteDatabase db) {
        String countQuery = "SELECT COUNT(*) FROM " + TABLE_INCENTIVE_WEEK;
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int rowCount = cursor.getInt(0);
        cursor.close();
        return rowCount == 0; // Devuelve true si no hay filas (es la primera vez)
    }


    public Cursor getLastRow() {
        SQLiteDatabase db=this.getWritableDatabase();



        // Consulta para obtener la última fila
        String query = "SELECT * FROM " + TABLE_INCENTIVE_WEEK+ " ORDER BY id DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null& cursor.moveToFirst()) {
           return cursor;  // Mover el cursor a la primera (y única) fila
        }

        return null;
    }


    public void updateLastRow(String column, String valor) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Obtener el ID de la última fila
        Cursor lastRow = getLastRow();


        if (lastRow != null && lastRow.moveToFirst()) {

            int id =lastRow.getColumnIndex("id");

            int lastId = lastRow.getInt(id);//lastRow.getColumnIndex("id")

            // Crear un objeto ContentValues con los nuevos valores
            ContentValues values = new ContentValues();

            String valUnit="";
            String valUnitT="";
//{"Plus", "Benefit", "Clasica", "Upgrade" ,"Garantia Extendida", "Chip Bait", "Chip Bait Renovacion", "Membresia de Salud"}
            switch (column){
                case "Afiliacion":  //ACTUALIZACION
                    values.put(COLUMN_AFILIACION, valor);//ACTUALIZACION
                    break;

                case "Plus":
                    values.put(COLUMN_PLUS, valor);
                    break;
                case "Benefit":
                    values.put(COLUMN_BENEFIT, valor);
                    break;
                case "Clasica":
                    values.put(COLUMN_CLASICA, valor);
                    break;
                case "Upgrade":
                    values.put(COLUMN_UPGRADE, valor);
                    break;
                case "Garantia Extendida":
                    values.put(COLUMN_GE, valor);
                    break;
                case "Chip Bait":
                    values.put(COLUMN_BAIT, valor);
                    break;
                case "Chip Bait Renovacion":
                    values.put(COLUMN_BAIT_B, valor);
                    break;

                case "Membresia de Salud":
                    values.put(COLUMN_SALUD, valor);
                    break;

                case "Afiliacion_total":
                    valUnitT="Afiliacion_t";
                    values.put(COLUMN_AFILIACION_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))+ 5);


                    break;

                case "Plus_total":
                    valUnit="plus_u";
                    valUnitT="Plus_t";
                    values.put(COLUMN_PLUS_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))+ Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Benefit_total":
                    valUnit="benefit_u";
                    valUnitT="Benefit_t";
                    values.put(COLUMN_BENEFIT_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))+ Integer.parseInt(this.readLastRowData(valUnit)));  break;
                case "Clasica_total":
                    valUnit="clasica_u";
                    valUnitT="Clasica_t";
                    values.put(COLUMN_CLASICA_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))+ Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Upgrade_total":
                    valUnit="upgrade_u";
                    valUnitT="Upgrade_t";
                    values.put(COLUMN_UPGRADE_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))+  Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Garantia Extendida_total":
                    valUnit="ge_u";
                    valUnitT="Garantia Extendida_t";
                    values.put(COLUMN_GE_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))+  Integer.parseInt(this.readLastRowData(valUnit)));

                    break;
                case "Afiliacion_total_r":
                    valUnitT="Afiliacion_t";
                    values.put(COLUMN_AFILIACION_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))-5);


                    break;

                case "Plus_total_r":
                    valUnit="plus_u";
                    valUnitT="Plus_t";
                    values.put(COLUMN_PLUS_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))- Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Benefit_total_r":
                    valUnit="benefit_u";
                    valUnitT="Benefit_t";
                    values.put(COLUMN_BENEFIT_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))- Integer.parseInt(this.readLastRowData(valUnit)));  break;
                case "Clasica_total_r":
                    valUnit="clasica_u";
                    valUnitT="Clasica_t";
                    values.put(COLUMN_CLASICA_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))- Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Upgrade_total_r":
                    valUnit="upgrade_u";
                    valUnitT="Upgrade_t";
                    values.put(COLUMN_UPGRADE_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))-  Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Garantia Extendida_total_r":
                    valUnit="ge_u";
                    valUnitT="Garantia Extendida_t";
                    values.put(COLUMN_GE_GANANCIA_TOTAL,Integer.parseInt(this.readLastRowData(valUnitT))-  Integer.parseInt(this.readLastRowData(valUnit)));

                    break;
                case "Chip Bait_total_r":
                    valor = String.valueOf(0);
                    values.put(COLUMN_BAIT, valor);
                    break;
                case "Chip Bait Renovacion_total_r":
                    valor = String.valueOf(0);
                    values.put(COLUMN_BAIT_B, valor);
                    break;


                case "Membresia de Salud_total_r":
                    valor = String.valueOf(0);
                    values.put(COLUMN_SALUD, valor);
                    break;


                case "Plus_total_Cambio":
                    valUnit="plus_u";
                    values.put(COLUMN_PLUS_GANANCIA_TOTAL,Integer.parseInt(valor)* Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Benefit_total_Cambio":
                    valUnit="benefit_u";
                    values.put(COLUMN_BENEFIT_GANANCIA_TOTAL,Integer.parseInt(valor)* Integer.parseInt(this.readLastRowData(valUnit)));  break;
                case "Clasica_total_Cambio":
                    valUnit="clasica_u";
                    values.put(COLUMN_CLASICA_GANANCIA_TOTAL,Integer.parseInt(valor)* Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Upgrade_total_Cambio":
                    valUnit="upgrade_u";
                    values.put(COLUMN_UPGRADE_GANANCIA_TOTAL,Integer.parseInt(valor)* Integer.parseInt(this.readLastRowData(valUnit)));
                    break;
                case "Garantia Extendida_total_Cambio":
                    valUnit="ge_u";
                    values.put(COLUMN_GE_GANANCIA_TOTAL,Integer.parseInt(valor)* Integer.parseInt(this.readLastRowData(valUnit)));

                    break;
                case "Chip Bait_total":
                    valor = String.valueOf(0);
                    values.put(COLUMN_BAIT, valor);
                    break;
                case "Chip Bait Renovacion_total":
                    valor = String.valueOf(0);
                    values.put(COLUMN_BAIT_B, valor);
                    break;


                case "Membresia de Salud_total":
                    valor = String.valueOf(0);
                    values.put(COLUMN_SALUD, valor);
                    break;

                case "total":
                    int valPlus= Integer.parseInt(this.readLastRowData("Plus_t"));
                    int valBenefit= Integer.parseInt(this.readLastRowData("Benefit_t"));
                    int valClasica= Integer.parseInt(this.readLastRowData("Clasica_t"));
                    int valUpgrade= Integer.parseInt(this.readLastRowData("Upgrade_t"));
                    int valAfil= Integer.parseInt(this.readLastRowData("Afiliacion_t"));

                    int valTotal= valPlus+valBenefit+valClasica+valUpgrade+valAfil;
                    valor=String.valueOf(valTotal);

                    values.put(COLUMN_TOTAL, valor);
                    break;


                case "Plus_u":
                    values.put(COLUMN_PLUS_GANANCIA_UNITARIA, valor);

                    break;
                case "Benefit_u":
                    values.put(COLUMN_BENEFIT_GANANCIA_UNITARIA, valor);

                    break;
                case "Clasica_u":
                    values.put(COLUMN_CLASICA_GANANCIA_UNITARIA, valor);

                    break;

                case "meta":


                    values.put(COLUMN_META_FINAL,valor);
                    break;

                case "meta_usuario":
                    int valAfil_C= Integer.parseInt(this.readLastRowData("Afiliacion"));
                    int valPlus_C= Integer.parseInt(this.readLastRowData("Plus"));
                    int valBenefit_C= Integer.parseInt(this.readLastRowData("Benefit"));
                    int valClasica_C= Integer.parseInt(this.readLastRowData("Clasica"));


                    int valTotal_C= valPlus_C+valBenefit_C+valClasica_C+valAfil_C;
                    valor=String.valueOf(valTotal_C);
                    values.put(COLUMN_META_USUARIO,valor);

                    break;

                default:
                    Toast.makeText(context,"Error al agregar valor", Toast.LENGTH_LONG).show();
                    break;
            }

            // Actualizar la fila

            db.update(TABLE_INCENTIVE_WEEK, values, "id = ?", new String[]{String.valueOf(lastId)});
        }

        if (lastRow != null) {
            lastRow.close();
        }

        db.close();
    }


    public String readLastRowData(String column) {
        Cursor lastRow = getLastRow();
        int val=0, resInt=0;
        String res="";

        // Verificar si el cursor tiene resultados
        if (lastRow != null && lastRow.moveToFirst()) {



            // Obtener los valores de las columnas de la última fila
            // int id = lastRow.getInt(lastRow.getColumnIndex("id"));
            // int meta = lastRow.getInt(lastRow.getColumnIndex("meta"));
            //
            // int benefit = lastRow.getInt(lastRow.getColumnIndex("benefit"));
            //  String dateCreated = lastRow.getString(lastRow.getColumnIndex("date_created"));

            // Mostrar los datos de la última fila
            // System.out.println("Última fila - ID: " + id + ", Meta: " + meta + ", Plus: " + plus + ", Benefit: " + benefit + ", Fecha: " + dateCreated);
            switch (column){

                case "id":
                    val= (lastRow.getColumnIndex(COLUMN_ID));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "Afiliacion":
                    val= (lastRow.getColumnIndex(COLUMN_AFILIACION));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Plus":
                    val= (lastRow.getColumnIndex(COLUMN_PLUS));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Benefit":
                    val= (lastRow.getColumnIndex(COLUMN_BENEFIT));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Clasica":
                    val= (lastRow.getColumnIndex(COLUMN_CLASICA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Upgrade":
                    val= (lastRow.getColumnIndex(COLUMN_UPGRADE));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Garantia Extendida":
                    val= (lastRow.getColumnIndex(COLUMN_GE));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Chip Bait":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Chip Bait Renovacion":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT_B));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "Membresia de Salud":
                    val= (lastRow.getColumnIndex(COLUMN_SALUD));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                //Aqui iran los demas ..
                case "Afiliacion_t":
                    val= (lastRow.getColumnIndex(COLUMN_AFILIACION_GANANCIA_TOTAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Plus_t":
                    val= (lastRow.getColumnIndex(COLUMN_PLUS_GANANCIA_TOTAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Benefit_t":
                    val= (lastRow.getColumnIndex(COLUMN_BENEFIT_GANANCIA_TOTAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Clasica_t":
                    val= (lastRow.getColumnIndex(COLUMN_CLASICA_GANANCIA_TOTAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Upgrade_t":
                    val= (lastRow.getColumnIndex(COLUMN_UPGRADE_GANANCIA_TOTAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Garantia Extendida_t":
                    val= (lastRow.getColumnIndex(COLUMN_GE_GANANCIA_TOTAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Chip Bait_t":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "Chip Bait renovacion_t":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT_B));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "Membresia de Salud_t":
                    val= (lastRow.getColumnIndex(COLUMN_SALUD));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "plus_u":
                    val= (lastRow.getColumnIndex(COLUMN_PLUS_GANANCIA_UNITARIA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "benefit_u":
                    val= (lastRow.getColumnIndex(COLUMN_BENEFIT_GANANCIA_UNITARIA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "clasica_u":
                    val= (lastRow.getColumnIndex(COLUMN_CLASICA_GANANCIA_UNITARIA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "upgrade_u":
                    val= (lastRow.getColumnIndex(COLUMN_UPGRADE_GANANCIA_UNITARIA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "ge_u":
                    val= (lastRow.getColumnIndex(COLUMN_GE_GANANCIA_UNITARIA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "bait_u":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "bait_b_u":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT_B));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "salud_u":
                    val= (lastRow.getColumnIndex(COLUMN_SALUD));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "total":
                    val= (lastRow.getColumnIndex(COLUMN_TOTAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "meta":

                    val= (lastRow.getColumnIndex(COLUMN_META_FINAL));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);

                    break;
                case "meta_usuario":
                    val= (lastRow.getColumnIndex(COLUMN_META_USUARIO));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "no_semana":
                    val= (lastRow.getColumnIndex(COLUMN_NO_SEMANA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;



                default:
                    Toast.makeText(context,"Error al encontrar valor", Toast.LENGTH_LONG).show();
                    break;
            }

        } else {
            System.out.println("No se encontraron filas en la tabla.");
        }

        // Cerrar el cursor
        if (lastRow != null) {
            lastRow.close();
        }

        return res;
    }




    public boolean verificarYSincronizar() {
        // Obtener la última fecha de ejecución desde SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String lastOpenDateStr = sharedPreferences.getString(LAST_OPEN_DATE_KEY, null);

        Calendar today = Calendar.getInstance();  // Fecha actual
        Calendar lastOpenDate = Calendar.getInstance();

        if (lastOpenDateStr != null) {
            // Parsear la fecha guardada
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date date = sdf.parse(lastOpenDateStr);
                lastOpenDate.setTime(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Si es la primera vez que se abre la app
            lastOpenDate.setTimeInMillis(0);  // Usar una fecha muy antigua
        }

        // Verificar si hoy es sábado o si la última apertura fue antes del sábado pasado
        if (isSabadoHoy() || pasoUltimoSabado(lastOpenDate, today)) {
            // Guardar la fecha de hoy como última ejecución
            SharedPreferences.Editor editor = sharedPreferences.edit();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            editor.putString(LAST_OPEN_DATE_KEY, sdf.format(today.getTime()));
            editor.apply();
                if(Integer.parseInt(new getCurrentDate().getDayDate())==1)
            return false; // Se debe crear una nueva fila
                else  return true;//no se crea porque es domingo
        }

        // Guardar la fecha de hoy aunque no se necesite crear la fila
        SharedPreferences.Editor editor = sharedPreferences.edit();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        editor.putString(LAST_OPEN_DATE_KEY, sdf.format(today.getTime()));
        editor.apply();

        return false;  // No se necesita crear una fila
    }

    // Verificar si hoy es sábado
    private boolean isSabadoHoy() {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
    }

    // Verificar si la última apertura fue antes del último sábado
    private boolean pasoUltimoSabado(Calendar lastOpenDate, Calendar today) {
        Calendar lastSaturday = (Calendar) today.clone();
        // Buscar el último sábado
        while (lastSaturday.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
            lastSaturday.add(Calendar.DAY_OF_WEEK, -1);
        }

        // Compara la última apertura con el último sábado
        return lastOpenDate.before(lastSaturday);
    }


}