import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from "@angular/forms";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';

import { DiagnosticImagesComponent } from './diagnostic-images/diagnostic-images.component';
import { DiagnosticImageListComponent } from './diagnostic-images/diagnostic-image-list/diagnostic-image-list.component';
import { DiagnosticImageDetailComponent } from './diagnostic-images/diagnostic-image-detail/diagnostic-image-detail.component';
import { DiagnosticImageItemComponent } from './diagnostic-images/diagnostic-image-list/diagnostic-image-item/diagnostic-image-item.component';
import { CustomerEditComponent } from './customer-list/customer-edit/customer-edit.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { HeaderComponent } from './header/header.component';
import {DiagnosticImageService} from "./diagnostic-images/diagnostic-image.service";
import {AppRoutingModule} from "./app-routing.module";
import {CustomerService} from "./customer-list/customer.service";
import { TransactionComponent } from './transaction/transaction.component';
import { ThreadsComponent } from './threads/threads.component';
import {TransactionService} from "./transaction/transaction.service";
import { JdbcComponent } from './jdbc/jdbc.component';
import {JdbcService} from "./jdbc/jdbc.service";
import { JdbcResourceComponent } from './jdbc/jdbc-resource/jdbc-resource.component';
import { LayoutModule } from 'angular-admin-lte';
import { adminLteConf } from "../adminLteConf";
import {NgbdModalComponent, NgbdModalContent} from "./shared/modals/modal-component.component";
import {NgbdModalBasic} from "./shared/modals/modal-basic.component";
import { DashboardComponent } from './dashboard/dashboard.component';
import {DashboardService} from "./dashboard/dashboard.service";
import {DataTablesModule} from "angular-datatables";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    DiagnosticImagesComponent,
    DiagnosticImageListComponent,
    DiagnosticImageDetailComponent,
    DiagnosticImageItemComponent,
    CustomerEditComponent,
    CustomerListComponent,
    HeaderComponent,
    TransactionComponent,
    ThreadsComponent,
    JdbcComponent,
    JdbcResourceComponent,
    NgbdModalBasic,
    NgbdModalComponent,
    NgbdModalContent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    DataTablesModule,
    LayoutModule.forRoot(adminLteConf)
  ],
  entryComponents: [
    NgbdModalContent
  ],
  providers: [DiagnosticImageService, CustomerService, TransactionService, JdbcService, DashboardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
