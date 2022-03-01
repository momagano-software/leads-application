/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { CompanyProfile } from '../models/company-profile';
import { ResponseEntity } from '../models/response-entity';

/**
 * Company Profile Controller
 */
@Injectable({
  providedIn: 'root',
})
class CompanyProfileControllerService extends __BaseService {
  static readonly getProfileUsingGETPath = '/profile';
  static readonly createProfileUsingPOSTPath = '/profile';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * getProfile
   * @param companyRegistration companyRegistration
   * @return OK
   */
  getProfileUsingGETResponse(companyRegistration: string): __Observable<__StrictHttpResponse<CompanyProfile>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (companyRegistration != null) __params = __params.set('companyRegistration', companyRegistration.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/profile`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CompanyProfile>;
      })
    );
  }
  /**
   * getProfile
   * @param companyRegistration companyRegistration
   * @return OK
   */
  getProfileUsingGET(companyRegistration: string): __Observable<CompanyProfile> {
    return this.getProfileUsingGETResponse(companyRegistration).pipe(
      __map(_r => _r.body as CompanyProfile)
    );
  }

  /**
   * createProfile
   * @param profile profile
   * @return OK
   */
  createProfileUsingPOSTResponse(profile: CompanyProfile): __Observable<__StrictHttpResponse<ResponseEntity>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = profile;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/profile`,
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
   * createProfile
   * @param profile profile
   * @return OK
   */
  createProfileUsingPOST(profile: CompanyProfile): __Observable<ResponseEntity> {
    return this.createProfileUsingPOSTResponse(profile).pipe(
      __map(_r => _r.body as ResponseEntity)
    );
  }
}

module CompanyProfileControllerService {
}

export { CompanyProfileControllerService }
