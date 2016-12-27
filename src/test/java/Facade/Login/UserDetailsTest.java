package Facade.Login;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDetailsTest {

    private static final String EMAIL = "abcd@abcd.com";
    public static final String NAME = "Vivek";
    public static final String PHONE_NUMBER = "980232344";
    public static final String PASSWORD = "password";
    UserDetails userDetails = new UserDetails();

    @Test
    public void testGetEmail() throws Exception {
        userDetails.setEmail(EMAIL);
        assertTrue(userDetails.getEmail().equals(EMAIL));
    }

    @Test
    public void testGetPassword() throws Exception {
        userDetails.setPassword(PASSWORD);
        assertTrue(userDetails.getPassword().equals(PASSWORD));
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        userDetails.setPhoneNumber(PHONE_NUMBER);
        assertTrue(userDetails.getPhoneNumber().equals(PHONE_NUMBER));
    }

    @Test
    public void testGetName() throws Exception {
        userDetails.setName(NAME);
        assertTrue(userDetails.getName().equals(NAME));
    }
}