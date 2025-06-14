package telran.user.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import telran.user.model.User;

class UserTest {
    User user;
    String email = "peter@gmail.com";
    String password = "123456Ab!";

    @BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testCorrectEmail() {
        user.setEmail("peter@yahoo.com");
        assertEquals("peter@yahoo.com", user.getEmail());
    }

    @Test
    void testWithoutAt(){
        user.setEmail("peter.yahoo.com");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testManyAt(){
        user.setEmail("peter@ya@hoo.com");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testDotAfterAt(){
        user.setEmail("peter@yahoocom");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testLastDot(){
        user.setEmail("peter@yahooc.");
        assertEquals(email, user.getEmail());
        user.setEmail("peter@yahooco.m");
        assertEquals(email, user.getEmail());
    }
    @Test
    void testIncorrectSymbol(){
        user.setEmail("pet!er@yahoo.com");
        assertEquals(email, user.getEmail());
    }

    //If email correct it must be changed
    @Test
    void testCorrectSymbol(){
        user.setEmail("jac-_.k@yahoo.home.com");
        assertNotEquals(email, user.getEmail());
    }

    //Test password
    @Test
    void testCorrectPassword() {
        user.setPassword("654321kI@");
        assertEquals(user.getPassword(), "654321kI@");
    }

    @Test
    void testPasswordLength() {
        user.setPassword("6543uI!");
        assertEquals(user.getPassword(), password);
    }

    @Test
    void testMinOneDigit() {
        user.setPassword("uioiuHuI!");
        assertEquals(user.getPassword(), password);
    }

    @Test
    void testPasswordSpecSymbols() {
        user.setPassword("6543uI_w");
        assertEquals(user.getPassword(), password);
        user.setPassword("6543uIuw");
        assertEquals(user.getPassword(), password);
    }

    @Test
    void testLowerCase() {
        user.setPassword("6543!u_w");
        assertEquals(user.getPassword(), password);
    }

    @Test
    void testUpperCase() {
        user.setPassword("6543!U_U");
        assertEquals(user.getPassword(), password);
    }
}