import { Component, OnInit } from '@angular/core';
import { CompanyProfileControllerService } from '../api/services';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-company-registration',
  templateUrl: './company-registration.component.html',
  styleUrls: ['./company-registration.component.css']
})
export class CompanyRegistrationComponent implements OnInit {

  constructor(private companyRegistrationService: CompanyProfileControllerService,
    private formBuilder: FormBuilder) { }

    registrationForm = this.formBuilder.group({
    name: [''],
    tradingName: [''],
    companyRegistration: [''],
    email: [''],
    contact: [''],
    experience: [''],
    location: [''],
    portfolio: [''],
    about: ['']
  })

  ngOnInit() {
  }

  submit() {
    this.companyRegistrationService.createProfileUsingPOST(this.registrationForm.value).subscribe(() => {
      console.log('subimtted');
    });
  }

}
