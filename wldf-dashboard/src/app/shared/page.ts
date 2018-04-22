import {noUndefined} from "@angular/compiler/src/util";
export class Page<T> {
  content: T[];
  first: boolean;
  last: boolean;
  number: number;
  numberOfElements: number;
  sort: any;
  size: number;
  totalElements: number;
  totalPages: number;

}

