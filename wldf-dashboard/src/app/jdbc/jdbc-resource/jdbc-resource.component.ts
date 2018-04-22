import {Component, Input, OnInit} from '@angular/core';
import {JdbcResource} from "./jdbc-resource.model";
import {JdbcService} from "../jdbc.service";
import {ActivatedRoute} from "@angular/router";
import {Page} from "../../shared/page";
import { URLSearchParams } from "@angular/http";

@Component({
  selector: 'app-jdbc-resource',
  templateUrl: './jdbc-resource.component.html',
  styleUrls: ['./jdbc-resource.component.css']
})
export class JdbcResourceComponent implements OnInit {

  resourcePage = new Page<JdbcResource>();
  page: any;
  previousPage: any;
  id: number;

  //Filters
  params = new URLSearchParams();
  enabled: any = "all";

  constructor(private jdbcService: JdbcService, private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.page = 1;
    this.id = this.route.snapshot.params['id'];
    this.loadData();
  }

  change(page):void {
    page = page-1;
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.params.set("page", page);
      this.params.set('enabled', this.enabled );
      this.loadData();
    }
  }

  loadData():void {
    this.jdbcService.details(this.id, this.params)
      .then((resp) => {
        this.resourcePage = Object.assign(new Page<JdbcResource>(), resp, {
          content: resp.content.map(x => Object.assign(new JdbcResource(), x))//new Array(response.json().content.length)
        });
      });
  }

  changeFlag(value?:any) : void {
    console.log("fatto");
    console.log(value);
    this.params.set('enabled', this.enabled );
    this.loadData();

  }
}
