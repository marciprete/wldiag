import { Injectable } from '@angular/core';
import {Http, Headers } from "@angular/http";
import { URLSearchParams } from "@angular/http";
import {Page} from "../shared/page";
import {ResourcePool} from "./resource-pool.model";
import {JdbcResource} from "./jdbc-resource/jdbc-resource.model";

@Injectable()
export class JdbcService {

  private jdbcUrl = 'api/jdbc';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

  getResourcePool(): Promise<Page<ResourcePool>> {
    let resources = this.http.get(this.jdbcUrl + "/list")
      .toPromise()
      .then(response =>  response.json() as Page<ResourcePool>
      )
      .catch(this.handleError);
    return resources;
  }

  details(id:number, params?:URLSearchParams): Promise<Page<JdbcResource>> {
    let uri = this.jdbcUrl + "/details/" + id + "/";
    let queryString = params.toString();
    if(queryString !== "") {
      uri += "?"+params.toString();
    }
    console.log(queryString);
    return this.http.get(uri, {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Page<JdbcResource>)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
