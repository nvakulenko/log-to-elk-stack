package com.lohika.logtoelkstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LoggerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerController.class);


    @GetMapping("/{tenant}/write-to-log")
    public String writeToLog(@PathVariable String tenant) {

        MDC.put("tenant", tenant);

        LOGGER.info("Writing to log of tenant '{}' ...", tenant);
        return "Done!";
    }
}
