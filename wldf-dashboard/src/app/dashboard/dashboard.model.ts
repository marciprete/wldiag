import {ValueList} from "./value-list.model";

export class Dashboard {
  public topClassesTotal: number;

  public topMethodsTotal: number;
  public topClasses: Array<ValueList> = [];
  public topMethods: Array<ValueList> = [];

  constructor() {
    this.topClassesTotal = 0;
    this.topMethodsTotal = 0;
  }
}
