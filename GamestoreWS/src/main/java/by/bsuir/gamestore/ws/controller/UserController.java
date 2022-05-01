package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.User;
import by.bsuir.gamestore.ws.service.OrderService;
import by.bsuir.gamestore.ws.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User, Integer> {

    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, OrderService orderService) {
        super(userService, LogManager.getLogger());
        this.orderService = orderService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> authorization(@RequestBody User unknownUser) {
        User user = ((UserService) getService()).authorization(unknownUser);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> registration(@RequestBody User user) {
        if (((UserService) getService()).registration(user)) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value="/get/orders/{userId}", method=RequestMethod.POST)
    public ResponseEntity<List> getOrders(@PathVariable("userId") int userId){
        User user = getService().find(userId);
        if(user != null){
            return new ResponseEntity<>(orderService.findAllFromUser(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value="set/role/{role}", method = RequestMethod.POST)
    public ResponseEntity<User> setRole(@PathVariable("role") int role, @RequestParam("userId") int userId){
        User user = getService().find(userId);
        if(user != null){
            user.setUserRole(role);
            return new ResponseEntity<>(getService().update(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}