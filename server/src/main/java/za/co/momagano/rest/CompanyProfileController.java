package za.co.momagano.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyProfileController {
    private CompanyProfileService companyProfileService;

    public CompanyProfileController(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @PostMapping("/profile")
    ResponseEntity createProfile(@RequestBody CompanyProfile profile){
        companyProfileService.addProfile(profile);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/profile")
    ResponseEntity<CompanyProfile> getProfile(@RequestParam("companyRegistration") String companyRegistration){
        return ResponseEntity.ok(companyProfileService.getProfile(companyRegistration));
    }
}
