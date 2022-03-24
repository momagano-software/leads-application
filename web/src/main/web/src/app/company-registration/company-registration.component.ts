import { Component, OnInit } from '@angular/core';
import { CompanyProfileControllerService } from '../api/services';
import { FormBuilder, Validators, FormArray } from '@angular/forms';

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
    about: ['', Validators.required],
    workingHours: this.formBuilder.array([
      // this.fb.control('')
    ])
  });

  workingHoursForm = this.formBuilder.group({
    day: [''],
    startHour: [''],
    startMinute: [''],
    endHour: [''],
    endMinute: ['']
  });

  // workingHours = new Map();

  readonly daysOfWeek = ["MON", "TUES", "WED", "THUR", "FRI", "SAT", "SUN"];
  readonly remainingDaysOfWeek = ["MON", "TUES", "WED", "THUR", "FRI", "SAT", "SUN"];
  readonly hoursOfDay = ["00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"];
  readonly minutesOfDay = ["00", "15", "30"];

  addingWorkHours = false;

  ngOnInit() {
  }

  submit() {
    console.log(this.registrationForm.value);
    this.companyRegistrationService.createProfileUsingPOST(this.registrationForm.value).subscribe(() => {
    }, () => {
      // todo: if there is an error submitting to the backend

    });
  }

  addDayOfWeek() {
    console.log()
    console.table(this.workingHoursForm.value)
    // this.workingHours.set("MON", {
    //   "start": "07h00",
    //   "end": "17h00"
    // });
    this.addingWorkHours = false;
  }
  get workingHours() {
    return this.registrationForm.get('workingHours') as FormArray;
  }
  // workingHoursId(i: any) {
  //   return this.workingHours[i];
  // }
  addWorkingHours() {
    // let workingHoursId = this.formBuilder.group({ dayOfTheWeek: [''], startTime: [''], endTime: [''] });
    // this.workingHours.push(this.formBuilder.control('test'));
    let myObject = this.formBuilder.group({ dayOfTheWeek: [''], startTime: [''], endTime: [''] }); 
    let workingHoursId = this.formBuilder.group(myObject);
     this.workingHours.push(workingHoursId); 

    // this.workingHours.push(this.formBuilder.control({
    //   workingHoursId: this.formBuilder.group({
    //     dayOfTheWeek: [''],
    //     startTime: [''],
    //     endTime: [''],
    //   })
    // }));
    console.log(this.workingHours);
  }
  removeWorkingHours(index) {
    this.workingHours.removeAt(index);
  }
}
