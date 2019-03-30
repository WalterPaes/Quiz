package com.example.walterjunior.quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "quiz";
    public static final String ID = "id";
    public static final String ENUNCIADO = "enunciado";
    public static final String ALT01 = "a1";
    public static final String ALT02 = "a2";
    public static final String ALT03 = "a3";
    public static final String ALT04 = "a4";
    public static final String ALT05 = "a5";
    public static final String RCERTA = "rCerta";
    public static final int VERSAO = 4;

    public CriaBanco(Context context) {
        super(context, TABELA, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "(" + ID + " integer primary key autoincrement, "
                   + ENUNCIADO + " text, "
                   + ALT01 + " text, "
                   + ALT02 + " text, "
                   + ALT03 + " text, "
                   + ALT04 + " text, "
                   + ALT05 + " text, "
                   + RCERTA + " text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }
}
