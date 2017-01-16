package Facade.Login;

import Facade.Registration.UserDetails;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDetailsTest {

    private static final String EMAIL = "abcd@abcd.com";
    private static final String NAME = "Vivek";
    private static final String PHONE_NUMBER = "980232344";
    private static final String PASSWORD = "password";
    private final UserDetails userDetails = new UserDetails(EMAIL, PHONE_NUMBER, PASSWORD, NAME);

    @Test
    public void testGetEmail() throws Exception {
        assertTrue(userDetails.getEmail().equals(EMAIL));
    }

    @Test
    public void testGetPassword() throws Exception {
        assertTrue(userDetails.getPassword().equals(PASSWORD));
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        assertTrue(userDetails.getPhoneNumber().equals(PHONE_NUMBER));
    }

    @Test
    public void testGetName() throws Exception {
        assertTrue(userDetails.getName().equals(NAME));
    }
}