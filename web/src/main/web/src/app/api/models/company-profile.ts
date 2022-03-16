/* tslint:disable */
import { WorkingHours } from './working-hours';
export interface CompanyProfile {
  about?: string;
  companyRegistration?: string;
  contact?: string;
  email?: string;
  experience?: string;
  location?: string;
  name?: string;
  portfolio?: string;
  tradingName?: string;
  workingHours?: Array<WorkingHours>;
}
