import {AfterViewInit, Component, OnInit} from '@angular/core';
import {DiagnosticImageService} from "../diagnostic-image.service";
import {ActivatedRoute} from "@angular/router";
import {DiagnosticImage} from "../diagnostic-image.model";
import {TransactionService} from "../../transaction/transaction.service";
// import { Chart } from 'chart.js/dist/Chart.js';
import {Chart} from 'chart.js';

@Component({
  selector: 'app-diagnostic-image-detail',
  templateUrl: './diagnostic-image-detail.component.html',
  styleUrls: ['./diagnostic-image-detail.component.css']
})
export class DiagnosticImageDetailComponent implements OnInit, AfterViewInit {


  // diagnosticImage: DiagnosticImage = new DiagnosticImage();
  diagnosticImage: any;
  transactions: any;
  txChart = [];
  memChart = [];

  constructor(private diagnosticImageService: DiagnosticImageService,
              private transactionService: TransactionService,
              private route: ActivatedRoute) {
  }

  ngAfterViewInit(): void {
    var txChartCanvas = <HTMLCanvasElement> document.getElementById("txChart");
    var txChartCtx = txChartCanvas.getContext("2d");
    this.txChart = new Chart(txChartCtx, {
      type: 'doughnut',
      data: {
        labels: ["Transaction Thread", "Idle Threads", "Standby Threads"],
        datasets: [{
          data: [(this.diagnosticImage.totalThreadCount-this.diagnosticImage.idleThreadCount-this.diagnosticImage.standbyThreadCount), this.diagnosticImage.idleThreadCount, this.diagnosticImage.standbyThreadCount],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            // 'rgba(75, 192, 192, 0.2)',
            // 'rgba(153, 102, 255, 0.2)',
            // 'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            // 'rgba(75, 192, 192, 1)',
            // 'rgba(153, 102, 255, 1)',
            // 'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: Chart.defaults.doughnut
    });

/*
window.chartColors = {
	red: 'rgb(255, 99, 132)',
	orange: 'rgb(255, 159, 64)',
	yellow: 'rgb(255, 205, 86)',
	green: 'rgb(75, 192, 192)',
	blue: 'rgb(54, 162, 235)',
	purple: 'rgb(153, 102, 255)',
	grey: 'rgb(201, 203, 207)'
};
 */


    var memChartCanvas = <HTMLCanvasElement> document.getElementById("memChart");
    var memChartCtx = memChartCanvas.getContext("2d");
    this.txChart = new Chart(memChartCtx, {
        type: "bar",
        data: {
          labels: ["Heap", "Non-heap"],
          datasets: [
            {
              label: "Init size",
              data: [this.diagnosticImage.heapMemoryInitBytes/(1024*1024),
                this.diagnosticImage.nonHeapMemoryInitBytes/(1024*1024)],
              fill: false,
              backgroundColor: "rgb(255, 99, 132)",
              borderWidth: 1
            },
            {
              label: "Committed",
              data: [this.diagnosticImage.heapMemoryCommittedBytes/(1024*1024),
                    this.diagnosticImage.nonHeapMemoryCommittedBytes/(1024*1024)],
              fill: false,
              backgroundColor: "rgb(75, 192, 192)",
              borderWidth: 1
            },
            {
              label: "Used",
              data: [this.diagnosticImage.heapMemoryUsedBytes/(1024*1024),
                this.diagnosticImage.nonHeapMemoryUsedBytes/(1024*1024)],
              fill: false,
              backgroundColor: 'rgb(255, 205, 86)',
              borderWidth: 1
            }]
        },
        options: {
          scales: {
            // xAxes: [{stacked: true}],
            yAxes:
              [{ticks: {beginAtZero: true}}
                ,{stacked: true}
            ]
          }
        }


        // data: {
        //   // datasets: [{
        //     label: 'Memory usage',
        //     data: [
        //       this.diagnosticImage.heapMemoryInitBytes,
        //       this.diagnosticImage.heapMemoryCommittedBytes,
        //       this.diagnosticImage.heapMemoryUsedBytes,
        //     ],
        //     backgroundColor: [
        //       'rgba(255, 99, 132, 0.2)',
        //       'rgba(54, 162, 235, 0.2)',
        //       'rgba(255, 206, 86, 0.2)'
        //     ],
        //     borderColor: [
        //       'rgba(255,99,132,1)',
        //       'rgba(54, 162, 235, 1)',
        //       'rgba(255, 206, 86, 1)'
        //     ]
        // }
        // , {
        //   label: 'Max Memory',
        //   data: [
        //     this.diagnosticImage.heapMemoryMaxBytes,
        //     this.diagnosticImage.heapMemoryMaxBytes,
        //     this.diagnosticImage.heapMemoryMaxBytes,
        //   ],
        //   type: 'line',
        //   fill: false,
        //   tension: 0,
        //   borderColor: 'rgba(255,99,132,1)'
        // }
        // ]
        // }
      }
    )
    ;

  }


  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];

    this.diagnosticImageService.show(id)
      .then(resp => {
        this.diagnosticImage = resp;
      });

    this.transactionService.getThreadedTransactions(id)
      .then(resp => {
        console.log(resp);
        this.transactions = resp.content;
      });
  }

}
