package org.tswicolly.jogo.game;

import org.tswicolly.jogo.test.TestAtack;

import java.util.Scanner;

public class GameLoop {
    int option;
    Scanner scanner = new Scanner(System.in);
    public GameLoop() {
        this.option = -1;
    }

    public void start(){

        while (option != 0) {
            menu();
        }
    }

    public void menu(){
        System.out.println("0 sair");
        System.out.println("1 teste batalha");
        System.out.println("2 teste inventario");

        option = scanner.nextInt();

        if(option == 1){
            System.out.println("Batalha");
            TestAtack test = new TestAtack();
            test.testAtack();

            menu();
        }
        if(option == 2){
            System.out.println("Inventario");

            menu();
        }
    }

}
