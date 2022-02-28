import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CompanyRegistrationComponent } from "./company-registration/company-registration.component";


const routes: Routes = [
  { path: 'company-registration', component: CompanyRegistrationComponent },
  { path: '', redirectTo: '/company-registration', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
