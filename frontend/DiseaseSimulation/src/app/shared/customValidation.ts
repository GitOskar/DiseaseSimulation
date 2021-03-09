import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { Seirds } from '../services/seirds/seirds.service';

export function integer(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const error: ValidationErrors = { integer: true };

    if (control.value && control.value != `${parseInt(control.value, 10)}`) {
      control.setErrors(error);
      return error;
    }

    control.setErrors(null);
    return null;
  };
}

export function seirdsValidation(simulation: Seirds): string {
  
  if (simulation.birthRate > 0.5)
    return "Birth rate is too high. Has to be less than 0.5*"
  else if (simulation.naturalDeathRate > 0.5)
    return "Death rate is too high. Has to be less than 0.5*"
  else if (simulation.population < simulation.initialInfectedNumber)
    return "Population cannot be less than initial infected number*";
  else if (simulation.infectiousTime > simulation.diseaseDuration)
    return "Infectious time cannot be greather than disease duration*";
  else if (simulation.timeOfOnsetOfSymptoms > simulation.diseaseDuration)
    return "Time of onset of symptoms cannot be greather than disease duration*";
  else if (simulation.timeOfDyingFromIncubation > simulation.diseaseDuration)
    return "Time of dying cannot be greather than disease duration*";
  else
    return "";
}