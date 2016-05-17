package br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.aeso.gerenciadordesenhas.DatabaseHelper;
import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.domain.Login;
import br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.domain.Senha;

/**
 * Created by giulio on 15/05/16.
 */
public class SenhaDAO {
    private DatabaseHelper helper;
    private SQLiteDatabase database;

    public SenhaDAO(Context context){
        helper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        if (database == null){
            database = helper.getWritableDatabase();
        }

        return database;
    }

    public void close(){
        helper.close();
    }

    public long cadastrarLogin(Login login){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Login.USUARIO, login.getUsuario());
        values.put(DatabaseHelper.Login.SENHA, login.getSenha());

        return getDatabase().insert(DatabaseHelper.Login.TABELA, null, values);
    }

    public Login procurarLogin(String usuario, Integer senha){
        String where_clause = DatabaseHelper.Login.USUARIO + "=? " +
                "AND " + DatabaseHelper.Login.SENHA + "=?";
        String[] where_args = new String[]{usuario,senha.toString()};

        Cursor cursor = getDatabase().query(DatabaseHelper.Login.TABELA,
                DatabaseHelper.Login.COLUNAS, where_clause, where_args, null, null, null,null);
        if(cursor.moveToNext()){
            Login login = criarLogin(cursor);
            cursor.close();
            return login;
        }

        return null;
    }

    public long cadastrarSenha(Senha senha){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Senha.APP, senha.getApp());
        values.put(DatabaseHelper.Senha.LOGIN, senha.getLogin());
        values.put(DatabaseHelper.Senha.PASSWORD, senha.getPassword());
        values.put(DatabaseHelper.Senha.LOGIN_ID,senha.getLoginId());

        return getDatabase().insert(DatabaseHelper.Senha.TABELA, null, values);
    }

    public Senha procurarSenhaPorId(Integer id){
        Cursor cursor = getDatabase().query(DatabaseHelper.Senha.TABELA,
                DatabaseHelper.Senha.COLUNAS, DatabaseHelper.Senha._ID + "=?",
                new String[]{id.toString()}, null,null,null);

        if(cursor.moveToNext()){
            Senha senha = criarSenha(cursor);
            cursor.close();

            return senha;
        }
        return null;
    }

    public List<Senha> listarSenhas(Integer id){
        String selection = DatabaseHelper.Senha.LOGIN_ID + "=?";
        String[] selectionArgs = new String[]{id.toString()};

        Cursor cursor = getDatabase().query(DatabaseHelper.Senha.TABELA,
                DatabaseHelper.Senha.COLUNAS, selection,selectionArgs,null,null,null);
        List<Senha> senhas = new ArrayList<Senha>();
        while (cursor.moveToNext()){
            Senha senha = criarSenha(cursor);
            senhas.add(senha);
        }
        cursor.close();
        return senhas;
    }

    public boolean removerSenha(Long id){
        String whereClause = DatabaseHelper.Senha._ID + "= ?";
        String[] whereArgs = new String[]{id.toString()};
        int removidos = getDatabase().delete(DatabaseHelper.Senha.TABELA, whereClause,whereArgs);

        return removidos > 0;
    }

    private Login criarLogin(Cursor cursor){
        Login login = new Login(
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Login._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Login.USUARIO)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Login.SENHA))
        );

        return login;
    }

    private Senha criarSenha(Cursor cursor){
        Senha senha = new Senha(
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Senha._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Senha.APP)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Senha.LOGIN)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Senha.PASSWORD)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Senha.LOGIN_ID))
        );

        return senha;
    }
}
