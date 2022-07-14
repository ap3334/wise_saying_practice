package com.jung.prac;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private int wiseSayingId = 0;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();

    public WiseSaying findById(int id) {

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) return wiseSaying;
        }

        return null;

    }

    public void remove(int id) {

        WiseSaying foundWiseSaying = findById(id);
        wiseSayingList.remove(foundWiseSaying);
    }

    public List<WiseSaying> findAll() {

        return wiseSayingList;

    }

    public void save(WiseSaying wiseSaying) {

        wiseSaying.setId(++wiseSayingId);

        wiseSayingList.add(wiseSaying);

    }

    public List<WiseSaying> findByKeyword(String keyword) {

        List<WiseSaying> foundWiseSayingList = new ArrayList<>();

        for (WiseSaying wiseSaying : wiseSayingList) {

            String content = wiseSaying.getContent();

            if (content.contains(keyword)) {
                foundWiseSayingList.add(wiseSaying);
            }

        }

        return foundWiseSayingList;
    }

    public List<WiseSaying> findByAuthor(String target) {

        List<WiseSaying> foundWiseSayingList = new ArrayList<>();

        for (WiseSaying wiseSaying : wiseSayingList) {

            String author = wiseSaying.getAuthor();

            if (author.equals(target)) {
                foundWiseSayingList.add(wiseSaying);
            }

        }

        return foundWiseSayingList;
    }
}
