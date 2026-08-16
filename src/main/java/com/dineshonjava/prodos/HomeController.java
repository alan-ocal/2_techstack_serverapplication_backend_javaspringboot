package com.dineshonjava.prodos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Serb Ocal
 * @RestController the annotation indicates that this class is a controller and its home () request handler method.
 * @GetMapping shorthand annotation for @RequestMapping(method = RequestMethod.GET)
 * home() returns a string "Hello, Spring Boot!" when the root URL is accessed.
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello, Spring Boot!";
    }
}
