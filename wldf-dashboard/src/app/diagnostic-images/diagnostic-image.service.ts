import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, URLSearchParams} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {DiagnosticImage} from "./diagnostic-image.model";
import {Page} from "../shared/page";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DiagnosticImageService {

  private diagnosticImageUrl = 'api/di';  // URL to web API
  private headers = new Headers({'Content-Type': 'application/json'});

  private columnMapping = ['acquisition_time', 'file_name'];

  constructor(private http: Http) { }

  getDiagnosticImages(datatableParameters?: any): Promise<Page<DiagnosticImage>> {
    console.log(datatableParameters);
    let options = new RequestOptions();
    options.headers = this.headers;
    if (datatableParameters != null) {
      let params = new URLSearchParams();
      let page = (datatableParameters.start / datatableParameters.length);
      params.append("size", datatableParameters.length);
      params.append("page",page.toString());
      if(datatableParameters.order !== undefined) {
        params.append('sort', this.columnMapping[datatableParameters.order[0].column]+","+datatableParameters.order[0].dir)
      }
      options.params = params;
    }
    return this.http.get(this.diagnosticImageUrl + "/list", options)
        .toPromise()
        .then(response => response.json() as Page<DiagnosticImage>)
        .catch(this.handleError)
    ;
  }

  get(id:number): Promise<DiagnosticImage> {
    return this.http.get(this.diagnosticImageUrl + "/show/" + id + "/", {headers: this.headers})
      .toPromise()
      .then(res => res.json() as DiagnosticImage)
      .catch(this.handleError);
  }

  show(id:number): Promise<any> {
    return this.http.get(this.diagnosticImageUrl + "/show/" + id + "/", {headers: this.headers})
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  count(): Promise<number> {
    return this.http.get(this.diagnosticImageUrl + "/count", {headers: this.headers})
      .toPromise()
      .then(res => res.json() as number)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
