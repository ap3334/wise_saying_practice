package com.jung.prac;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        int id = Integer.parseInt(rq.getQueryParam("id", "0"));

        assertEquals(1, id);

        Map<String, String> queryParam = rq.getQueryParam();

        assertEquals("삭제", rq.getPath());
        assertEquals(true, rq.getQueryParam().containsKey("id"));
        assertEquals("1", rq.getQueryParam().get("id"));
    }

    @Test
    public void 쿼리가_없는_쿼리문_테스트() {

        Rq rq = new Rq("삭제?");

        int id = Integer.parseInt(rq.getQueryParam("id", "0"));

        assertEquals(0, id);

        Map<String, String> queryParam = rq.getQueryParam();

        assertEquals("삭제", rq.getPath());
        assertEquals(new HashMap<>(), rq.getQueryParam());
    }

    @Test
    public void 쿼리가_여러개인_쿼리문_테스트() {

        Rq rq = new Rq("삭제?id=3&name=park&age=26");

        int id = Integer.parseInt(rq.getQueryParam("id", "0"));

        assertEquals(3, id);

        Map<String, String> queryParam = rq.getQueryParam();

        assertEquals("삭제", rq.getPath());
        assertEquals(true, rq.getQueryParam().containsKey("id"));
        assertEquals(true, rq.getQueryParam().containsKey("name"));
        assertEquals(true, rq.getQueryParam().containsKey("age"));

        assertEquals("3", rq.getQueryParam().get("id"));
        assertEquals("park", rq.getQueryParam().get("name"));
        assertEquals("26", rq.getQueryParam().get("age"));


    }

}