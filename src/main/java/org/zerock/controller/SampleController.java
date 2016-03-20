package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dw on 2016. 3. 20..
 */
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    @RequestMapping(value = "/hello")
    public String sayHello() {
        return "hello World2";
    }

    @RequestMapping(value = "/sendVo")
    public SampleVo sendVo() {
        SampleVo vo = new SampleVo();
        vo.setFirstName("길동");
        vo.setLastName("홍");
        vo.setMno(123);

        return vo;
    }

    @RequestMapping(value = "/sendList")
    public List<SampleVo> sendList() {

        List<SampleVo> list = new ArrayList<>();

        for (int i=0; i < 10; i++) {
            SampleVo vo = new SampleVo();
            vo.setFirstName("길동");
            vo.setLastName("홍");
            vo.setMno(i);
            list.add(vo);
        }
        return list;
    }

    @RequestMapping(value = "/sendMap")
    public Map<Integer, SampleVo> sendMap() {
        Map<Integer, SampleVo> map = new HashMap<>();

        for (int i=0; i < 10; i++) {
            SampleVo vo = new SampleVo();
            vo.setFirstName("길동");
            vo.setLastName("홍");
            vo.setMno(i);
            map.put(i, vo);
        }

        return map;
    }

    @RequestMapping(value = "/sendErrorAuth")
    public ResponseEntity<Void> sendListAuto() {
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
}
