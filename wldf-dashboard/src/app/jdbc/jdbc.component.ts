import { Component, OnInit } from '@angular/core';
import {ResourcePool} from "./resource-pool.model";
import {Page} from "../shared/page";
import {JdbcService} from "./jdbc.service";

@Component({
  selector: 'app-jdbc',
  templateUrl: './jdbc.component.html',
  styleUrls: ['./jdbc.component.css']
})
export class JdbcComponent implements OnInit {

  resourcePool: Page<ResourcePool> = new Page<ResourcePool>();

  constructor(private jdbcService: JdbcService) { }

  getResourcePool() : void {
      this.jdbcService.getResourcePool()
      .then(resp => {
        this.resourcePool = Object.assign(new Page<ResourcePool>(), resp, {
          content: resp.content.map(x => Object.assign(new ResourcePool(), x))//new Array(response.json().content.length)
        });
      });
  }

  ngOnInit() {
    this.getResourcePool();
  }

}
