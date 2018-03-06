package com.base.app;

import com.base.dbworker.DataBaseWorker;

import java.util.Scanner;

public class Application {

    private static final DataBaseWorker WORKER = new DataBaseWorker();

    public static void main(String[] args) {
        while (true) {
            System.out.println( "\n" + "================= Console interface for university =================");
            System.out.println("Commands:" + "\n" + "5.Global search by {template}." + "\n" + "Chose action by number.");
            int key = getScanner().nextInt();
            switch(key) {
                case 5:
                    System.out.print("Enter template: ");
                    System.out.println(WORKER.searchBy(getScanner().nextLine()));
                    break;
//                case 2:
//                    команда;
//                    break;
                default:
                    System.out.print("Exit");
                    System.exit(1);
                    break;
            }

        }
    }

    private static Scanner getScanner(){
        return new Scanner(System.in);
    }
}
