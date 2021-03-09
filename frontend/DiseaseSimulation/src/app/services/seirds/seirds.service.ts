import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeirdsService {

  private url = 'http://localhost:8080/api/seirds';

  constructor(private httpClient: HttpClient) { }

  public getAllSimulations(): Observable<Seirds[]> {
    return this.httpClient.get<Seirds[]>(this.url + '/all');
  } 

  public addSimulation(simulation: Seirds): Observable<Seirds> {
    return this.httpClient.post<Seirds>(this.url, simulation);
  }

  public updateSimulation(simulation: Seirds): Observable<Seirds> {
    return this.httpClient.put<Seirds>(this.url, simulation);
  }

  public deleteSimulation(id: number): void {
    let endpoint = "/" + id;
    this.httpClient.delete(this.url + endpoint).subscribe();
  }
}

export class SeirdsRecord {
  susceptible: number;
  exposed: number;
  infected: number;
  recovered: number;
  deaths: number;
  quarantined: number;
}

export class Seirds {
  id: number;
  name: string;
  population: number;
  initialInfectedNumber: number;
  daysOfSimulation: number;
  reproductionRate: number;
  immunityTime: number;
  incubationTime: number;
  naturalDeathRate: number;
  quarantineRate: number;
  birthRate: number;
  diseaseDuration: number;
  diseaseDeathRate: number;
  reductionByRestrictions: number;
  percentageOfPopulationWhenRestrictionsBegins: number;
  daysOfRestrictions: number;
  infectiousTime: number;
  timeOfOnsetOfSymptoms: number;
  timeOfDyingFromIncubation: number;
  records: SeirdsRecord[];
}
