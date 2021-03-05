import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SirService {

  private url = 'http://localhost:8080/api/sir';

  constructor(private httpClient: HttpClient) { }

  public getAllSimulations(): Observable<Sir[]> {
    return this.httpClient.get<Sir[]>(this.url + '/all');
  } 
}

export interface SirRecord {
  infected: number;
  susceptible: number;
  removed: number;
}

export interface Sir {
  id: number;
  name: string;
  population: number;
  initialInfectedNumber: number;
  diseaseDuration: number;
  daysOfSimulation: number;
  reproductionRate: number;
  birthRate: number;
  deathRate: number;
  records: SirRecord[];
}
