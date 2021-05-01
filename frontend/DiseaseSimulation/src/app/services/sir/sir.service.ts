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
  
  public addSimulation(simulation: Sir): Observable<Sir> {
    return this.httpClient.post<Sir>(this.url, simulation);
  }

  public updateSimulation(simulation: Sir): Observable<Sir> {
    return this.httpClient.put<Sir>(this.url, simulation);
  }

  public deleteSimulation(id: number): void {
    let endpoint = "/" + id;
    this.httpClient.delete(this.url + endpoint).subscribe();
  }
}

export class SirRecord {
  infected: number;
  susceptible: number;
  removed: number;
}

export class Sir {
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
