package com.example.walterjunior.quiz;

public class Pergunta {

    private int id;
    private String pergunta;
    private String r1, r2, r3, r4, r5;
    private String rCerta;

    public Pergunta(int id, String pergunta, String r1, String r2, String r3, String r4, String r5, String rCerta) {
        this.id = id;
        this.pergunta = pergunta;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
        this.rCerta = rCerta;
    }

    public Pergunta(String pergunta, String r1, String r2, String r3, String r4, String r5, String rCerta) {
        this.pergunta = pergunta;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
        this.rCerta = rCerta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }

    public String getR5() {
        return r5;
    }

    public void setR5(String r5) {
        this.r5 = r5;
    }

    public String getrCerta() {
        return rCerta;
    }

    public void setrCerta(String rCerta) {
        this.rCerta = rCerta;
    }
}
