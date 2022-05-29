package za.co.momagano.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.momagano.service.LookupService;


@RestController
public class LookupController {

    private LookupService lookupService;

    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping("/lookup")
    public ResponseEntity getLookups() {
        return ResponseEntity.ok(lookupService.getLookupObject());
    }
}
