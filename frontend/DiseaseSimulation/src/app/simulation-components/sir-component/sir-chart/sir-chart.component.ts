import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Sir } from 'src/app/services/sir/sir.service';
import { Chart } from 'node_modules/chart.js';

@Component({
  selector: 'app-sir-chart',
  templateUrl: './sir-chart.component.html',
  styleUrls: ['./sir-chart.component.css']
})
export class SirChartComponent implements OnInit, OnChanges {

  @Input() simulation: Sir;
  title: string;

  constructor() { }

  ngOnInit(): void {
    var seirdsChart = new Chart("sirChart", {
      type: 'line',
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });
    this.title = "Title";
  }
  
  ngOnChanges(changes: SimpleChanges) {

    
    const susbeptible = this.simulation.records.map(SirRecord => SirRecord.susceptible);
    const infected = this.simulation.records.map(SirRecord => SirRecord.infected);
    const removed = this.simulation.records.map(SirRecord => SirRecord.removed);
    
    let label = Array.from(Array(this.simulation.daysOfSimulation).keys());

    var seirdsChart = new Chart("sirChart", {
      type: 'line',
      data: {
        labels: label,
        datasets: [
          {
            label: "Susceptible",
            data: susbeptible,
            fill: false,
            backgroundColor: 'rgb(45, 203, 227)',
            borderColor: 'rgb(45, 203, 227)'
          },
          {
            label: "Infected",
            data: infected,
            fill: false,
            backgroundColor: 'rgb(230, 30, 50)',
            borderColor: 'rgb(230, 30, 50)'
          },
          {
            label: "Removed",
            data: removed,
            fill: false,
            backgroundColor: 'rgb(109, 227, 129)',
            borderColor: 'rgb(109, 227, 129)'
          }
        ]
      },
      options: {
        scales: {
          xAxes: [{
          }],
          yAxes: [{
            ticks: {
              beginAtZero: true,
            }
          }]
        }
      }
    });
    this.title = this.simulation.name;
  }
}
