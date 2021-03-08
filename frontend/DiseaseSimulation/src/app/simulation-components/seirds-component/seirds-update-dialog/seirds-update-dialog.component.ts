import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Seirds } from 'src/app/services/seirds/seirds.service';
import { integer } from 'src/app/shared/integerValidator';

@Component({
  selector: 'app-seirds-update-dialog',
  templateUrl: './seirds-update-dialog.component.html',
  styleUrls: ['./seirds-update-dialog.component.css']
})
export class SeirdsUpdateDialogComponent {

  error = "example error*";

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
  

  constructor(public dialogRef: MatDialogRef<SeirdsUpdateDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data) {
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

  onUpdateClick(name, population, infected, daysOfSimulation, reproduction, immunity, incubation, diseaseDuration, daysOfRestrictions, infectiousTime, onsetOfSymptoms,
    timeOfDying, birthRate, naturalDeathRate, quarantineRate, diseaseDeathRate, reductionByRestrictions, beginsOfRestrictions) {
   let simulation = new Seirds() ;
   simulation.id = this.data.id;
   simulation.name = name;
   simulation.population = population;
   simulation.initialInfectedNumber = infected;
   simulation.daysOfSimulation = daysOfSimulation;
   simulation.reproductionRate = reproduction;
   simulation.immunityTime = immunity;
   simulation.incubationTime = incubation;
   simulation.diseaseDuration = diseaseDuration;
   simulation.daysOfRestrictions = daysOfRestrictions;
   simulation.infectiousTime = infectiousTime;
   simulation.timeOfOnsetOfSymptoms = onsetOfSymptoms;
   simulation.timeOfDyingFromIncubation = timeOfDying;
   simulation.birthRate = birthRate;
   simulation.naturalDeathRate = naturalDeathRate;
   simulation.quarantineRate = quarantineRate;
   simulation.diseaseDeathRate = diseaseDeathRate;
   simulation.reductionByRestrictions = reductionByRestrictions;
   simulation.percentageOfPopulationWhenRestrictionsBegins = beginsOfRestrictions;

   this.dialogRef.close(simulation);
 }
}
