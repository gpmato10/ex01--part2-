package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.ReplyVo;
import org.zerock.service.ReplyService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dw on 2016. 4. 20..
 */
@RestController
@RequestMapping("/replies")
public class ReplyController {

    @Inject
    private ReplyService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody ReplyVo vo) {
        ResponseEntity<String> entity = null;
        try {
            service.addReply(vo);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
    public ResponseEntity<List<ReplyVo>> list(@PathVariable("bno") Integer bno) {
        ResponseEntity<List<ReplyVo>> entity = null;

        try {
            entity = new ResponseEntity<List<ReplyVo>>(service.listReply(bno), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<List<ReplyVo>>(HttpStatus.OK);
        }

        return entity;
    }

    @RequestMapping(value = "/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH} )
    public ResponseEntity<String> update(@PathVariable("rno") Integer rno,
                                         @RequestBody ReplyVo vo) {

        ResponseEntity<String> entity = null;

        try {
            vo.setRno(rno);
            service.modifyReply(vo);

            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
