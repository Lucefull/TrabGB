package com.company;

import java.util.Arrays;

public class Email {
    String remetente;
    String[] destinatario;
    String corpo;
    String assunto;

    public String getRemetente() {
        return remetente;
    }

    public String[] getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String[] destinatario) {
        this.destinatario = destinatario;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public Email(){
    }

    public Email(String[] destinatario,String assunto,String corpo){
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
    }
    public Email(String remetente,String[] destinatario,String assunto,String corpo){
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
        this.remetente = remetente;
    }

    @Override
    public String toString() {
        //(remetente/assunto/corpo (e anexo, se for o caso)
        return remetente+"|"+assunto+"|"+corpo;
    }
}
