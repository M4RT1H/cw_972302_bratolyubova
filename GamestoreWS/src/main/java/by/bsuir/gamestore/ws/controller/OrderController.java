package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.Order;
import by.bsuir.gamestore.ws.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends GenericController<Order, Integer> {

    @Autowired
    public OrderController(OrderService orderService){
        super(orderService, LogManager.getLogger());
    }

    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public ResponseEntity<Order> place(@RequestBody Order entity) {
        entity.setOrderKey(java.util.UUID.randomUUID().toString());
        return super.addEntity(entity);
    }
}

