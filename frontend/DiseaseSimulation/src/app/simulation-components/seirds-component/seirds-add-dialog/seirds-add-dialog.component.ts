import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { integer, seirdsValidation } from 'src/app/shared/customValidation';
import { Seirds } from 'src/app/services/seirds/seirds.service';

@Component({
  selector: 'app-seirds-add-dialog',
  templateUrl: './seirds-add-dialog.component.html',
  styleUrls: ['./seirds-add-dialog.component.css']
})
export class SeirdsAddDialogComponent {

error = "";

  peopleNumber = [Validators.required, Validators.min(1), integer()];
  number = [Validators.required, Validators.min(0.0)];
  numberBetweenOneAndTwo = [Validators.required, Validators.min(0.0), Validators.max(1.0)];

  nameControl = new FormControl('', Validators.required);
  populationControl = new FormControl('', this.peopleNumber);
  initialInfectedNumberControl = new FormControl('', this.peopleNumber);
  daysOfSimulationControl = new FormControl('', this.peopleNumber);
  reproductionRateControl = new FormControl('', this.number);
  immunityTimeControl = new FormControl('', this.number);
  incubationTimeControl = new FormControl('', this.number);
  diseaseDurationControl = new FormControl('', this.number);
  daysOfRestrictionsControl = new FormControl('', this.number);
  infectiousTimeControl = new FormControl('', this.number);
  timeOfOnsetOfSymptomsControl = new FormControl('', this.number);
  timeOfDyingFromIncubationControl = new FormControl('', this.number);
  birthRateControl = new FormControl('', this.numberBetweenOneAndTwo);
  naturalDeathRateControl = new FormControl('', this.numberBetweenOneAndTwo);
  quarantineRateControl = new FormControl('', this.numberBetweenOneAndTwo);
  diseaseDeathRateControl = new FormControl('', this.numberBetweenOneAndTwo);
  reductionByRestrictionsControl = new FormControl('', this.numberBetweenOneAndTwo);
  percentageOfPopulationWhenRestrictionsBeginsControl = new FormControl('', this.numberBetweenOneAndTwo);
  

  constructor(public dialogRef: MatDialogRef<SeirdsAddDialogComponent>) {
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

  onAddClick(name, population, infected, daysOfSimulation, reproduction, immunity, incubation, diseaseDuration, daysOfRestrictions, infectiousTime, onsetOfSymptoms,
     timeOfDying, birthRate, naturalDeathRate, quarantineRate, diseaseDeathRate, reductionByRestrictions, beginsOfRestrictions) {

      if (!this.isValid()) {
        this.error = "Input is invalid*";
        return;
      }

    let simulation = new Seirds();
    simulation.name = name;
    simulation.population = Number.parseInt(population);
    simulation.initialInfectedNumber = Number.parseInt(infected);
    simulation.daysOfSimulation = Number.parseInt(daysOfSimulation);
    simulation.reproductionRate = Number.parseFloat(reproduction);
    simulation.immunityTime = Number.parseFloat(immunity);
    simulation.incubationTime = Number.parseFloat(incubation);
    simulation.diseaseDuration = Number.parseFloat(diseaseDuration);
    simulation.daysOfRestrictions = Number.parseFloat(daysOfRestrictions);
    simulation.infectiousTime = Number.parseFloat(infectiousTime);
    simulation.timeOfOnsetOfSymptoms = Number.parseFloat(onsetOfSymptoms);
    simulation.timeOfDyingFromIncubation = Number.parseFloat(timeOfDying);
    simulation.birthRate = Number.parseFloat(birthRate);
    simulation.naturalDeathRate = Number.parseFloat(naturalDeathRate);
    simulation.quarantineRate = Number.parseFloat(quarantineRate);
    simulation.diseaseDeathRate = Number.parseFloat(diseaseDeathRate);
    simulation.reductionByRestrictions = Number.parseFloat(reductionByRestrictions);
    simulation.percentageOfPopulationWhenRestrictionsBegins = Number.parseFloat(beginsOfRestrictions);

    this.error = seirdsValidation(simulation);

    if (this.error == "")
      this.dialogRef.close(simulation);
  }

  isValid(): boolean {
    return this.nameControl.valid &&
      this.populationControl.valid &&
      this.initialInfectedNumberControl.valid &&
      this.daysOfSimulationControl.valid &&
      this.reproductionRateControl.valid &&
      this.immunityTimeControl.valid &&
      this.incubationTimeControl.valid &&
      this.diseaseDurationControl.valid &&
      this.daysOfRestrictionsControl.valid &&
      this.infectiousTimeControl.valid &&
      this.timeOfOnsetOfSymptomsControl.valid &&
      this.timeOfDyingFromIncubationControl.valid &&
      this.birthRateControl.valid &&
      this.naturalDeathRateControl.valid &&
      this.quarantineRateControl.valid &&
      this.diseaseDeathRateControl.valid &&
      this.reductionByRestrictionsControl.valid &&
      this.percentageOfPopulationWhenRestrictionsBeginsControl.valid
  }
}