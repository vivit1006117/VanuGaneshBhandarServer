package Controllers;

import Tables.BaseTable;
import Tables.UserDetails;
import Mapper.RegistrationRequestMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @RequestMapping(value = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody RegistrationRequestMapper request) {
        try {
            UserDetails userDetails = new UserDetails(request.getEmail(), request.getPhoneNumber(), request.getPassword(), request.getName());
            userDetails.addToTable();
            System.out.println("Success");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
