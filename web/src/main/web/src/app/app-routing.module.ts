import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewCompanyProfileComponent } from 'src/view-company-profile/view-company-profile.component';
import { AppComponent } from './app.component';
import { CompanyRegistrationComponent } from "./company-registration/company-registration.component";
import { CustomerRegistrationComponent } from './customer-registration/customer-registration.component';


const routes: Routes = [
  { path: 'company-registration', component: CompanyRegistrationComponent },
  { path: 'customer-registration', component: CustomerRegistrationComponent},
  { path: 'view-company-profile', component: ViewCompanyProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
