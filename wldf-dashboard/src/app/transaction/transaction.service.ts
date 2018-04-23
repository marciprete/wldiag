import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Page} from "../shared/page";
import {Transaction} from "./transaction.model";

@Injectable()
export class TransactionService {

  private transactionUrl = 'api/transactions';  // URL to web API
  // private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

  getTransactions(): Promise<Page<Transaction>> {
    return this.http.get(this.transactionUrl + "/list")
      .toPromise()
      .then(response => response.json() as Page<Transaction>)
      .catch(this.handleError);
  }

  count(): Promise<number> {
    return this.http.get(this.transactionUrl + "/count")
      .toPromise()
      .then(res => res.json() as number)
      .catch(this.handleError);
  }

  getTopClasses(): Promise<number> {
    return this.http.get(this.transactionUrl + "/topClasses")
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  getTopMethods(): Promise<number> {
    return this.http.get(this.transactionUrl + "/topMethods")
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  getThreadedTransactions(id): Promise<any> {
    return this.http.get(this.transactionUrl + "/diagnosticImage/" + id)
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
