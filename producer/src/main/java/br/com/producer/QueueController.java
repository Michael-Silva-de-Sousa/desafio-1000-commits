package br.com.producer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queue")
@AllArgsConstructor
public class QueueController {

    private final QueueSender queueSender;

    @GetMapping
    public String send(){
        queueSender.send("test message");
        return "ok. done";
    }
}
