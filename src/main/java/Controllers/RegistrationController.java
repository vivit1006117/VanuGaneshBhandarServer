package Controllers;

import Facade.Registration.Register;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegistrationController {
    @RequestMapping(method = RequestMethod.POST)
    public String hello() {
        Register register = new Register();
        register.registerUsersData();
        return "Hello ";
    }
}
