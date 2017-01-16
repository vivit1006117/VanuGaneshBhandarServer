package Controllers;

import Facade.Login.Login;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "/{userId}/{password}", method = RequestMethod.GET)
    public String login(@PathVariable String userId, @PathVariable String password) {
        Login login = new Login();
        login.findUser(userId, password);   //"'96800048'", "password"
        return "Hello " + userId;
    }
}