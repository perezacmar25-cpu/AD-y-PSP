package com.salesianos.dam._1_ejemplospring;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {


        @GetMapping
        public Greeting hello(@RequestParam(defaultValue= "world") String name) {
            return new Greeting("Hello",name);
        }

        record Greeting (String greeting, String name){

        }
}
