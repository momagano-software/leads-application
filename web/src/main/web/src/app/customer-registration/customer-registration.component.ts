import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { CustomerProfileControllerService } from '../api/services';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {

  constructor(private fb: FormBuilder, private customerRegistrationService: CustomerProfileControllerService) { }

  customerProfile = this.fb.group({
    name: [''],
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
