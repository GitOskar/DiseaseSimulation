import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Chart } from 'node_modules/chart.js';
import { Seirds, SeirdsRecord } from 'src/app/services/seirds/seirds.service';

@Component({
  selector: 'app-seirds-chart',
  templateUrl: './seirds-chart.component.html',
  styleUrls: ['./seirds-chart.component.css']
})
export class SeirdsChartComponent implements OnInit, OnChanges {

  @Input() simulation: Seirds;
  seirdsChart: Chart;
  constructor() { }

  ngOnInit(): void {
    this.seirdsChart = new Chart("seirdsChart", {
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
  }



  ngOnChanges(changes: SimpleChanges) {
    const susbeptible = this.simulation.records.map(SeirdsRecord => SeirdsRecord.susceptible);
    const exposed = this.simulation.records.map(SeirdsRecord => SeirdsRecord.exposed);
    const infected = this.simulation.records.map(SeirdsRecord => SeirdsRecord.infected);
    const recovered = this.simulation.records.map(SeirdsRecord => SeirdsRecord.recovered);
    const deaths = this.simulation.records.map(SeirdsRecord => SeirdsRecord.deaths);
    let label = Array.from(Array(this.simulation.daysOfSimulation).keys());

    this.seirdsChart.destroy();

    this.seirdsChart = new Chart("seirdsChart", {
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
            label: "Exposed",
            data: exposed,
            fill: false,
            backgroundColor: 'rgb(246, 255, 115)',
            borderColor: 'rgb(2246, 255, 115)'
          },
          {
            label: "Infected",
            data: infected,
            fill: false,
            backgroundColor: 'rgb(230, 30, 50)',
            borderColor: 'rgb(230, 30, 50)'
          },
          {
            label: "Recovered",
            data: recovered,
            fill: false,
            backgroundColor: 'rgb(109, 227, 129)',
            borderColor: 'rgb(109, 227, 129)'
          },
          {
            label: "Deaths",
            data: deaths,
            fill: false,
            backgroundColor: 'rgb(82, 82, 82)',
            borderColor: 'rgb(82, 82, 82)'
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
  }
}
