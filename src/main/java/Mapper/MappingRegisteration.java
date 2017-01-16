package Mapper;

import java.util.ArrayList;

public class MappingRegisteration {

    public static RegistrationRequestMapper mapRequest(String request) {
        String[] parameters = request.split(",");

        RegistrationRequestMapper mappedRequest = new RegistrationRequestMapper(parameters);

        return mappedRequest;
    }
}
