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
        }

    }
}
