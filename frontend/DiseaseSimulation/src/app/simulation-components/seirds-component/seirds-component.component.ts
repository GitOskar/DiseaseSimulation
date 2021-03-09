import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Seirds, SeirdsService } from 'src/app/services/seirds/seirds.service';
import { SeirdsAddDialogComponent } from './seirds-add-dialog/seirds-add-dialog.component';
import { SeirdsUpdateDialogComponent } from './seirds-update-dialog/seirds-update-dialog.component';

@Component({
  selector: 'app-seirds-component',
  templateUrl: './seirds-component.component.html',
  styleUrls: ['./seirds-component.component.css']
})
export class SeirdsComponentComponent implements OnInit {

  simulations: Seirds[];
  simulationToDisplay: Seirds;
  title = "";
  currentIndex: number;

  constructor(private service: SeirdsService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.service.getAllSimulations().subscribe(
      value => {
        this.simulations = value;
      }
    )
  }

  addSimulation(): void {
    let dialogRef = this.dialog.open(SeirdsAddDialogComponent, {
      height: '700px',
      width: '750px',
    });

    dialogRef.afterClosed().subscribe(result => {
      this.service.addSimulation(result).subscribe(value =>
        this.simulations.push(value));
    })
  }

  createGraph(index: number): void {
    this.simulationToDisplay = this.simulations[index];
    this.title = this.simulationToDisplay.name;
    this.currentIndex = index;
  }

  updateSimulation() {
    let dialogRef = this.dialog.open(SeirdsUpdateDialogComponent, {
      height: '700px',
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

  delete() {
    this.service.deleteSimulation(this.simulations[this.currentIndex].id);
    this.simulations.splice(this.currentIndex, 1);
    delete this.simulationToDisplay;
    this.title = "";
  }
}