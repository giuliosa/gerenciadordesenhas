package br.aeso.gerenciadordesenhas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by giulio on 15/05/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public final static String BANCO_DADOS = "GerenciadorDeSenha";
    private static int VERSAO = 1;


    public DatabaseHelper(Context context){
        super(context, BANCO_DADOS, null, VERSAO);
    }

    public static class Login{
        public static final String TABELA = "login";
        public static final String _ID = "_id";
        public static final String USUARIO = "usuario";
        public static final String SENHA = "senha";

        public static final String[] COLUNAS = new String[]{
                _ID, USUARIO, SENHA
        };
    }

    public static class Senha{
        public static final String TABELA = "senha";
        public static final String _ID = "_id";
        public static final String APP = "app";
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
        public static final String LOGIN_ID = "login_id";

        public static final String[] COLUNAS = new String[]{
                _ID, APP, LOGIN, PASSWORD, LOGIN_ID
        };
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE login (_id INTEGER PRIMARY KEY," +
                " usuario TEXT, senha INTEGER);");

        db.execSQL("CREATE TABLE senha (_id INTEGER PRIMARY KEY," +
                " app TEXT, login TEXT, password TEXT, login_id INTEGER," +
                "FOREIGN KEY(login_id) REFERENCES login(_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
