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
}
