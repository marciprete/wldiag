import { Injectable } from '@angular/core';
import {DiagnosticImageService} from "../diagnostic-images/diagnostic-image.service";
import {TransactionService} from "../transaction/transaction.service";

@Injectable()
export class DashboardService {


  constructor(private diagnosticImageService: DiagnosticImageService,
              private transactionService: TransactionService) {
  }


  getDiCounter(): Promise<number> {
      return this.diagnosticImageService.count();
  }

  getTransactionCounter(): Promise<number> {
    return this.transactionService.count();
  }

  getTopClasses(): Promise<any> {
    return this.transactionService.getTopClasses();
  }

  getTopMethods(): Promise<any> {
    return this.transactionService.getTopMethods();
  }
}
