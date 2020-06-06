package com.company;

public class EmailComAnexo extends Email{
    String anexo;

    public EmailComAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

}
