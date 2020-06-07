package com.company;

public class ISP {

    Servidor[] servidores;
    int totServidores =0 ;

    public ISP(int servers) {
        this.servidores = new Servidor[servers];
    }



    public void sendRecive(){
        for(int s=0;s<servidores.length;s++){//busca os servidores
            if(servidores[s]!=null){
                for(int c=0;c<servidores[s].caixasPostais.length;c++){//busca as caixas postais
                    if(servidores[s].caixasPostais[c]!=null){
                        for(int i = 0;i<servidores[s].caixasPostais[c].caixaDeSaida.length;i++){//busca as caixas de saidas
                            if (servidores[s].caixasPostais[c].caixaDeSaida[i]!=null){
                                Email e = servidores[s].caixasPostais[c].caixaDeSaida[i];
                                for(int d =0;d<e.destinatario.length;d++){
                                    String[] dests = e.destinatario[d].split("@");
                                    String serv = dests[1];
                                    String user = dests[0];
                                    if(getServidor(serv).nomeServidor =="sys"){
                                        //erro servidor não encontrado
                                        servidores[0].caixasPostais[0].send(new Email(
                                                new String[]{servidores[s].caixasPostais[c].nomeDono+"@"+servidores[s].nomeServidor},
                                                "Erro ao enviar",
                                                "Servidor: "+serv+",não encontrado!"
                                        ));
                                    }else {
                                        if(getServidor(serv).getCx(user) == null){
                                            //erro usuario não encontrado
                                            servidores[0].caixasPostais[0].send(new Email(
                                                    new String[]{servidores[s].caixasPostais[c].nomeDono+"@"+servidores[s].nomeServidor},
                                                    "Erro ao enviar",
                                                    "Destinatario: "+user+",não encontrado!"
                                            ));
                                        }else {
                                            getServidor(serv).getCx(user).receive(e);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /*
    * for (int s =0 ;s<servidores.length;s++){
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
    *
    *
    *
    *
    * */

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
        boolean saida = false;
        for(int i =0;i<servidores.length;i++){
            if(servidores[i]!=null){
                if(servidores[i].nomeServidor.equalsIgnoreCase(server)){
                    servidores[i] = null;
                    saida = true;
                }
            }
        }
        return saida;
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
