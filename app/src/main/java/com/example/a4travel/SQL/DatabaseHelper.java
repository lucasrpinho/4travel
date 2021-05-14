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
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ControleUsuario.bd";
    // User table name
    private static final String TABLE_USUARIO = "usuario";
    // User Table Columns names
    private static final String COLUMN_USUARIO_ID = "usuario_id";
    private static final String COLUMN_USUARIO_NOME = "usuario_nome";
    private static final String COLUMN_USUARIO_EMAIL = "usuario_email";
    private static final String COLUMN_USUARIO_SENHA = "usuario_senha";
    private List<User> listUsers;

    // create table sql query
    private String CREATE_USUARIO_TABLE = "CREATE TABLE " + TABLE_USUARIO + "("
            + COLUMN_USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USUARIO_NOME + " TEXT,"
            + COLUMN_USUARIO_EMAIL + " TEXT," + COLUMN_USUARIO_SENHA + " TEXT" + ")";

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
        //Drop User Table if exist
        db.execSQL(DROP_USUARIO_TABLE);
        // Create tables again
        onCreate(db);
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
