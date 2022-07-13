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

            Rq rq = new Rq(cmd);
            String path = rq.getPath();

            switch (path) {

                case "등록":

                    wiseSayingId = register();

                    break;

                case "목록":

                    printList();

                    break;

                case "삭제":

                    delete(rq);

                    break;

                case "종료":
                    break outer;

            }


        }


    }

    public void deleteById(Rq rq) {


        int id = Integer.parseInt((rq.getQueryParam("id", "0")));

        if (id == 0) {
            System.out.println("id를 입력해주세요");
        }

        WiseSaying foundWiseSaying = findById(id);

        if (foundWiseSaying == null) {
            System.out.println("존재하지 않는 id입니다.");
        }
        else {
            wiseSayingList.remove(foundWiseSaying);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", foundWiseSaying.getId());
        }


    }

    public WiseSaying findById(int id) {

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) return wiseSaying;
        }

        return null;

    }

    public void printList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying temp = wiseSayingList.get(i);

            System.out.printf("%d / %s / %s\n", temp.getId(), temp.getAuthor(), temp.getContent());
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
        wiseSaying.setId(++wiseSayingId);

        wiseSayingList.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
        return wiseSayingId;

    }
}
