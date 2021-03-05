import { Component, OnInit } from '@angular/core';
import { Sir, SirService } from 'src/app/services/sir/sir.service';

@Component({
  selector: 'app-sir-component',
  templateUrl: './sir-component.component.html',
  styleUrls: ['./sir-component.component.css']
})
export class SirComponentComponent implements OnInit {

  simulations: Sir[];
  simulationToDisplay: Sir;

  constructor(private service: SirService) { }

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
