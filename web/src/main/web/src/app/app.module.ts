import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyRegistrationComponent } from './company-registration/company-registration.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CustomerRegistrationComponent } from './customer-registration/customer-registration.component';
import { FormlyModule } from '@ngx-formly/core';
import { FormlyBootstrapModule } from '@ngx-formly/bootstrap';
import { ServiceRegistrationComponent } from 'src/service-registration/service-registration.component';
import { ViewCompanyProfileComponent } from 'src/view-company-profile/view-company-profile.component';
import { FaqComponent} from 'src/service-registration/faq.type';

@NgModule({
  declarations: [
    AppComponent,
    CompanyRegistrationComponent,
    NavigationComponent,
    CustomerRegistrationComponent,
    ServiceRegistrationComponent,
    ViewCompanyProfileComponent,
    FaqComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormlyModule.forRoot({ extras: { lazyRender: true },
      validationMessages: [
        { name: 'required', message: 'This field is required' },
      ],
      types: [
        {name: 'faqs', component: FaqComponent}
      ]
    }),
    FormlyBootstrapModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
