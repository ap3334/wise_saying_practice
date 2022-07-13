package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void run() {

        Scanner sc = new Scanner(System.in);
        int wiseSayingId = 0;
        List<WiseSaying> wiseSayingList = new ArrayList<>();

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

                    WiseSaying wiseSaying = new WiseSaying();
                    wiseSaying.setContent(content);
                    wiseSaying.setAuthor(author);

                    wiseSayingList.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", ++wiseSayingId);

                    break;

                case "목록":

                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-------------------------");

                    for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                        WiseSaying temp = wiseSayingList.get(i);

                        System.out.printf("%d / %s / %s\n", i + 1, temp.getAuthor(), temp.getContent());
                    }

                    break;

                case "종료":
                    break outer;

            }


        }


    }
}
