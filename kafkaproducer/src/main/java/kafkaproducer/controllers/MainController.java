package kafkaproducer.controllers;

import kafkaproducer.model.Count;
import kafkaproducer.services.Producer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final Producer producer;
    @SneakyThrows
    @PostMapping("/count")
    public String send(Count count){
        return producer.sendMessage(count);
    }
}
