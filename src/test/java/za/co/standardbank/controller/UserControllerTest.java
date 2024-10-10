/*
package za.co.standardbank.controller;

import za.co.standardbank.model.User;
import za.co.standardbank.service.user.UserService;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    public UserController userController;
    public UserService userService;

    @BeforeEach
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        userController = new UserController();
        userController.userService = userService; // Injecting the mock
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "Alice", "alice@example.com"));
        users.add(new User("2", "Bob", "bob@example.com"));

        when(userService.findAllUser()).thenReturn(users);

        List<User> result = userController.getAllUsers();
        assertEquals(2, result.size());
        verify(userService).findAllUser();
    }

    @Test
    public void testGetUserById() {
        User user = new User("1", "Alice", "alice@example.com");
        when(userService.findById("1")).thenReturn(user);

        User result = userController.getUserById("1");
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userService).findById("1");
    }

    @Test
    public void testCreateUser() {
        User user = new User(null, "Alice", "alice@example.com");

        Response response = userController.createUser(user);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        verify(userService).createUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(null, "Alice", "alice@example.com");
        user.setId("1");

        Response response = userController.updateUser("1", user);
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
        verify(userService).updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        Response response = userController.deleteUser("1");
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
        verify(userService).deleteUser("1");
    }
}
*/
