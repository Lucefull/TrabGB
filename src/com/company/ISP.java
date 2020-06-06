package com.company;

public class ISP {

    Servidor[] servidores;
    int totServidores =0 ;

    public ISP(int servers) {
        this.servidores = new Servidor[servers];
    }



    public void sendRecive(){
        for (int s =0 ;s<servidores.length;s++){
            if(servidores[s]!=null){
            for (int c =0;c<servidores[s].caixasPostais.length;c++){
                if(servidores[s].caixasPostais[c]!=null){
                for(int i =0;i<servidores[s].caixasPostais[c].caixaDeSaida.length;i++) {
                    if (servidores[s].caixasPostais[c].caixaDeSaida[i] != null) {
                        String[] dest = servidores[s].caixasPostais[c].caixaDeSaida[i].destinatario;
                        if (dest != null) {
                            for (int d = 0; d < dest.length; d++) {
                                entregar(servidores[s].caixasPostais[c].caixaDeSaida[i],
                                        dest[d]);
                            }
                        }
                    }
                }
                }
            }
            }
        }
    }

    public void entregar(Email e,String dest){
        String[] d = dest.split("@");
        String nome = d[0];
        String serv = d[1];
        for (int s =0 ;s<servidores.length;s++){
            if(servidores[s].nomeServidor.equalsIgnoreCase(serv)){
                for (int i = 0;i<servidores[s].caixasPostais.length;i++){
                    if (servidores[s].caixasPostais[i].nomeDono.equalsIgnoreCase(nome)){
                        servidores[s].caixasPostais[i].receive(e);
                    }

                }
            }
        }
    }

    public Servidor[] getServidores() {
        return servidores;
    }

    public void setServidores(Servidor[] servidores) {
        this.servidores = servidores;
    }

    public String showAll(){
        String saida= new String();
        for (int i =0;i<servidores.length;i++){
            if(servidores[i]!=null){
                saida = saida+servidores[i].nomeServidor+"\n";
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
