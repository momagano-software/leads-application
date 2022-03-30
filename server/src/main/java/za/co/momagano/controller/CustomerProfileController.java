package za.co.momagano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.momagano.model.CustomerProfile;
import za.co.momagano.service.CustomerProfileService;

@RestController
@RequestMapping("/customer")
public class CustomerProfileController {

    private CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @PostMapping("/profile")
    public ResponseEntity addCustomerProfile(@RequestBody CustomerProfile customerProfile) {
        customerProfileService.addProfile(customerProfile);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/profile")
    public ResponseEntity<CustomerProfile> getCustomerProfileByEmail(@RequestParam String customerEmail) {
        return ResponseEntity.ok(customerProfileService.getProfile(customerEmail));
    }
}
