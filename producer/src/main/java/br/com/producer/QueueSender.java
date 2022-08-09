package br.com.producer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueueSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void send(String order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}
