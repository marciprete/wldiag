import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

// import { JtaComponent } from './jta/jta.component';
import { DiagnosticImageListComponent } from './diagnostic-images/diagnostic-image-list/diagnostic-image-list.component';
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {TransactionComponent} from "./transaction/transaction.component";
import {JdbcComponent} from "./jdbc/jdbc.component";
import {DiagnosticImageDetailComponent} from "./diagnostic-images/diagnostic-image-detail/diagnostic-image-detail.component";
import {JdbcResourceComponent} from "./jdbc/jdbc-resource/jdbc-resource.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
// import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'di/list', component: DiagnosticImageListComponent },
  { path: 'di/show/:id', component: DiagnosticImageDetailComponent },
  { path: 'customers', component: CustomerListComponent },
  { path: 'transactions', component: TransactionComponent },
  { path: 'jdbc', component: JdbcComponent },
  { path: 'jdbc/details/:id', component: JdbcResourceComponent },
  // { path: 'transactions', component: TransactionComponent },
  // { path: 'jta', component: JtaComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
