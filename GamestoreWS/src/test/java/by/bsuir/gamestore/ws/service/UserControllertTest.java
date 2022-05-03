package by.bsuir.gamestore.ws.service;

import by.bsuir.gamestore.ws.controller.UserController;
import by.bsuir.gamestore.ws.entity.*;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllertTest {

    UserController userController;
    UserService userServiceMock;
    OrderService orderServiceMock;

    @BeforeEach
    void setUp() {

        userServiceMock = Mockito.mock(UserService.class);
        orderServiceMock = Mockito.mock(OrderService.class);
        userController = new UserController(userServiceMock, orderServiceMock);
    }

    @Test
    void TestUserController_Authorization() throws ServiceException {
        // Arrange
        User user = new User();
        Mockito.when(userServiceMock.authorization(user)).thenReturn(user);

        // Act
        ResponseEntity<User> result = userController.authorization(user);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void TestUserController_Registration() throws ServiceException {
        // Arrange
        User user = new User();
        Mockito.when(userServiceMock.registration(user)).thenReturn(true);

        // Act
        ResponseEntity<User> result = userController.registration(user);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void TestUserController_GetOrders() throws ServiceException {
        // Arrange
        User user = new User();
        List list = new ArrayList();
        list.add(new Order());
        Mockito.when(userServiceMock.find(1)).thenReturn(user);
        Mockito.when(orderServiceMock.findAllFromUser(user)).thenReturn(list);

        // Act
        ResponseEntity<List> result = userController.getOrders(1);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void TestUserController_SetRole() throws ServiceException {
        // Arrange
        User user = new User();
        user.setUserRole(1);
        Mockito.when(userServiceMock.find(1)).thenReturn(user);

        user.setId(2);
        Mockito.when(userServiceMock.find(2)).thenReturn(user);

        // Act
        ResponseEntity<User> result = userController.setRole(1, 2);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
