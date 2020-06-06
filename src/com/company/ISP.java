package com.company;

public class ISP {

    Servidor[] servidores;
    int totServidores;

    public ISP(int servers) {
        this.servidores = new Servidor[servers];
    }



    public void sendRecive(){

    }

    public Servidor[] getServidores() {
        return servidores;
    }

    public void setServidores(Servidor[] servidores) {
        this.servidores = servidores;
    }

    public String showAll(){
        return null;
    }

    public boolean inserirServidor(Servidor server){
        return false;
    }

    public boolean removerServidor(String server){
        return false;
    }

    public Servidor getServidor(String nomeServidor){
        return this.servidores[0];
    }
}
