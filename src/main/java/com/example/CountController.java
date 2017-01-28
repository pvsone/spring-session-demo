package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class CountController {

    @GetMapping("/count")
    public @ResponseBody String count(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        count = (count == null) ? new Integer(1) : new Integer(count.intValue() + 1);
        session.setAttribute("count", count);

        return "Count: " + count.toString();
    }

}
