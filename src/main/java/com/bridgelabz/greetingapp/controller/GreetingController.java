package com.bridgelabz.greetingapp.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class GreetingController {
        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        /*
         *curl localhost:8080/greeting
         @return={id =1 , content="hello world!}
         * localhost:8080/greeting?name=Anant
         * @return= { id=2, content="hello Anant!
         */
        @GetMapping(value={"/greeting","/greeting/","/greeting/home"})
        public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
        /*
        *localhost:8080/greeting/Anant
        @return={id =1 , content="hello Anant!}
         */
        @GetMapping("greeting/{name}")
        public Greeting greetings(@PathVariable String name) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
        @Autowired
        private IGreetingService greetingService;

        /*
           *localhost:8080/greeting/service
           @return={id =1 , content="hello world!}
            */
        @GetMapping("greeting/service")
        public Greeting greeting() {
            return greetingService.greetingMessage();

        }
        @PostMapping("/greeting")
        public String greetingMessage(@RequestBody UserDto userDto) {
            return greetingService.greetingMessageByName(userDto);
        }
        @GetMapping("/find")
        public User findGreetById(@RequestParam long id) {
            return greetingService.getById(id);
        }
        @GetMapping("/allgreetings")
        public List<User> findAllGreeting() {
            return greetingService.getAllGreetingMessages();
        }
        @PutMapping("/editmessage/{id}")
        public User editGreetMesage(@PathVariable long id, @RequestBody UserDto userDto) {
            return greetingService.updateGreetMessage(id, userDto);

        }


    }
