package com.company;

public class Servidor {
    String nomeServidor;
    CaixaPostal[] caixasPostais;
    int totCaixasPostais =0;

    public Servidor(String nomeServidor, int caixasPostais) {
        this.nomeServidor = nomeServidor;
        this.caixasPostais = new CaixaPostal[caixasPostais];
    }

    //region Getter & Setter

    public String getNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(String nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public CaixaPostal[] getCaixasPostais() {
        return caixasPostais;
    }

    public void setCaixasPostais(CaixaPostal[] caixasPostais) {
        this.caixasPostais = caixasPostais;
    }

    public int getTotCaixasPostais() {
        return totCaixasPostais;
    }

    public void setTotCaixasPostais(int totCaixasPostais) {
        this.totCaixasPostais = totCaixasPostais;
    }

    //endregion

    public boolean addCpx(CaixaPostal caixaPostal){
        try{
            caixasPostais[totCaixasPostais] = caixaPostal;
            totCaixasPostais++;
            return true;
        }catch (Exception e) {
            return false;
        }

    }

    public CaixaPostal getCx(String nome){
        return caixasPostais[0];
    }

    public String showCxsPostais(){
        return null;
    }
}
