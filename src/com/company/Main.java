package com.company;

public class Main {

    public static void main(String[] args) {
        Teclado scan = new Teclado();
        ISP isp = new ISP(10);//suporta ate 10 servers
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
                new String[]{"Eduardo@kmail.com","luis@oi.com"},
                "Preciso de ferias",
                "Agora!");
        cpCarlos.send(em);
        cpEduardo.send(new Email(new String[]{"carlos@kmail.com"},"Pergunta","oi, tudo bem?"));
        isp.getServidor("oi.com").getCx("luis").send(new EmailComAnexo(new String[]{"carlos@kmail.com"},
                "Projeto",
                "Alo!",
                "Este é o anexo!"));
        isp.sendRecive();

        System.out.println(cpCarlos.showInbox());
        System.out.println(isp.showAll());

        System.out.println("\n\nConcluido com sucesso!");


        int op = 1;
        while (op >0){
            System.out.println("###################################" +
                    "         \n### 1 ## Entrar Email           ###" +
                    "         \n### 2 ## Novo Servidor          ###" +
                    "         \n### 3 ## Mostrar Servidores     ###" +
                    "         \n### 4 ## Iniciar Testes         ###" +
                    "         \n### 0 ## Sair                   ###" +
                    "         \n###################################");
            op =scan.leInt("Escolha uma opção: ");
            switch (op) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    System.out.println(isp.showAll());
                    break;
                case 4:

                    break;
                case 0:
                    System.out.println("Volte sempre!");
                    break;
            }
            }       
        }





}

