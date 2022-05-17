package za.co.momagano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.momagano.model.Service;
import za.co.momagano.service.ServiceRegistrationService;

@RestController
public class ServiceRegistration {

    private ServiceRegistrationService serviceRegistrationService;

    public ServiceRegistration(ServiceRegistrationService serviceRegistrationService) {
        this.serviceRegistrationService = serviceRegistrationService;
    }

    @PostMapping("/profile/{profileId}/service")
    ResponseEntity addService(@PathVariable("profileId") String profileId, @RequestBody Service service){
        serviceRegistrationService.addService(service);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
