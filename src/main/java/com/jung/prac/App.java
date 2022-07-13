package com.jung.prac;

import java.util.Scanner;

public class App {
    public static void run() {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("==Wise Saying Terminal==");

        outer:
        while (true) {
            System.out.printf("명령) ");

            String cmd = sc.nextLine().trim();

            switch (cmd) {



                case "종료":
                    break outer;

            }


        }


    }
}
