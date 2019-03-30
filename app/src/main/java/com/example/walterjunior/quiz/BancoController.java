package com.example.walterjunior.quiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BancoController {

    public CriaBanco banco;
    public SQLiteDatabase db;

    public BancoController(Context c) {
        banco = new CriaBanco(c);
    }

    // Método de Inserção de Dados
    public void inserePergunta(Pergunta pergunta) {
        db = banco.getWritableDatabase();
        String sql = "INSERT INTO " + CriaBanco.TABELA + " " +
                     "("+ CriaBanco.ENUNCIADO +", "+ CriaBanco.ALT01 +", "+ CriaBanco.ALT02 +", "+ CriaBanco.ALT03 +", "+ CriaBanco.ALT04 +", "+ CriaBanco.ALT05 +", "+ CriaBanco.RCERTA +") " +
                     "values " +
                     "('"+ pergunta.getPergunta() +"', '"+ pergunta.getR1() +"', '"+ pergunta.getR2() +"', '"+ pergunta.getR3() +"', '"+ pergunta.getR4() +"', '"+ pergunta.getR5() +"', '"+ pergunta.getrCerta() +"')";
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<Pergunta> carregaPergunta(int perguntaId){

        db = banco.getReadableDatabase();
        ArrayList<Pergunta> listaPerguntas = new ArrayList<>();
        String sql = "SELECT * FROM " + CriaBanco.TABELA + " WHERE " + CriaBanco.ID + " = " + perguntaId;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(CriaBanco.ID));
            String enunciado = cursor.getString(cursor.getColumnIndex(CriaBanco.ENUNCIADO));
            String r1 = cursor.getString(cursor.getColumnIndex(CriaBanco.ALT01));
            String r2 = cursor.getString(cursor.getColumnIndex(CriaBanco.ALT02));
            String r3 = cursor.getString(cursor.getColumnIndex(CriaBanco.ALT03));
            String r4 = cursor.getString(cursor.getColumnIndex(CriaBanco.ALT04));
            String r5 = cursor.getString(cursor.getColumnIndex(CriaBanco.ALT05));
            String rCerta = cursor.getString(cursor.getColumnIndex(CriaBanco.RCERTA));
            Pergunta p = new Pergunta(id, enunciado, r1, r2, r3, r4, r5, rCerta);
            listaPerguntas.add(p);
        }

        db.close();

        return listaPerguntas;
    }
}
