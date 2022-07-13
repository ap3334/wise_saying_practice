package com.jung.prac;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void 등록_테스트() {

        List<WiseSaying> wiseSayingList = new ArrayList<>();
        WiseSaying wiseSaying = new WiseSaying();

        wiseSaying.setContent("명언");
        wiseSaying.setAuthor("작가");

        wiseSayingList.add(wiseSaying);

        assertEquals(1, wiseSayingList.size());
        assertEquals("명언", wiseSayingList.get(0).getContent());
        assertEquals("작가", wiseSayingList.get(0).getAuthor());

    }

    @Test
    public void 쿼리문_테스트() {

        Rq rq = new Rq("삭제?id=1");

        int id = rq.getQueryParam("id", 0);

        assertEquals(1, id);

    }

}