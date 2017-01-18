package Controllers;

import Facade.Users.Login.Login;
import Mapper.LoginMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody LoginMapper request) {
        Login login = new Login();
        login.findUser(request.getUserId(), request.getPassword());   //"'96800048'", "password"
        return "Hello " + request.getUserId();
    }
}