/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { CustomerProfile } from '../models/customer-profile';
import { ResponseEntity } from '../models/response-entity';

/**
 * Customer Profile Controller
 */
@Injectable({
  providedIn: 'root',
})
class CustomerProfileControllerService extends __BaseService {
  static readonly getCustomerProfileByEmailUsingGETPath = '/customer/profile';
  static readonly addCustomerProfileUsingPOSTPath = '/customer/profile';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * getCustomerProfileByEmail
   * @param customerEmail customerEmail
   * @return OK
   */
  getCustomerProfileByEmailUsingGETResponse(customerEmail: string): __Observable<__StrictHttpResponse<CustomerProfile>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (customerEmail != null) __params = __params.set('customerEmail', customerEmail.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/customer/profile`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CustomerProfile>;
      })
    );
  }
  /**
   * getCustomerProfileByEmail
   * @param customerEmail customerEmail
   * @return OK
   */
  getCustomerProfileByEmailUsingGET(customerEmail: string): __Observable<CustomerProfile> {
    return this.getCustomerProfileByEmailUsingGETResponse(customerEmail).pipe(
      __map(_r => _r.body as CustomerProfile)
    );
  }

  /**
   * addCustomerProfile
   * @param customerProfile customerProfile
   * @return OK
   */
  addCustomerProfileUsingPOSTResponse(customerProfile: CustomerProfile): __Observable<__StrictHttpResponse<ResponseEntity>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = customerProfile;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/customer/profile`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ResponseEntity>;
      })
    );
  }
  /**
   * addCustomerProfile
   * @param customerProfile customerProfile
   * @return OK
   */
  addCustomerProfileUsingPOST(customerProfile: CustomerProfile): __Observable<ResponseEntity> {
    return this.addCustomerProfileUsingPOSTResponse(customerProfile).pipe(
      __map(_r => _r.body as ResponseEntity)
    );
  }
}

module CustomerProfileControllerService {
}

export { CustomerProfileControllerService }
