package com.jung.prac;

import java.util.Scanner;

public class App {
    public static void run() {

        Scanner sc = new Scanner(System.in);
        int wiseSayingId = 0;

        System.out.println("==Wise Saying Terminal==");


        outer:
        while (true) {
            System.out.printf("명령) ");

            String cmd = sc.nextLine().trim();

            switch (cmd) {

                case "등록":

                    System.out.printf("명언 : ");
                    String content = sc.nextLine();

                    System.out.printf("작가 : ");
                    String author = sc.nextLine();

                    break;

                case "종료":
                    break outer;

            }


        }


    }
}
