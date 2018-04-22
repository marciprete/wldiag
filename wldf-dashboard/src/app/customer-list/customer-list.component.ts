import { Component, OnInit } from '@angular/core';
import {Customer} from "./customer.model";
import {CustomerService} from "./customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];

  constructor(private customerService: CustomerService) { }

  getCustomers() {
    this.customerService.getCustomers()
      .then(resp => {
        console.log(resp);
        this.customers = resp as Customer[];
      });
  }
  ngOnInit() {
    this.getCustomers();
  }

}
