import { Component, OnInit } from '@angular/core';
import {TransactionService} from "./transaction.service";
import {Transaction} from "./transaction.model";
import {Page} from "../shared/page";

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  private dtOptions = {};

  transactionsPage: Page<Transaction> = new Page<Transaction>();

  constructor(private transactionService: TransactionService) { }

  ngOnInit() {
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
        this.transactionService.getTransactions()
          .then(resp => {
            console.log(resp);
            this.transactionsPage = resp;
            callback({
              recordsTotal: resp.totalElements,
              recordsFiltered: resp.totalElements,
              data: []
            });
          });
      }
    };
    this.getTransactions();
  }

  getTransactions():void {
    this.transactionService.getTransactions()
      .then(transactionsPage => this.transactionsPage = transactionsPage);
  }
}
