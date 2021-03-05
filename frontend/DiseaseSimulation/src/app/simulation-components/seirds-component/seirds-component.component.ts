import { Component, OnInit } from '@angular/core';
import { Seirds, SeirdsService } from 'src/app/services/seirds/seirds.service';

@Component({
  selector: 'app-seirds-component',
  templateUrl: './seirds-component.component.html',
  styleUrls: ['./seirds-component.component.css']
})
export class SeirdsComponentComponent implements OnInit {

  simulations: Seirds[];
  simulationToDisplay: Seirds;

  constructor(private service: SeirdsService) { }

  ngOnInit(): void {
    this.service.getAllSimulations().subscribe(
      value => {
        this.simulations = value;
      }
    )
  }

  addSimulation(): void {
    console.log("TODO IMPLEMENT ADD SIMULATION");
  }

  createGraph(index: number): void {
    this.simulationToDisplay = this.simulations[index];
  }
}