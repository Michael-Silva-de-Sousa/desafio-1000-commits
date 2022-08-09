package br.com.producer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class QueueController {

    private final QueueSender queueSender;
    private final AmqpTemplate queueSenderExchange;

    @GetMapping("/queue")
    public String send(){
        queueSender.send("test message");
        return "ok. done";
    }

    @GetMapping("/exchange")
    public String sendExchange(){
        queueSenderExchange.convertAndSend("exchange-pegasus", "key-pegasus", "Meteoro de Pegasus!!!");
        return "ok. done";
    }
}
