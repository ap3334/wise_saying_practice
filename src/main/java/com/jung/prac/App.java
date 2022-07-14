package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    private WiseSayingController wiseSayingController = new WiseSayingController();

    public void run() {

        System.out.println("==Wise Saying Terminal==");


        outer:
        while (true) {
            System.out.printf("명령) ");

            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);
            String path = rq.getPath();

            switch (path) {

                case "등록":

                    wiseSayingController.register();

                    break;

                case "목록":

                    wiseSayingController.printList();

                    break;

                case "삭제":

                    wiseSayingController.delete(rq);

                    break;

                case "수정":

                    wiseSayingController.modify(rq);

                    break;

                case "종료":
                    break outer;

            }


        }


    }
}
