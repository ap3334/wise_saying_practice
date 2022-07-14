package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    private Scanner sc = new Scanner(System.in);


    public void modify(Rq rq) {

        int id = Integer.parseInt((rq.getQueryParam("id", "0")));

        if (id == 0) {
            System.out.println("id를 입력해주세요");
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(id);

        if (foundWiseSaying == null) {
            System.out.println("존재하지 않는 id입니다.");
        }
        else {
            WiseSaying wiseSaying = new WiseSaying();

            System.out.printf("명언(기존) : %s\n", foundWiseSaying.getContent());
            System.out.printf("명언 : ");

            String newContent = sc.nextLine();


            System.out.printf("작가(기존) : %s\n", foundWiseSaying.getAuthor());
            System.out.printf("작가 : ");

            String newAuthor = sc.nextLine();

            foundWiseSaying.setContent(newContent);
            foundWiseSaying.setAuthor(newAuthor);

            System.out.printf("%d번 명언이 수정되었습니다.\n", foundWiseSaying.getId());
        }

    }

    public void delete(Rq rq) {


        int id = Integer.parseInt((rq.getQueryParam("id", "0")));

        if (id == 0) {
            System.out.println("id를 입력해주세요");
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(id);

        if (foundWiseSaying == null) {
            System.out.println("존재하지 않는 id입니다.");
        }
        else {
            wiseSayingRepository.remove(id);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", foundWiseSaying.getId());
        }


    }



    public void printList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        List<WiseSaying> wiseSayingList = wiseSayingRepository.findAll();

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying temp = wiseSayingList.get(i);

            System.out.printf("%d / %s / %s\n", temp.getId(), temp.getAuthor(), temp.getContent());
        }

    }

    public void register() {

        System.out.printf("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.save(wiseSaying);


        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());

    }

    public void searchById(Rq rq) {

        int id = Integer.parseInt(rq.getQueryParam("id", "0"));

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(id);

        if (foundWiseSaying == null) {
            System.out.println("찾는 번호의 명언은 존재하지 않습니다.");
        }
        else {
            System.out.printf("==%d번 명언==\n", foundWiseSaying.getId());
            System.out.printf("명언 : %s\n", foundWiseSaying.getContent());
            System.out.printf("작가 : %s\n", foundWiseSaying.getAuthor());
        }
    }
}
