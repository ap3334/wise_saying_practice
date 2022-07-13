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



}