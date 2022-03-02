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

    validationMessages = {
    name: 'Name is required',
    tradingName: 'Trading name is required',
    companyRegistration: 'A company registration  is required',
    email: 'Email is required',
    contact: 'Contact number is required',
    experience: 'Experience is required',
    location: 'Location is required',
    portfolio: 'Portfolio is required',
    about: 'A company description is required'
  };

  registrationForm = this.formBuilder.group({
    name: ['', Validators.required],
    tradingName: ['', Validators.required],
    companyRegistration: ['', Validators.required],
    email: ['', Validators.required],
    contact: ['', Validators.required],
    experience: ['', Validators.required],
    location: ['', Validators.required],
    portfolio: ['', Validators.required],
    about: ['', Validators.required]
  })

  ngOnInit() {
  }

  submit() {
    this.companyRegistrationService.createProfileUsingPOST(this.registrationForm.value).subscribe(() => {
    }, () => {
      // todo: if there is an error submitting to the backend
    });
  }

}
