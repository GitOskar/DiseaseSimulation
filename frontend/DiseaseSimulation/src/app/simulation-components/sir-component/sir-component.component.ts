import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Sir, SirService } from 'src/app/services/sir/sir.service';
import { SirAddDialogComponent } from './sir-add-dialog/sir-add-dialog.component';
import { SirUpdateDialogComponent } from './sir-update-dialog/sir-update-dialog.component';

@Component({
  selector: 'app-sir-component',
  templateUrl: './sir-component.component.html',
  styleUrls: ['./sir-component.component.css']
})
export class SirComponentComponent implements OnInit {

  simulations: Sir[];
  simulationToDisplay: Sir;
  title = "";
  currentIndex: number;

  constructor(private service: SirService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.service.getAllSimulations().subscribe(
      value => {
        this.simulations = value;
      }
    )
  }

  addSimulation(): void {
    let dialogRef = this.dialog.open(SirAddDialogComponent, {
      height: '410px',
      width: '750px',
    });

    dialogRef.afterClosed().subscribe(result => {
      this.service.addSimulation(result).subscribe(value =>
        this.simulations.push(value));
    })
  }

  updateSimulation() {
    let dialogRef = this.dialog.open(SirUpdateDialogComponent, {
      height: '410px',
      width: '750px',
      data: this.simulationToDisplay
    });

    dialogRef.afterClosed().subscribe(result => {
      this.service.updateSimulation(result).subscribe(value => {
        this.simulationToDisplay = value;
        this.simulations[this.currentIndex] = value;
        this.title = value.name;
        });
      })}

  createGraph(index: number): void {
    this.simulationToDisplay = this.simulations[index];
    this.title = this.simulationToDisplay.name;
    this.currentIndex = index;
  }

  delete() {
    this.service.deleteSimulation(this.simulations[this.currentIndex].id);
    this.simulations.splice(this.currentIndex, 1);
    delete this.simulationToDisplay;
    this.title = "";
  }
}
