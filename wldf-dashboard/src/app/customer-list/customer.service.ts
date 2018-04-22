import { Injectable } from '@angular/core';
import {Customer} from "./customer.model";
import {Http} from "@angular/http";

@Injectable()
export class CustomerService {

  private customerUrl = 'api/customers';

  constructor(private http: Http) { }

  getCustomers(): Promise<Customer[]> {
    return this.http.get(this.customerUrl + "/list")
      .toPromise()
      .then(response => response.json() as Customer[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
