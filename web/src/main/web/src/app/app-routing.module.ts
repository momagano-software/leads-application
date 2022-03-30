import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CompanyRegistrationComponent } from "./company-registration/company-registration.component";
import { CustomerRegistrationComponent } from './customer-registration/customer-registration.component';


const routes: Routes = [
  { path: 'company-registration', component: CompanyRegistrationComponent },
  { path: 'customer-registration', component: CustomerRegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
