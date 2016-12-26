package Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

class LoginController {
    @RestController
    @RequestMapping("/login")
    public class SpringRestController {
        @RequestMapping(value = "/{name}", method = RequestMethod.GET)
        public void hello(@PathVariable String name) {
            System.out.println( "Hello " + name);
        }
    }
}
