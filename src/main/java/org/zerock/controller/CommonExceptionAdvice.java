package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dw on 2016. 2. 8..
 */
@ControllerAdvice
public class CommonExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(CommonExceptionAdvice.class);

//    @ExceptionHandler(Exception.class)
    public String common(Exception e) {
        log.info(e.toString());

        return "error_common";
    }

    @ExceptionHandler(Exception.class)
    private ModelAndView errorModelAndView(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error_common");
        modelAndView.addObject("exception", ex);

        return modelAndView;
    }
}
