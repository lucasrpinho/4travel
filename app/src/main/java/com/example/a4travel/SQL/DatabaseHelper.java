package com.example.a4travel.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a4travel.model.User;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 6;
    // Database Name
    private static final String DATABASE_NAME = "ControleUsuario.bd";
    // User table name
    private static final String TABLE_USUARIO = "usuario";
    private static final String TABLE_ROTEIRO = "roteiro";
    // User Table Columns names
    private static final String COLUMN_USUARIO_ID = "usuario_id";
    private static final String COLUMN_USUARIO_NOME = "usuario_nome";
    private static final String COLUMN_USUARIO_EMAIL = "usuario_email";
    private static final String COLUMN_USUARIO_SENHA = "usuario_senha";
    private static final String COLUMN_ROTEIRO_REGIAO = "roteiro_regiao";
    private static final String COLUMN_ROTEIRO_HOTEL = "roteiro_hotel";
    private static final String COLUMN_ROTEIRO_ID = "roteiro_id";
    private static final String COLUMN_ROTEIRO_GASTRONOMIA_NOTURNA = "roteiro_gastronomia_noturna";
    private static final String COLUMN_ROTEIRO_GASTRONOMIA_ALMOÇO = "roteiro_gastronomia_almoço";
    private static final String COLUMN_ROTEIRO_GASTRONOMIA_MATINAL = "roteiro_gastronomia_matinal";
    private static final String COLUMN_ROTEIRO_PASSEIO_MATINAL = "roteiro_passeio_matinal";
    private static final String COLUMN_ROTEIRO_PASSEIO_VESPERTINO = "roteiro_passeio_vespertino";
    private static final String COLUMN_ROTEIRO_PASSEIO_NOTURNO = "roteiro_passeio_noturno";
    private List<User> listUsers;



    // create table sql query
    private String CREATE_USUARIO_TABLE = "CREATE TABLE " + TABLE_USUARIO + "("
            + COLUMN_USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USUARIO_NOME + " TEXT,"
            + COLUMN_USUARIO_EMAIL + " TEXT," + COLUMN_USUARIO_SENHA + " TEXT," + DatabaseHelper.COLUMN_ROTEIRO_HOTEL + " TEXT,"
            + COLUMN_ROTEIRO_GASTRONOMIA_MATINAL + " TEXT," + COLUMN_ROTEIRO_GASTRONOMIA_ALMOÇO + " TEXT," + COLUMN_ROTEIRO_GASTRONOMIA_NOTURNA + " TEXT,"
            + COLUMN_ROTEIRO_PASSEIO_MATINAL + " TEXT," + COLUMN_ROTEIRO_PASSEIO_VESPERTINO + " TEXT," + COLUMN_ROTEIRO_PASSEIO_NOTURNO + " TEXT," + COLUMN_ROTEIRO_REGIAO + " TEXT" + ")";


    // drop table sql query
    private String DROP_USUARIO_TABLE = "DROP TABLE IF EXISTS " + TABLE_USUARIO;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USUARIO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_USUARIO_TABLE);
        // Create tables again
        onCreate(db);
    }

    public String getGastronomia_matinal(String email) {
        String gastronomia = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = "usuario_email= ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            gastronomia = csr.getString(csr.getColumnIndex(COLUMN_ROTEIRO_GASTRONOMIA_MATINAL));
        }
        return gastronomia;
    }

    public String getGastronomia_noturna(String email) {
        String gastronomia = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = "usuario_email= ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            gastronomia = csr.getString(csr.getColumnIndex(COLUMN_ROTEIRO_GASTRONOMIA_NOTURNA));
        }
        return gastronomia;
    }

    public String getGastronomia_almoço(String email) {
        String gastronomia = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = "usuario_email= ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            gastronomia = csr.getString(csr.getColumnIndex(COLUMN_ROTEIRO_GASTRONOMIA_ALMOÇO));
        }
        return gastronomia;
    }


    public String getPasseioMatinal(String email) {
        String passeio = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = "usuario_email= ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            passeio = csr.getString(csr.getColumnIndex(COLUMN_ROTEIRO_PASSEIO_MATINAL));
        }
        return passeio;
    }

    public String getPasseioVespertino(String email) {
        String passeio = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = "usuario_email= ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            passeio = csr.getString(csr.getColumnIndex(COLUMN_ROTEIRO_PASSEIO_VESPERTINO));
        }
        return passeio;
    }

    public String getPasseioNoturno(String email) {
        String passeio = "";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = "usuario_email= ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            passeio = csr.getString(csr.getColumnIndex(COLUMN_ROTEIRO_PASSEIO_NOTURNO));
        }
        return passeio;
    }

    public String getHotel(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String hotel = "Não escolhido";
        String[] projection = {
                DatabaseHelper.COLUMN_ROTEIRO_HOTEL
        };
        String whereclause = COLUMN_USUARIO_EMAIL + " = ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, projection, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            hotel = csr.getString(csr.getColumnIndex(DatabaseHelper.COLUMN_ROTEIRO_HOTEL));
        }
        csr.close();
        return hotel;
    }

    public String getRegiao(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String regiao = "Não escolhido";
        String[] projection = {
                DatabaseHelper.COLUMN_ROTEIRO_REGIAO
        };
        String whereclause = COLUMN_USUARIO_EMAIL + " = ?";
        String[] whereargs = new String[]{String.valueOf(email)};
        Cursor csr = db.query(TABLE_USUARIO, projection, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()){
            regiao = csr.getString(csr.getColumnIndex(DatabaseHelper.COLUMN_ROTEIRO_REGIAO));
        }
        csr.close();
        return regiao;
    }

    public Boolean addHotel(String email ,String hotel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_HOTEL, hotel);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    public Boolean limparRoteiro(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROTEIRO_REGIAO, "");
        values.put(COLUMN_ROTEIRO_PASSEIO_MATINAL, "");
        values.put(COLUMN_ROTEIRO_PASSEIO_VESPERTINO, "");
        values.put(COLUMN_ROTEIRO_PASSEIO_NOTURNO, "");
        values.put(COLUMN_ROTEIRO_GASTRONOMIA_MATINAL, "");
        values.put(COLUMN_ROTEIRO_GASTRONOMIA_ALMOÇO, "");
        values.put(COLUMN_ROTEIRO_GASTRONOMIA_NOTURNA, "");
        values.put(COLUMN_ROTEIRO_HOTEL, "");
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result==-1) return false;
        else return true;
    }

    public Boolean addGastronomiaMatinal(String email ,String gastronomia){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_GASTRONOMIA_MATINAL, gastronomia);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    public Boolean addGastronomiaAlmoço(String email ,String gastronomia){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_GASTRONOMIA_ALMOÇO, gastronomia);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    public Boolean addGastronomiaNoturno(String email ,String gastronomia){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_GASTRONOMIA_NOTURNA, gastronomia);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    public Boolean addPasseioMatinal(String email, String passeio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_PASSEIO_MATINAL, passeio);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    public Boolean addPasseioVespertino(String email, String passeio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_PASSEIO_VESPERTINO, passeio);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    public Boolean addPasseioNoturno(String email, String passeio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_PASSEIO_NOTURNO, passeio);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    public Boolean addRegiao(String email, String regiao){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ROTEIRO_REGIAO, regiao);
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result ==-1) return false;
        else return true;
    }

    /**
     * This method is to create user record
     *
     * @param user
     */

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USUARIO_NOME, user.getNome());
        values.put(COLUMN_USUARIO_EMAIL, user.getEmail());
        values.put(COLUMN_USUARIO_SENHA, user.getSenha());
        values.put(COLUMN_ROTEIRO_HOTEL, user.getHotel());
        values.put(COLUMN_ROTEIRO_GASTRONOMIA_MATINAL, user.getGastronomiaMatinal());
        values.put(COLUMN_ROTEIRO_GASTRONOMIA_ALMOÇO, user.getGastronomiaAlmoço());
        values.put(COLUMN_ROTEIRO_GASTRONOMIA_NOTURNA, user.getGastronomiaNoturno());
        values.put(COLUMN_ROTEIRO_PASSEIO_VESPERTINO, user.getPasseioVespertino());
        values.put(COLUMN_ROTEIRO_PASSEIO_NOTURNO, user.getPasseioNoturno());
        values.put(COLUMN_ROTEIRO_PASSEIO_MATINAL, user.getPasseioMatinal());
        values.put(COLUMN_ROTEIRO_REGIAO, user.getRegiao());
        // Inserting Row
        db.insert(TABLE_USUARIO, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USUARIO_ID,
                COLUMN_USUARIO_EMAIL,
                COLUMN_USUARIO_NOME,
                COLUMN_USUARIO_SENHA
        };
        // sorting orders
        String sortOrder =
                COLUMN_USUARIO_ID + " ASC";
        List<User> userList = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();
        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USUARIO, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USUARIO_ID))));
                user.setNome(cursor.getString(cursor.getColumnIndex(COLUMN_USUARIO_NOME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USUARIO_EMAIL)));
                user.setSenha(cursor.getString(cursor.getColumnIndex(COLUMN_USUARIO_SENHA)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return user list
        return userList;
    }

    /**
     * This method to update user record
     * @param email
     * @param senha
     */
    public Boolean updateUser(String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USUARIO_SENHA, senha);
        // updating row
        long result = db.update(TABLE_USUARIO, values, COLUMN_USUARIO_EMAIL + "= ?", new String[]{email});
        if (result==-1) return false;
        else
            return true;
    }

    /**
     * This method is to delete user record
     * @param id

    */
    public void deleteUser(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USUARIO, COLUMN_USUARIO_ID + "= ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public boolean checkUser(String email) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USUARIO_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USUARIO_EMAIL + " = ?";
        // selection argument
        String[] selectionArgs = {email};
        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USUARIO, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USUARIO_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USUARIO_EMAIL + " = ?" + " AND " + COLUMN_USUARIO_SENHA + " = ?";
        // selection arguments
        String[] selectionArgs = {email, password};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USUARIO, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
}
