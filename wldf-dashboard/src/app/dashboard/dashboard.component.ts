import { Component, OnInit } from '@angular/core';
import {DashboardService} from "./dashboard.service";
import {Dashboard} from "./dashboard.model";
import {ValueList} from "./value-list.model";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  dashboard: Dashboard = new Dashboard();
  diCounter: number;
  transactionCounter: number;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.dashboardService.getDiCounter()
      .then(resp => {
        this.diCounter = resp;
      });

    this.dashboardService.getTransactionCounter()
      .then(resp => {
        this.transactionCounter = resp;
      });

    this.dashboardService.getTopClasses()
      .then(resp => {
        for(let top of resp ) {
          let vl = new ValueList();
          vl.label = top.fqnClassName;
          vl.value = top.hits;
          this.dashboard.topClassesTotal += top.hits;
          this.dashboard.topClasses.push(vl);
        }
      });

    this.dashboardService.getTopMethods()
      .then(resp => {
        for(let top of resp ) {
          let vl = new ValueList();
          vl.label = top.fqnClassName + "." + top.method;
          vl.value = top.hits;
          this.dashboard.topMethodsTotal += top.hits;
          this.dashboard.topMethods.push(vl);
        }
      });
  }

}
