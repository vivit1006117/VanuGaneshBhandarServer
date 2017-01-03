package Facade.Login;

import Facade.Registration.UserDetails;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDetailsTest {

    private static final String EMAIL = "abcd@abcd.com";
    private static final String NAME = "Vivek";
    private static final String PHONE_NUMBER = "980232344";
    private static final String PASSWORD = "password";
    private final UserDetails userDetails = new UserDetails();

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