package apache.kafka.com.orderservice.controller;

import apache.kafka.com.domain.dto.Order;
import apache.kafka.com.domain.dto.OrderEvent;
import apache.kafka.com.orderservice.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = new OrderEvent();

        event.setOrder(order);
        event.setMessage("Paid");
        event.setStatus("Good");

        orderProducer.send(event);

        return "Success";
    }

}
