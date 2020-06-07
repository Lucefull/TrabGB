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

    public Email[] getCaixaDeSaida() {
        return caixaDeSaida;
    }

    public Email[] getCaixaDeEntrada() {
        return caixaDeEntrada;
    }

    //endregion

    public boolean send(Email email){
        try{
            caixaDeSaida[totEmailSaida] = email;
            totEmailSaida++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean receive(Email email){
        try{
            caixaDeEntrada[totEmailEntrada] = email;
            totEmailEntrada++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public String showInbox(){
        String saida = new String();
        for (int i=0;i<caixaDeEntrada.length;i++){
            if(caixaDeEntrada[i] !=null){
                saida = caixaDeEntrada[i].toString();
            }
        }
        return saida;
    }

    public String showOutBox(){
        String saida = new String();
        for (int i=0;i<caixaDeSaida.length;i++){
            if(caixaDeSaida[i] !=null){
                saida = caixaDeSaida[i].toString();
            }
        }
        return saida;
    }
    public void clearInbox(){
        for(int i =0;i<caixaDeEntrada.length;i++){
            caixaDeEntrada[i] = null;
        }
    }
}
