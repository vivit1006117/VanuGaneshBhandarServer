package Controllers;

import Tables.UserDetails;
import Mapper.RegistrationRequestMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @RequestMapping(value = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody RegistrationRequestMapper request) throws Exception {
            UserDetails userDetails = new UserDetails(request.getEmail(), request.getPhoneNumber(), request.getPassword(), request.getName());
            return userDetails.addToTable();
    }
}
