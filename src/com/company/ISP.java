package com.company;

public class ISP {

    Servidor[] servidores;
    int totServidores =0 ;

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
        String saida = null;
        for (int i =0;i<servidores.length;i++){
            if(servidores[i]!=null){
                saida = "\n"+servidores[i].nomeServidor;
            }
        }
        return saida;
    }

    public boolean inserirServidor(Servidor server){
        boolean resp = false;

        try {
            int i = totServidores ;
            servidores[i] = server;
            resp = true;
            totServidores++;
        }catch (Exception e){
            resp = false;
        }
        return resp;
    }

    public boolean removerServidor(String server){
        return false;
    }

    public Servidor getServidor(String nomeServidor){
        int pos = 0;
        for (int i =0;i<servidores.length;i++){
            if(servidores[i] != null){
                if(servidores[i].nomeServidor.equalsIgnoreCase(nomeServidor)) {
                    pos = i;
                }
            }
        }
        return servidores[pos];
    }
}
