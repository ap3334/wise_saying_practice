package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc = new Scanner(System.in);
    private int wiseSayingId = 0;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();

    public void run() {

        System.out.println("==Wise Saying Terminal==");


        outer:
        while (true) {
            System.out.printf("명령) ");

            String cmd = sc.nextLine().trim();

            switch (cmd) {

                case "등록":

                    wiseSayingId = register();

                    break;

                case "목록":

                    printList();

                    break;

                case "삭제":

//                    deleteById(id);

                    break;

                case "종료":
                    break outer;

            }


        }


    }

    public void printList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying temp = wiseSayingList.get(i);

            System.out.printf("%d / %s / %s\n", i + 1, temp.getAuthor(), temp.getContent());
        }

    }

    public int register() {

        System.out.printf("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingList.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", ++wiseSayingId);
        return wiseSayingId;

    }
}
