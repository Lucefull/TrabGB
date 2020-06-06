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

                        Email e = servidores[s].caixasPostais[c].caixaDeSaida[i];
                        String[] dest = servidores[s].caixasPostais[c].caixaDeSaida[i].destinatario;
                        for(int d =0;d<dest.length;d++){
                            buscarDestinatario(dest[d],servidores[s].caixasPostais[c].caixaDeSaida[i]);
                        }

                    }
                }
                }
            }
            }
        }
    }

    public void buscarDestinatario(String dest,Email e){
        String[] d = dest.split("@");
        String nome = d[0];
        String ser = d[1];
        boolean ent = false;
        for(int s = 0; s<servidores.length;s++){
            if(servidores[s]!=null){
                if(servidores[s].nomeServidor.equalsIgnoreCase(ser)){
                    for (int c =0 ;c<servidores[s].caixasPostais.length;c++){
                        if(servidores[s].caixasPostais[c] != null){
                            if(servidores[s].caixasPostais[c].nomeDono.equalsIgnoreCase(nome)){
                                servidores[s].caixasPostais[c].receive(e);
                                ent = true;
                            }
                        }
                    }
                }

            }
        }
        if(!ent){
            servidores[0].caixasPostais[0].send(e);
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
