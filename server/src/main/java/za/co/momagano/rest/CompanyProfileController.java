package za.co.momagano.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyProfileController {
    private CompanyProfileService companyProfileService;

    public CompanyProfileController(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @PostMapping("/profile")
    ResponseEntity createProfile(@RequestBody CompanyProfile profile){
        CompanyProfile registeredProfile = companyProfileService.addProfile(profile);
        return new ResponseEntity(1l, HttpStatus.CREATED);
    }
}
