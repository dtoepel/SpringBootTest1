package org.example.springboottest1.controller;

import org.example.springboottest1.model.Message;
import org.example.springboottest1.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private final Vector<Message> messages = new Vector<>();
    public HelloController() {
        messages.add(new Message("1", "msg1", "Erste Message"));
        messages.add(new Message("2", "msg2", "Zweite Message"));
    }

    @GetMapping
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping
    public String printValue(@RequestBody Student student){
        return "Hello " + student.firstName() + " " + student.lastName();
    }

    @GetMapping("/{id}")
    public String printValue(@PathVariable String id){
        return "Hello " + id;
    }

    @GetMapping("/search")
    public String searchValue(@RequestParam String query){
        return "Hello " + query;
    }

    @GetMapping("/messages")
    public String printMessages(){
        String s = "";
        for(Message message : messages){
            s += message.toString() + "\n";
        }
        return s;
    }

    @PostMapping("/messages")
    public String addMessage(@RequestBody Message message){
        messages.add(message);

        String s = "";
        for(Message message2 : messages){
            s += message2.toString() + "\n";
        }
        return s;
    }

    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable String id){
        messages.removeIf(message -> message.id().equals(id));

        String s = "";
        for(Message message2 : messages){
            s += message2.toString() + "\n";
        }
        return s;
    }

}
