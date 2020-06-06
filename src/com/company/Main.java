package com.company;

public class Main {

    public static void main(String[] args) {
        Teclado scan = new Teclado();
        int op = 1;
        while (op >0){
            System.out.println("###################################" +
                    "         \n### 1 ## Entrar Email           ###" +
                    "         \n### 2 ## Novo Servidor          ###" +
                    "         \n### 3 ## Mostrar Servidores     ###" +
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
                    break;
                case 0:
                    System.out.println("Volte sempre!");
                    break;
            }
            }
        }

    }

