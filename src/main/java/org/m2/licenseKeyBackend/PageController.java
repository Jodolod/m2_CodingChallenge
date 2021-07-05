package org.m2.licenseKeyBackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc The controller for the basic frontend providing a way to obtain a new license key or validate an existing on
 */

@Controller
    public class PageController {

        @RequestMapping("/")
        String landingPage (){
            return "landingPage";
        }
}
