package Controllers;

import Facade.Registration.Register;
import Facade.Registration.UserDetails;
import Mapper.MappingRegisteration;
import Mapper.RegistrationRequestMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @RequestMapping(value = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody String request) {
        try {
            System.out.println(request);

            RegistrationRequestMapper mappedRequest = MappingRegisteration.mapRequest(request);
            System.out.println("phoneNumber" + mappedRequest.getPhoneNumber());
            System.out.println(mappedRequest.getPassword());
            System.out.println(mappedRequest.getName());
            System.out.println(mappedRequest.getEmail());

            UserDetails userDetails = new UserDetails(mappedRequest.getEmail(), mappedRequest.getPhoneNumber(), mappedRequest.getPassword(), mappedRequest.getName());
            Register register = new Register();
            register.registerUsersData(userDetails);
            System.out.println("Success");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
