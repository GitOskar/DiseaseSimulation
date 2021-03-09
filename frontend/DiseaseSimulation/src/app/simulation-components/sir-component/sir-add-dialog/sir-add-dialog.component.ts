import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Sir } from 'src/app/services/sir/sir.service';
import { integer, sirValidation } from 'src/app/shared/customValidation';

@Component({
  selector: 'app-sir-add-dialog',
  templateUrl: './sir-add-dialog.component.html',
  styleUrls: ['./sir-add-dialog.component.css']
})
export class SirAddDialogComponent {

  error = "";

  peopleNumber = [Validators.required, Validators.min(1), integer()];
  number = [Validators.required, Validators.min(0.0)];
  numberBetweenOneAndTwo = [Validators.required, Validators.min(0.0), Validators.max(1.0)];

  nameControl = new FormControl('', Validators.required);
  populationControl = new FormControl('', this.peopleNumber);
  initialInfectedNumberControl = new FormControl('', this.peopleNumber);
  daysOfSimulationControl = new FormControl('', this.peopleNumber);
  reproductionRateControl = new FormControl('', this.number);
  diseaseDurationControl = new FormControl('', this.number);
  birthRateControl = new FormControl('', this.numberBetweenOneAndTwo);
  deathRateControl = new FormControl('', this.numberBetweenOneAndTwo);

  constructor(public dialogRef: MatDialogRef<SirAddDialogComponent>) {
    this.dialogRef.disableClose = true;
   }

   getPeopleNumberError(peopleNumberControl: FormControl): string {
    if (peopleNumberControl.hasError('required'))
      return 'You must enter a value';
    else if (peopleNumberControl.hasError('min'))
      return 'Value cannot be less than 1';
    else
      return 'Value has to be an integer';
  }

  getNumberError(numberControl: FormControl): string {
    if (numberControl.hasError('required'))
      return 'You must enter a value';
    else
      return 'Value cannot be less than 0.00';
  }

  getNumberBetweenZeroAndOneError(numberControl: FormControl): string {
    if (numberControl.hasError('required'))
      return 'You must enter a value';
    else if (numberControl.hasError('min'))
      return 'Value cannot be less than 0.00';
    else
      return 'Value cannot be greather than 1.00';
  }

  onAddClick(name, population, infected, daysOfSimulation, reproduction, diseaseDuration, birthRate, deathRate) {

     if (!this.isValid()) {
       this.error = "Input is invalid*";
       return;
     }

   let simulation = new Sir();
   simulation.name = name;
   simulation.population = Number.parseInt(population);
   simulation.initialInfectedNumber = Number.parseInt(infected);
   simulation.daysOfSimulation = Number.parseInt(daysOfSimulation);
   simulation.reproductionRate = Number.parseFloat(reproduction);
   simulation.diseaseDuration = Number.parseFloat(diseaseDuration);
   simulation.birthRate = Number.parseFloat(birthRate);
   simulation.deathRate = Number.parseFloat(deathRate);

   this.error = sirValidation(simulation);

   if (this.error == "")
     this.dialogRef.close(simulation);
 }

 isValid(): boolean {
  return this.nameControl.valid &&
    this.populationControl.valid &&
    this.initialInfectedNumberControl.valid &&
    this.daysOfSimulationControl.valid &&
    this.reproductionRateControl.valid &&
    this.diseaseDurationControl.valid &&
    this.birthRateControl.valid &&
    this.deathRateControl.valid;
}

}
