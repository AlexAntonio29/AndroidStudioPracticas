package com.angel.gestordeincentivos;

    import android.content.ContentValues;
    import android.content.Context;
    import android.content.SharedPreferences;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.widget.Toast;

    import java.util.Calendar;


public class DataBaseIncentiveDay extends SQLiteOpenHelper {

    //CONSTANTE DE AUMENTO DESPUES DE SUPERAR LA META
    public static int proMeta=20;

    public int sumador=0;



    private static final String date = new getCurrentDate().getCurrentDate();
    private static final String DATABASE_NAME = "my_databaseincentivo_day.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_INCENTIVE_DAY = "table_incentive_day";

    // Definir las columnas con valores por defecto
    private static final String COLUMN_ID = "id";//"T"+date + (new getCurrentDate().getDayDate());
    private static final String COLUMN_DATE = "fecha";
   // private static final String COLUMN_META = "meta";
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

    //ASIGNACION DE NUEVA VARIABLE AFILIACION
    private static final String COLUMN_AFILIACION ="afiliacion";
    private static final String COLUMN_NO_SEMANA = "no_semana";
   // private static final String COLUMN_ID_SEMANA = "id_semana";
    private static final String COLUMN_TOTAL = "total";

    private Context context;




    public DataBaseIncentiveDay(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        SQLiteDatabase db=this.getWritableDatabase();
        boolean p=doesTableExist(db,TABLE_INCENTIVE_DAY);
        db.close();

    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE = "CREATE TABLE " + TABLE_INCENTIVE_DAY + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DATE + " TEXT,"
                //+ COLUMN_META + " INTEGER DEFAULT 0,"    // Valor por defecto
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
                + COLUMN_NO_SEMANA + " INTEGER DEFAULT 0,"
                // Valor por defecto
                + COLUMN_TOTAL + " INTEGER DEFAULT 0"
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

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCENTIVE_DAY);
        onCreate(db);
    }

    private boolean doesTableExist(SQLiteDatabase db, String tableName) {
        Cursor cursor = db.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name=?",
                new String[]{tableName});

        boolean tableExists = cursor.getCount() > 0;
        cursor.close();
        return tableExists;
    }

    // Método para insertar una fila solo una vez al día
    public void insertRowOnceADay() {



        //boolean exist= doesTableExist(db,TABLE_INCENTIVE_DAY);

        // Obtener la fecha actual
        String todayDate = new getCurrentDate().getCurrentDate();

        // Recuperar SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences("IncentivePrefs", Context.MODE_PRIVATE);
        String lastInsertedDate = sharedPreferences.getString("last_inserted_date", "");




        SQLiteDatabase db = this.getWritableDatabase();
        boolean a=isFirstTime(db);
        boolean b=!isFirstRowToday(db,todayDate);

        // Si no se ha hecho una inserción hoy, hacerla
        if (isFirstTime(db) ||!isFirstRowToday(db,todayDate)) {

            //String valor = this.readLastRowData("plus_u");


            //SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            //valores por defecto
            int num_semana;
           /* if (isFirstTime(db))  num_semana=1;
            else */
            DataBaseIncentiveWeek dbWeek = new DataBaseIncentiveWeek(context);
          num_semana= Integer.parseInt(dbWeek.readLastRowData("no_semana"));

           values.put(COLUMN_DATE , date);
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




            // Insertar fila en la base de datos
            db.insert(TABLE_INCENTIVE_DAY, null, values);
            db.close();



            // Guardar la fecha de la inserción de hoy en SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("last_inserted_date", todayDate);
            editor.apply(); // Confirmar cambios
        }
    }

    public boolean isFirstRowToday(SQLiteDatabase db,String todayDate){

        String query = "SELECT * FROM " + TABLE_INCENTIVE_DAY + " WHERE " + COLUMN_DATE + " = ?";

        // Ejecutar la consulta, pasando la fecha de hoy como parámetro
        Cursor cursor = db.rawQuery(query, new String[]{todayDate});

        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();
            return true;
        }


        return  false;
    }



    public boolean isFirstTime(SQLiteDatabase db) {
        String countQuery = "SELECT COUNT(*) FROM " + TABLE_INCENTIVE_DAY;
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int rowCount = cursor.getInt(0);
        cursor.close();
        return rowCount == 0; // Devuelve true si no hay filas (es la primera vez)
    }


    public Cursor getLastRow() {


        SQLiteDatabase db = this.getReadableDatabase();

        // Obtener la fecha actual desde el método getCurrentDate()
        String todayDate =new getCurrentDate().getCurrentDate();

        // Consulta para obtener la fila con la fecha de hoy
        String query = "SELECT * FROM " + TABLE_INCENTIVE_DAY + " WHERE " + COLUMN_DATE + " = ?";

        // Ejecutar la consulta, pasando la fecha de hoy como parámetro
        Cursor cursor = db.rawQuery(query, new String[]{todayDate});

        if (cursor != null && cursor.moveToFirst()) {

          return cursor; //devolver dia de hoy



            // Mover el cursor a la primera fila y devolverla
        }

        return null;  // Devuelve el cursor con la última fila
    }

    public Cursor getRowChange(String id){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_INCENTIVE_DAY + " WHERE " + COLUMN_ID + " = " +id;
        //SELECT * FROM incentivosDia WHERE ColumnaId = 5
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && !cursor.isClosed() && cursor.moveToNext())
            return cursor;

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

          //  int metaFinal= Integer.parseInt(this.readLastRowData("meta"));
           // int metaUsuario= Integer.parseInt(this.readLastRowData("meta_usuario"));

            String valUnit="";
            String valUnitT="";
//{"Plus", "Benefit", "Clasica", "Upgrade" ,"Garantia Extendida", "Chip Bait", "Chip Bait Renovacion", "Membresia de Salud"}
            switch (column){

                case "Plus":
                    values.put(COLUMN_PLUS, valor);
                    break;
                case "Benefit":
                    values.put(COLUMN_BENEFIT, valor);
                    break;
                case "Clasica":
                    values.put(COLUMN_CLASICA, valor);
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
              /*  case "Chip Bait_total_r":
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
                    break;*/



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
             /*   case "Chip Bait_total":
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
                    break;*/



                default:
                   break;
            }

            // Actualizar la fila


            if (!(values == null || values.size() == 0)) db.update(TABLE_INCENTIVE_DAY, values, "id = ?", new String[]{String.valueOf(lastId)});

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

                case "plus":
                   val= (lastRow.getColumnIndex(COLUMN_PLUS));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "benefit":
                     val= (lastRow.getColumnIndex(COLUMN_BENEFIT));
                     resInt = lastRow.getInt(val);
                     res=String.valueOf(resInt);
                    break;
                case "clasica":
                    val= (lastRow.getColumnIndex(COLUMN_CLASICA));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "upgrade":
                    val= (lastRow.getColumnIndex(COLUMN_UPGRADE));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "ge":
                    val= (lastRow.getColumnIndex(COLUMN_GE));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "bait":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;
                case "bait_b":
                    val= (lastRow.getColumnIndex(COLUMN_BAIT_B));
                    resInt = lastRow.getInt(val);
                    res=String.valueOf(resInt);
                    break;

                case "salud":
                    val= (lastRow.getColumnIndex(COLUMN_SALUD));
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
                case "bait_t":

                    res=String.valueOf(resInt);
                    break;
                case "bait_b_t":

                    res=String.valueOf(resInt);
                    break;

                case "salud_t":

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

                case "date":
                    val= (lastRow.getColumnIndex(COLUMN_DATE));
                    res=lastRow.getString(val);

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
    //get para obtener la constante meta






}

