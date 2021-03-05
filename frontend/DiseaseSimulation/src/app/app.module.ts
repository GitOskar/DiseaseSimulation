import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SirComponentComponent } from './simulation-components/sir-component/sir-component.component';
import { SeirdsComponentComponent } from './simulation-components/seirds-component/seirds-component.component';
import { HttpClientModule } from '@angular/common/http';
import { SeirdsChartComponent } from './simulation-components/seirds-component/seirds-chart/seirds-chart.component'

@NgModule({
  declarations: [
    AppComponent,
    SirComponentComponent,
    SeirdsComponentComponent,
    SeirdsChartComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
