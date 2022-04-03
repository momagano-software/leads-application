import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CustomerProfileControllerService } from '../api/services';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {

  constructor(private fb: FormBuilder, private customerRegistrationService: CustomerProfileControllerService) { }
  validationMessages = {
    name: 'Name is required',
    surname: 'Surname is required',
    email: 'Email is required',
    contact: 'Contact number is required',
  };

  customerProfile = this.fb.group({
    name: ['', Validators.required],
    surname: [''],
    email: [''],
    contact: ['']
  });

  ngOnInit() {
  }

  submit() {
    this.customerRegistrationService.addCustomerProfileUsingPOST(this.customerProfile.value).subscribe( res => {
    })
  }

}
