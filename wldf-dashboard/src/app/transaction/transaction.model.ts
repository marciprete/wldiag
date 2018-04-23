import {Thread} from "../threads/thread.model";
import {Property} from "./property.model";
import {EjbTransaction} from "./ejb-transaction.model";

export class Transaction {
  xid: string;
  state: string;
  status: string;
  beginTime: string;
  coordinatorURL: string;
  activeThread: Thread;
  replieasOwedMe: number;
  repliesOwedOthers: number;
  retry: boolean;
  localProperties: Property[];
  globalProperties: Property[];
  //TODO: Create a model for the "server" object
  servers: any[];
  ejbTransactions: EjbTransaction[];

}
