package com.company;

public class Email {
    String[] remetente = new String[10];

    public Email(String[] remetente) {
        this.remetente = remetente;
    }

    public Email(String destinatario,String assunto,String corpo){

    }
    public Email(String remetente,String destinatario,String assunto,String corpo){

    }

    public String[] getRemetente() {
        return remetente;
    }

    public void setRemetente(String[] remetente) {
        this.remetente = remetente;
    }
}
