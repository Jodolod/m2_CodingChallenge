package org.m2.licenseKeyBackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    public class PageController {

        @RequestMapping("/")
        String landingPage (){
            return "landingPage";
        }
}
