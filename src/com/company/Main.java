package com.company;

public class Main {

    public static void main(String[] args) {
        Teclado scan = new Teclado();
        ISP isp = new ISP(10);//suporta ate 10 servers
        isp.inserirServidor(new Servidor("sys",10));
        isp.getServidor("sys").addCpx(new CaixaPostal("Postman",10,10));

        isp.inserirServidor(new Servidor("kmail.com",20));//suporta até 20 caixas postais
        isp.inserirServidor(new Servidor("tierra.com.br",50));
        isp.inserirServidor(new Servidor("oi.com",15));

        CaixaPostal cpCarlos = new CaixaPostal("carlos",10,10);
        CaixaPostal cpEduardo = new CaixaPostal("eduardo",10,10);
        CaixaPostal cpJonas = new CaixaPostal("jonas",10,10);

        isp.getServidor("kmail.com").addCpx(cpCarlos);
        isp.getServidor("kmail.com").addCpx(cpEduardo);
        isp.getServidor("kmail.com").addCpx(cpJonas);

        isp.getServidor("oi.com").addCpx(new CaixaPostal("luis",20,20));
        isp.getServidor("oi.com").addCpx(new CaixaPostal("marcio",10,10));

        Email em = new Email("carlos",
                new String[]{"eduardo@kmail.com","luis@oi.com"},
                "Preciso de ferias",
                "Agora!");
        cpCarlos.send(em);
        cpEduardo.send(new Email(new String[]{"carlos@kmail.com"},"Pergunta","oi, tudo bem?"));
        isp.getServidor("oi.com").getCx("luis").send(new EmailComAnexo("luis",new String[]{"carlos@kmail.com"},
                "Projeto",
                "Alo!",
                "Este é o anexo!"));

        isp.sendRecive();
        System.out.println(cpCarlos.showInbox());
        System.out.println(cpEduardo.showInbox());
        System.out.println(cpJonas.showInbox());

        System.out.println(cpCarlos.showInbox());
        System.out.println(isp.showAll());

        System.out.println("\n\nConcluido com sucesso!");


        int op = 1;
        while (op >0){
            System.out.println("###################################" +
                    "         \n### 1 ## Mostrar Servidores     ###" +
                    "         \n### 2 ## Novo servidor          ###" +
                    "         \n### 3 ## Remover servidor       ###" +
                    "         \n### 4 ## Entrar Email           ###" +
                    "         \n### 0 ## Sair                   ###" +
                    "         \n###################################");
            op =scan.leInt("Escolha uma opção: ");
            switch (op) {
                case 1:
                    System.out.println(isp.showAll());
                    break;
                case 2:
                     String nome =scan.leString("Digite o nome do servidor: ");
                     int tamanho = scan.leInt("Digite a quantidade de caixas postais: ");
                    isp.inserirServidor(new Servidor(nome,tamanho));
                    break;
                case 3:
                    System.out.println();
                    if(isp.removerServidor(scan.leString("Digite o nome do servidor a ser deletado: "))){
                        System.out.println("Removido com sucesso!");
                    }else {
                        System.out.println("Erro ao remover servidor");
                    }
                    break;
                case 4:
                    System.out.println("Exemplo: nome@servidor");
                    String serv = scan.leString("Digite o servidor:");
                    String email = scan.leString("Digite o nome:");
                    int op2=1;
                    while (op2>0){
                        isp.sendRecive();
                        System.out.println("###################################" +
                                "         \n### 1 ## Abrir inbox            ###" +
                                "         \n### 2 ## Abrir outbox           ###" +
                                "         \n### 3 ## Novo email             ###" +
                                "         \n### 0 ## Sair                   ###" +
                                "         \n###################################");
                        op2 =scan.leInt("Escolha uma opção: ");
                        switch (op2){
                            case 1:
                                System.out.println("Inbox");
                                System.out.println(isp.getServidor(serv).getCx(email).showInbox());
                                break;
                            case 2:
                                System.out.println("Outbox");
                                System.out.println(isp.getServidor(serv).getCx(email).showOutBox());
                                break;
                            case 3:
                                System.out.println("nome@servidor,nome@servidor");
                                String[] dest = scan.leString("Digite o nome dos destinatarios:").split(",");
                                String assunto = scan.leString("Digite o assunto:");
                                String corpo =scan.leString("Digite o corpo:");
                                String anexo = scan.leString("Digite o anexo:");
                                Email e = null;
                                for (int i =0;i<dest.length;i++){
                                    if(anexo!=""){
                                        e = new EmailComAnexo(isp.getServidor(serv).getCx(email).nomeDono,
                                                dest,assunto,corpo,anexo);
                                    }else{
                                        e = new Email(isp.getServidor(serv).getCx(email).nomeDono,
                                                dest,assunto,corpo);
                                    }
                                }
                                isp.getServidor(serv).getCx(email).send(e);
                                break;

                        }
                    }



                    break;
                case 0:
                    System.out.println("Volte sempre!");
                    break;
            }
            }

        }

}

