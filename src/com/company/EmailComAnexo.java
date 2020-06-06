package com.company;

public class EmailComAnexo extends Email{
    String anexo;

    public EmailComAnexo(String anexo) {
        this.anexo = anexo;
    }

    public EmailComAnexo(String[] destinatario, String assunto, String corpo, String anexo) {
        super(destinatario, assunto, corpo);
        this.anexo = anexo;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

}
