package com.company;

import java.util.Arrays;

public class CaixaPostal {
    String nomeDono;
    Email[] caixaDeSaida ;
    Email[] caixaDeEntrada;
    int totEmailEntrada;
    int totEmailSaida;

    public CaixaPostal() {
    }

    public CaixaPostal(String nomeDono, int caixaDeSaida, int caixaDeEntrada) {
        this.nomeDono = nomeDono;
        this.caixaDeSaida = new Email[caixaDeSaida];
        this.caixaDeEntrada = new Email[caixaDeEntrada];
    }

    //region Getter and Setter
    public int getTotEmailEntrada() {
        return totEmailEntrada;
    }

    public void setTotEmailEntrada(int totEmailEntrada) {
        this.totEmailEntrada = totEmailEntrada;
    }

    public int getTotEmailSaida() {
        return totEmailSaida;
    }

    public void setTotEmailSaida(int totEmailSaida) {
        this.totEmailSaida = totEmailSaida;
    }



    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public Email[] getCaixaDeSaida() {
        return caixaDeSaida;
    }

    public void setCaixaDeSaida(Email[] caixaDeSaida) {
        this.caixaDeSaida = caixaDeSaida;
    }

    public Email[] getCaixaDeEntrada() {
        return caixaDeEntrada;
    }

    public void setCaixaDeEntrada(Email[] caixaDeEntrada) {
        this.caixaDeEntrada = caixaDeEntrada;
    }
    //endregion

    public boolean send(Email email){
        if(true){
            return true;
        }else {
            return false;
        }
    }

    public boolean receive(Email email){
        if(true){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "CaixaPostal{" +
                "nomeDono='" + nomeDono + '\'' +
                ", caixaDeSaida=" + Arrays.toString(caixaDeSaida) +
                ", caixaDeEntrada=" + Arrays.toString(caixaDeEntrada) +
                ", totEmailEntrada=" + totEmailEntrada +
                ", totEmailSaida=" + totEmailSaida +
                '}';
    }
}
