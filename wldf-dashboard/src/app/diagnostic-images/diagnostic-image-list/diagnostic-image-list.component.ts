import {Component, OnInit} from "@angular/core";
import {DiagnosticImage} from "../diagnostic-image.model";
import {Page} from "../../shared/page";
import {DiagnosticImageService} from "../diagnostic-image.service";
import {CustomerService} from "../../customer-list/customer.service";
import {Customer} from "../../customer-list/customer.model";
import { HttpClient, HttpResponse } from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import { fromPromise } from 'rxjs/observable/fromPromise';


@Component({
  selector: 'app-diagnostic-image-list',
  templateUrl: './diagnostic-image-list.component.html',
  styleUrls: ['./diagnostic-image-list.component.css']
})
export class DiagnosticImageListComponent implements OnInit {

  diagnosticImagesPage: Page<DiagnosticImage> = new Page<DiagnosticImage>();
  customers = [];
  page : number = 1;
  dtOptions = {};
  diagnosticImages: DiagnosticImage[];

  constructor(private http: HttpClient,
              private diagnosticImageService: DiagnosticImageService,
              private customerService: CustomerService) { }

  getDiagnosticImages(page?: number) {
    this.diagnosticImageService.getDiagnosticImages(page)
      .then(resp => {
        this.diagnosticImagesPage = resp as Page<DiagnosticImage>;
        this.page = this.diagnosticImagesPage.number+1
      });
  }

  getCustomers() {
    this.customerService.getCustomers()
      .then(resp => {
        this.customers = resp as Customer[]
      });
  }

  ngOnInit() {
    let that = this;

    this.dtOptions = {
      pagingType: 'first_last_numbers',
      pageLength: 25,
      serverSide: true,
      processing: true,
      searching: false,
      autoWidth: false,
      columnDefs: [
        {"targets": [2,3], sortable:false}
      ],
      ajax: (dataTablesParameters: any, callback) => {
        that.diagnosticImageService.getDiagnosticImages(dataTablesParameters)
          .then(resp => {
            this.diagnosticImages = resp.content;
            callback({
              recordsTotal: resp.totalElements,
              recordsFiltered: resp.totalElements,
              data: []
            });
          });
      }
    };
    // this.getDiagnosticImages();
    this.getCustomers();
  }

  onPager($event) {
    this.getDiagnosticImages($event-1)
  }

  delete(imageId:number): void {
    console.log(imageId);
  }

}
