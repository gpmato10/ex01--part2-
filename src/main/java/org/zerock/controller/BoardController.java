package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import javax.inject.Inject;

/**
 * Created by dw on 2016. 2. 7..
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Inject
    private BoardService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerGet(BoardVO board, Model model) {
        log.info("register get.........");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registPost(BoardVO board, RedirectAttributes redirectAttributes) throws Exception {
        log.info("regist post .........");
        log.info(board.toString());

        service.regist(board);

        redirectAttributes.addFlashAttribute("msg", "success");
        
        return "redirect:/board/listAll";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public void listAll(Model model) throws Exception {
        log.info("show all list......");
    }
}
